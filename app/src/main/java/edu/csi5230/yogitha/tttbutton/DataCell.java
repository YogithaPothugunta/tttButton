package edu.csi5230.yogitha.tttbutton;

import java.util.ArrayList;
import java.util.Observable;


public class DataCell extends Observable {
    ArrayList<tttButton> observers = new ArrayList<tttButton>();
    private String value=null;

    public DataCell(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
        setChanged();
        notifyObservers(value);
    }
}
