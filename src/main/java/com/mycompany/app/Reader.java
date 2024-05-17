package com.mycompany.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private File file;
    private Scanner scan;
    private String category;
    private ArrayList<String> attributes;
    private ArrayList<Row> data;
    
    public Reader(){
        this("degrees-that-pay-back.csv");
    }

    public Reader(String fname){
        file = new File("/workspaces/vscode-remote-try-java/src/main/java/com/mycompany/app/" + fname);
        // System.out.println(file.exists());
        attributes = new ArrayList<String>();
        data = new ArrayList<Row>();
        category = "";
        try{
            scan = new Scanner(file);
            System.out.println("success");
        }
        catch(Exception e){System.out.println("fail");}
    }

    public String[][] scan(){
        String[][] output = {{}};
        String input = "";
        scan.useDelimiter("\n"); 
        //first row is all Strings
        String temp = scan.next();
        //seperates the terms
        String[] tempA = temp.split(",");
        category = tempA[0];
        for(int i = 1; i<tempA.length; i++){
            attributes.add(tempA[i]);
        }


        while(scan.hasNext()){
            temp = scan.next();
            //System.out.println(temp);
            //the first item is the name of the row we use split to process the string
            tempA = temp.split("," , 2);
            String name = tempA[0];
            
            tempA = (tempA[1]).split("\"");
            ArrayList<Double> tempData = new ArrayList<Double>();
            //for (String item: tempA){
                //System.out.print(item+ ", ");
            //}

            
            for(int i = 1; i<tempA.length; i++){
                String str = tempA[i];
                //System.out.println("before:      " + str);
                str = str.replaceAll("[^\\d.]", "");
                //str = str.replaceAll(".00", "");
                //System.out.println("after:                   "   +str);
                if(!(str.trim().equals(""))){
                    tempData.add(Double.parseDouble(str));
                }
            }
            //Finally store the data
            data.add(new Row(name, tempData));
            //System.out.println("name:  " + name + "   data:   " );
            //for (Double item: tempData){
                //System.out.print(item+ ", ");
            //}
            //input = input + temp;
            //System.out.println(temp);
        }
        //System.out.println("input:                     ");
        //System.out.println(input);
        return output;
    }

    public Scanner getScanner(){
        return scan;
    }

    public File getFile(){
        return file;
    }

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