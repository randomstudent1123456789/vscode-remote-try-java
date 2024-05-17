/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;
//import java.io.Reader;

import java.io.File;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        
        System.out.println("Hello Remote World!");
        //File f = new File("/workspaces/vscode-remote-try-java/src/main/java/com/mycompany/app"); 
        //String[] files = f.list(); 
  
            //System.out.println("Files are:"); 
  
            // Display the names of the files 
            //for (int i = 0; i < files.length; i++) { 
                //System.out.println(files[i]); 
            //} 
        Reader reader = new Reader();
        reader.scan();
        System.out.println("reader");
        System.out.println("Give Analysis? y for yes");
        Scanner scan = new Scanner(System.in);
        //scanner for y/n
        //if(scan.nextLine().equals("y")){
            Analysis analysis = new Analysis(reader);
            analysis.Analysishub();
        //}

        
        
    }
}
