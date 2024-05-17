package com.mycompany.app;
import java.util.ArrayList;

public class Row {
    //every row object has a name identifier(the first item in row in the CSV) and the actually number data stored in an arraylist
    private String rName;
    private ArrayList<Double> rData;

    //basic constructor
    public Row(String name, ArrayList<Double> data){
        rName = name;
        rData = data;
    }


    //to string method that outputs the name and data
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

    //basic return methods
    public String getName(){
        return rName;
    }

    public ArrayList<Double> getData(){
        return rData;
    }

}
