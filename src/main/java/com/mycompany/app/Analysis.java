package com.mycompany.app;

//import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Analysis {
    private String category;
    private ArrayList<String> attributes;
    private ArrayList<Row> data;
    private String[] charts;
    

    public Analysis(Reader reader){
        data = reader.getData();
        category = reader.getCategory();
        attributes = reader.getAttributes();
    }

    public void Analysishub(){
        for(int i = 0; i<attributes.size();i++){
            //find max
            System.out.print("Maximum  "+ attributes.get(i) +" is ");
            int temp = findMax(i);
            System.out.print(data.get(temp).getName() + " with a " + data.get(temp).getData().get(i) + "\n");
            //find min
            System.out.print("Minimum  "+ attributes.get(i) +" is ");
            temp = findMin(i);
            System.out.print(data.get(temp).getName() + " with a " + data.get(temp).getData().get(i) + "\n");
            //find average
            System.out.print("Average  "+ attributes.get(i) +" is " + findAverage(i) + "\n");
        }
    }

    public int findMax(int i){
        double max = data.get(0).getData().get(i);
        int maxI = 0;
        for(int r = 1; r<data.size(); r++){
            if(data.get(r).getData().get(i)>max){
                max = data.get(r).getData().get(i);
                maxI = r;
            }
        }
        return maxI;

    }

    public int findMin(int i){
        double min = data.get(0).getData().get(i);
        int minI = 0;
        for(int r = 1; r<data.size(); r++){
            if(data.get(r).getData().get(i)<min){
                min = data.get(r).getData().get(i);
                minI = r;
            }
        }
        return minI;

    }

    public Double findAverage(int i){
        double Average = 0;
        for(int r = 0; r<data.size(); r++){
            Average = Average+ data.get(r).getData().get(i);
        }
        return Average;

    }


    



}


