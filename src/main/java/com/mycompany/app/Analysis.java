package com.mycompany.app;

//import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.jfree.chart.*;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtils;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Analysis {
    private JFreeChart chart;
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
        System.out.println("Which attribute?");
        chart = createBarChart();
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Which attribute?");
        //for(String item: attributes){
            //System.out.print("  " + item + "?");
        //}
        int i = 0;
        //if(!(scan2.nextLine().equals(""))){
            //for(int i = 0; i <attributes.size(); i++){
                //if(scan2.nextLine().equals(attributes.get(i))){
                    selectChart(i);
                //}
            //}
        //}
    }

    public void selectChart(int k){
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Which chart?");
        //for(String item: charts){
            //System.out.print("  " + item + "?");
        //}
        //if(!(scan2.nextLine().equals(""))){
            //for(int i = 0; i <charts.length; i++){
                //if(scan2.nextLine().equals(charts[i])){
                    //if(i == 0){
                        testPlot();
                    //}else if(i == 1){

                    //}
                //}
            //}
        //}
    }

    private static JFreeChart createBarChart() {
        Number[][] data = new Integer[][] {{-3, -2}, {-1, 1}, {2, 3}};
        //<String, String>
        CategoryDataset dataset 
                = DatasetUtils.createCategoryDataset("S", "C", data);
        return ChartFactory.createBarChart("Bar Chart", "Domain", "Range", 
                dataset, PlotOrientation.HORIZONTAL, true, true, true);
    }

    public void testPlot(){
        try {
            BufferedImage image = new BufferedImage(200 , 100,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            this.chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null,
                    null);
            g2.dispose();
        }
        catch (Exception e) {
            //fail("There should be no exception.");
        }
    }

}


