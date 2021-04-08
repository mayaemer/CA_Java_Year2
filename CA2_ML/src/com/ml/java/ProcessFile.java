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
	static List<List<String>> data = new ArrayList<>();
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public ProcessFile ()
	{
		setFileName(fileName);
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
				
				data.add(asList);
			}
			
	
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
}
