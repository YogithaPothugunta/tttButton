package edu.csi5230.yogitha.tttbutton;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Player[] players = new Player[2];
    Player currentPlayer = null;
    tttButton[] tttButton = new tttButton[9];
    DataCell[] cells = new DataCell[9];
    int current=0;

    void swapPlayer(){
        currentPlayer = currentPlayer == players[0] ? players[1] : players[0];
        TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
        textViewToChange.setText("Player "+currentPlayer.getPlayerSymbol()+"'s Turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentPlayer = players[0] = new Player("Player 1","X");
        players[1] = new Player("Player 2","O");

        for(int i=0;i<9;i++) {
            tttButton[i]= (tttButton) findViewById(R.id.firstBtn+i);
            tttButton[i].setOnClickListener(this);

            cells[i] = new DataCell("");
            cells[i].addObserver(tttButton[i]);
        }
    }

    @Override
    public void onClick(View view) {
        current++;
        tttButton currentBtn = (tttButton) view;
        int index = currentBtn.getIndex();
        cells[index-1].setValue(currentPlayer.getPlayerSymbol());
        boolean gameWon = false;

        if(current>=4){
            if(cells[0].getValue()==currentPlayer.getPlayerSymbol() && cells[1].getValue()==currentPlayer.getPlayerSymbol() && cells[2].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
            }
            if(cells[3].getValue()==currentPlayer.getPlayerSymbol() && cells[4].getValue()==currentPlayer.getPlayerSymbol() && cells[5].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
            }
            if(cells[6].getValue()==currentPlayer.getPlayerSymbol() && cells[7].getValue()==currentPlayer.getPlayerSymbol() && cells[8].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
            }
            if(cells[0].getValue()==currentPlayer.getPlayerSymbol() && cells[3].getValue()==currentPlayer.getPlayerSymbol() && cells[6].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
            }
            if(cells[1].getValue()==currentPlayer.getPlayerSymbol() && cells[4].getValue()==currentPlayer.getPlayerSymbol() && cells[7].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
            }
            if(cells[2].getValue()==currentPlayer.getPlayerSymbol() && cells[5].getValue()==currentPlayer.getPlayerSymbol() && cells[8].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
            }
            if(cells[0].getValue()==currentPlayer.getPlayerSymbol() && cells[4].getValue()==currentPlayer.getPlayerSymbol() && cells[8].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
            }
            if(cells[2].getValue()==currentPlayer.getPlayerSymbol() && cells[4].getValue()==currentPlayer.getPlayerSymbol() && cells[6].getValue()==currentPlayer.getPlayerSymbol()){
                TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
                textViewToChange.setText("Game Over!! Player "+currentPlayer.getPlayerSymbol()+" won!!");
                gameWon=true;
                disableButtons();
            }
        }
        if(gameWon==false)
            swapPlayer();
        Log.e("test"," "+index);
        currentBtn.setEnabled(false);
        if(gameWon==true)
            disableButtons();
        else if(gameWon==false && current==9){
            TextView textViewToChange = (TextView) findViewById(R.id.labelGame);
            textViewToChange.setText("Game Draw");
        }
    }
    public void disableButtons(){
        for(int i=0;i<9;i++) {
            tttButton[i]= (tttButton) findViewById(R.id.firstBtn+i);
            tttButton[i].setEnabled(false);
        }
    }
}