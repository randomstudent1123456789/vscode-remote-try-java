/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;



public class App {
    public static void main(String[] args) {
        
        //System.out.println("Hello Remote World!");
        
        //creates a reader object to read the csv file and scan it
        Reader reader = new Reader();
        reader.scan();
        
        //creates an analysis class that will print out various statistics about it
        Analysis analysis = new Analysis(reader);
        analysis.Analysishub();

        
        
    }
}
