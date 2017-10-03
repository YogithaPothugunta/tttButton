package edu.csi5230.yogitha.tttbutton;

/**
 * Created by Priyanka on 10/1/2017.
 */

public class Player {
    private String playerName;
    private String playerSymbol;

    public Player(String Name, String Symbol) {
        this.playerName=Name;
        this.playerSymbol=Symbol;
    }



    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String player){
        this.playerName = player;
    }
    public String getPlayerSymbol(){
        return playerSymbol;
    }
    public void setPlayerSymbol(String symbol){
        this.playerSymbol = symbol;
    }
}
