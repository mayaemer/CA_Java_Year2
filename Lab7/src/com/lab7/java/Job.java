package com.lab7.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Job{
	
	private double salary;
	private String role;
	private int jobID;
	
	
	public Job(double salary, String role, int jobID)
	{
		setSalary(salary);
		setRole(role);
		setJobID(jobID);
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) 
	{
		FileProcessor file1 = new FileProcessor("roles#.txt");
		file1.openFile();
		file1.readFile();
		if(file1.roles.contains(role))
		{
			this.role = role;
		}
		else
		{
			this.role= "Invalid role";
		}
	}
	
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
	public String toString()
	{
		String output = "Salary: " + salary + "\nRole: " + role + "\nJob ID: " + jobID;
		return output;
	}

}
