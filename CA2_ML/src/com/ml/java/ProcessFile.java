package com.ml.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProcessFile {
	
	// private string var to hold file name
	private String fileName = "MLdata.csv";
	// static List of Lists called data to store the info from csv file
	static List<List<String>> data = new ArrayList<>();
	
	
	//constructor
	public ProcessFile ()
	{
		setFileName(fileName);
	}
	
	
	//Getters and Setters
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	// reads file line by line, adding each line into empty string var 'line'
	// reads through first three lines of non relative data
	// while next line isnt null
	//splits 'line' into separate strings at the comma and add to String array 'split'
	// convert string array into List
	// add List to data List of Lists
	public void readFile() throws IOException
	{
		try {
			BufferedReader myBuffer = new BufferedReader(new FileReader(fileName));
			String line = "";
			
			myBuffer.readLine();
			myBuffer.readLine();
			myBuffer.readLine();
			
			while((line = myBuffer.readLine()) != null)
			{
				String[] split = line.split(",");
				List asList = Arrays.asList(split);
				
				data.add(asList);
			}
	
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
}
