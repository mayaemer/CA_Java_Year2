package com.lab7.java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Employee extends Person {

	private Job job;
	private int personnelNumber;
	private Date startDate;
	private int nextNumber;
	
	public Employee(String firstName, String surName, Date dateOfBirth, String gender, Job job, int personnelNumber, Date startDate, int nextNumber) {
		super(firstName, surName, dateOfBirth, gender);
		setJob(job);
		setPersonnelNumber(personnelNumber);
		setStartDate(startDate);
		setNextNumber(nextNumber);
		
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getPersonnelNumber() {
		return personnelNumber;
	}

	public void setPersonnelNumber(int personnelNumber) {
		this.personnelNumber = personnelNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNextNumber() {
		return nextNumber;
	}

	public void setNextNumber(int nextNumber) {
		this.nextNumber = nextNumber;
	}
	
	public void writeToFile()
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter file name");
		
		String fileName = myScanner.nextLine();
		FileProcessor newFile = new FileProcessor(fileName);
		newFile.openFile();
		
		System.out.println("Please enter what you want to write to file");
		String writeThis = myScanner.nextLine();
		newFile.writeToFile(writeThis);
		System.out.println("File sucessfully written to.");
		
	}
	
	
	public String toString()
	{
		FileProcessor newFile = new FileProcessor("names.txt");
		newFile.openFile();
		newFile.writeToFile(getFirstName());
				
		String output = super.toString() + "\nJob: " + job + "\nPersonnel Number: " + personnelNumber + "\nStart Date: " + startDate + "\nNext Number: " + nextNumber;
		return output;
		
		
		
	}
	
	
}
