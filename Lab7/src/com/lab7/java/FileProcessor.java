package com.lab7.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {
	private String fileName;
	private File fileExample;
	static String roles;

	
	public FileProcessor(String fileName)
	{
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getFileExample() {
		return fileExample;
	}

	public void setFileExample(File fileExample) {
		this.fileExample = fileExample;
	}
	
	public void openFile()
	{
		fileExample= new File(fileName);
	}
	
	public String readFile()
	{
		String line = "Line not read";
	
		
		try {
			Scanner scanner1 = new Scanner(fileExample);
			while(scanner1.hasNextLine())
			{
				line = scanner1.nextLine();
				roles += line;
			}
		
		
			
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Could not find file");
			e.printStackTrace();
		}
		return line;
	}
	
	public void writeToFile(String writeThisLine)
	{
		try {
			PrintWriter myWriter = new PrintWriter(fileExample);// takes a file object
			myWriter.println(writeThisLine);
			myWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
	}


}
