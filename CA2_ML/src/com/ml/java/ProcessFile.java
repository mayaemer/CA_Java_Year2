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
	
	private String fileName = "MLdata.csv";
	final static List<List<String>> studentsTraining = new ArrayList<>();
	final static List<List<String>> studentsTesting = new ArrayList<>();
	
	public ProcessFile ()
	{
		this.fileName = fileName;
	}
	
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
				
				studentsTraining.add(asList);
			}
			
			for(int i=202; i< studentsTraining.size(); i++)
			{
				studentsTesting.add(studentsTraining.get(i));
				studentsTraining.remove(i);
			}
			
		
	
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
}
