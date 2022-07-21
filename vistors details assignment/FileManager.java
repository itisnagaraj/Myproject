package com.sarvesh.visitorsdetails;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class FileManager {
	 static public File createFile()
	    {
	        File file =new File("visitors.txt");
	try{      file.createNewFile();}
	catch (IOException e)   
	{  
	e.printStackTrace();    //prints exception if any  
	}      

	    return file;
	    }
	   //change the return type as per the requirement    
	    static public void writeFile(File f, String record)
	    {    try { 


	            BufferedWriter out = new BufferedWriter( 
	                   new FileWriter(f.getName(), true)); 
	            out.write(record+";"); 
	            out.close(); 
	        } 
	        catch (IOException e) { 
	            System.out.println("exception occoured" + e); 
	        } 

	    } 
	    static public String[] readFile(File f)
	    {

	        List<String> tokens = new ArrayList<String>();
	        try{
	      File myObj = new File(f.getName());
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {

	        // String [] arr= myReader.nextLine().split(";");
	        // tokens = Arrays.asList(arr);
	        tokens.add(myReader.nextLine());

	      }

	      myReader.close();
	      }
	       catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    String[] tokenArray = tokens.toArray(new String[0]);
	    //=tokenArray.split(";");
	    return tokenArray;
	    }

}
