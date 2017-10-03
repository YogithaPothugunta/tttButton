package edu.csi5230.yogitha.tttbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Priyanka on 9/26/2017.
 */

public class tttButton extends Button implements Observer {
    int index=0;
    public tttButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        String packageName = "http://schemas.android.com/apk/res-auto";
        index = attrs.getAttributeIntValue(packageName,"index",0);  //default value 0 will be returned
        setText(Integer.toString(index));
    }

    public int getIndex(){
        return index;
    }

    @Override
    public void update(Observable o, Object arg) {
        String symbol = (String) arg;
        System.out.println(arg + " " + ((DataCell)o).getValue());
        setText(symbol);
    }
}