package com.mycompany.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    //various private variables to store data some are intuitive. category is the first rows first column. And attributes are the first rows elements excluding the first one
    //all other rows are stored as row objects 
    private File file;
    private Scanner scan;
    private String category;
    private ArrayList<String> attributes;
    private ArrayList<Row> data;
    
    //default constructor
    public Reader(){
        this("degrees-that-pay-back.csv");
    }

    //constructor that takes in file name and reads the file will give a fail if file DOE
    public Reader(String fname){
        file = new File("/workspaces/vscode-remote-try-java/src/main/java/com/mycompany/app/" + fname);
        // System.out.println(file.exists());
        attributes = new ArrayList<String>();
        data = new ArrayList<Row>();
        category = "";
        try{
            //calls scan method to find info in the file
            scan = new Scanner(file);
            System.out.println("success");
        }
        catch(Exception e){System.out.println("fail");}
    }

    //reads and collects data from the csv
    public String[][] scan(){
        String[][] output = {{}};
        scan.useDelimiter("\n"); 
        //the scanner takes the csv row by row with each row being a string
        //first row is all Strings/label data so we put that into attributes and the name of the category
        String temp = scan.next();
        //seperates the terms using split
        String[] tempA = temp.split(",");
        category = tempA[0];
        for(int i = 1; i<tempA.length; i++){
            attributes.add(tempA[i]);
        }

        //iterates through the rest of the data and stores them as rows
        while(scan.hasNext()){
            temp = scan.next();
            //System.out.println(temp);


            //the first item is the name of the row and we use split to process the string by separating the first data(the name of the row) from the rest
            tempA = temp.split("," , 2);
            String name = tempA[0];
            
            //splits the rest of the data on double quotes which results in some empty strings
            tempA = (tempA[1]).split("\"");
            ArrayList<Double> tempData = new ArrayList<Double>();
            

            //iterates through the array list of data and stores datapoints as row objects
            for(int i = 1; i<tempA.length; i++){
                String str = tempA[i];
                //gets rid of dollar signs and unwanted symbols
                str = str.replaceAll("[^\\d.]", "");
                
                //ignores empty strings
                if(!(str.trim().equals(""))){
                    tempData.add(Double.parseDouble(str));
                }
            }
            //Finally store the data in an arraylist of rows called data
            data.add(new Row(name, tempData));
            
        }
        
        return output;
    }
    //some basic return methods
    public Scanner getScanner(){
        return scan;
    }

    public File getFile(){
        return file;
    }

    //basic to string method
    public String toString(){
        String output = category;
        for(String item: attributes ){
            output = output + " ," + item;
        }
        output = output + "\n";
        for(Row item: data){
            output = output + item + "\n";
        }
        return output;
    }

    public ArrayList<Row> getData(){
        return data;
    }

    public ArrayList<String> getAttributes(){
        return attributes;
    }

    public String getCategory(){
        return category;
    }


}