package com.mycompany.app;
import java.util.ArrayList;

public class Row {
    private String rName;
    private ArrayList<Double> rData;

    public Row(String name, ArrayList<Double> data){
        rName = name;
        rData = data;
    }

    public String toString(){
        String output = "[";
        for (int i = 0; i<rData.size(); i ++){
            output = output + rData.get(i);
            if(!(i==rData.size()-1)){
                output = output + ", ";
            }else{
                output = output + "]";
            }
        }

        return "name: " + rName + " data: " + output; 
    }

    public String getName(){
        return rName;
    }

    public ArrayList<Double> getData(){
        return rData;
    }

}
