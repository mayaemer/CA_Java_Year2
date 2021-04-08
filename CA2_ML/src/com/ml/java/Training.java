package com.ml.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Training {
	
	// create instance of process file
	ProcessFile file = new ProcessFile();
	
	// create List of Lists students training to store training data
	static List<List<String>> studentsTraining = new ArrayList<>();
	
	// var to hold number/ amount of data for training
	private static double training;
	
	// vars to store totals of each attribute in each row
	private static double labelYes=0;
	private static double labelNo=0;
	private static double femaleYes=0;
	private static double femaleNo=0;
	private static double maleYes=0;
	private static double maleNo=0;
	private static double parentYesYes = 0;
	private static double parentYesNo = 0;
	private static double parentNoYes = 0;
	private static double parentNoNo = 0;
	private static double jobYesYes = 0;
	private static double jobYesNo = 0;
	private static double jobNoYes = 0;
	private static double jobNoNo =0;
	private static double urbanYes = 0;
	private static double urbanNo = 0;
	private static double ruralYes = 0;
	private static double ruralNo = 0;
	private static double businessYesYes = 0;
	private static double businessYesNo = 0;
	private static double businessNoYes = 0;
	private static double businessNoNo = 0;
	
	// index for loops
	private int i; 
	private int j;
			
	//constructor
	public Training()
	{
		
	}
	
	//Getters and Setters
	public static double getTraining() {
		return training;
	}
	
	public static void setTraining(double training) {
		Training.training = training;
	}
	
	public static double getLabelYes() {
		return labelYes;
	}

	public static void setLabelYes(double labelYes) {
		Training.labelYes = labelYes;
	}

	public static double getLabelNo() {
		return labelNo;
	}

	public static void setLabelNo(double labelNo) {
		Training.labelNo = labelNo;
	}

	public static double getFemaleYes() {
		return femaleYes;
	}

	public static void setFemaleYes(double femaleYes) {
		Training.femaleYes = femaleYes;
	}

	public static double getFemaleNo() {
		return femaleNo;
	}

	public static void setFemaleNo(double femaleNo) {
		Training.femaleNo = femaleNo;
	}

	public static double getMaleYes() {
		return maleYes;
	}

	public static void setMaleYes(double maleYes) {
		Training.maleYes = maleYes;
	}

	public static double getMaleNo() {
		return maleNo;
	}

	public static void setMaleNo(double maleNo) {
		Training.maleNo = maleNo;
	}

	public static double getParentYesYes() {
		return parentYesYes;
	}

	public static void setParentYesYes(double parentYesYes) {
		Training.parentYesYes = parentYesYes;
	}

	public static double getParentYesNo() {
		return parentYesNo;
	}

	public static void setParentYesNo(double parentYesNo) {
		Training.parentYesNo = parentYesNo;
	}

	public static double getParentNoYes() {
		return parentNoYes;
	}

	public static void setParentNoYes(double parentNoYes) {
		Training.parentNoYes = parentNoYes;
	}

	public static double getParentNoNo() {
		return parentNoNo;
	}

	public static void setParentNoNo(double parentNoNo) {
		Training.parentNoNo = parentNoNo;
	}

	public static double getJobYesYes() {
		return jobYesYes;
	}

	public static void setJobYesYes(double jobYesYes) {
		Training.jobYesYes = jobYesYes;
	}

	public static double getJobYesNo() {
		return jobYesNo;
	}

	public static void setJobYesNo(double jobYesNo) {
		Training.jobYesNo = jobYesNo;
	}

	public static double getJobNoYes() {
		return jobNoYes;
	}

	public static void setJobNoYes(double jobNoYes) {
		Training.jobNoYes = jobNoYes;
	}

	public static double getJobNoNo() {
		return jobNoNo;
	}

	public static void setJobNoNo(double jobNoNo) {
		Training.jobNoNo = jobNoNo;
	}

	public static double getUrbanYes() {
		return urbanYes;
	}

	public static void setUrbanYes(double urbanYes) {
		Training.urbanYes = urbanYes;
	}

	public static double getUrbanNo() {
		return urbanNo;
	}

	public static void setUrbanNo(double urbanNo) {
		Training.urbanNo = urbanNo;
	}

	public static double getRuralYes() {
		return ruralYes;
	}

	public static void setRuralYes(double ruralYes) {
		Training.ruralYes = ruralYes;
	}

	public static double getRuralNo() {
		return ruralNo;
	}

	public static void setRuralNo(double ruralNo) {
		Training.ruralNo = ruralNo;
	}

	public static double getBusinessYesYes() {
		return businessYesYes;
	}

	public static void setBusinessYesYes(double businessYesYes) {
		Training.businessYesYes = businessYesYes;
	}

	public static double getBusinessYesNo() {
		return businessYesNo;
	}

	public static void setBusinessYesNo(double businessYesNo) {
		Training.businessYesNo = businessYesNo;
	}

	public static double getBusinessNoYes() {
		return businessNoYes;
	}

	public static void setBusinessNoYes(double businessNoYes) {
		Training.businessNoYes = businessNoYes;
	}

	public static double getBusinessNoNo() {
		return businessNoNo;
	}

	public static void setBusinessNoNo(double businessNoNo) {
		Training.businessNoNo = businessNoNo;
	}	
	
	// takes in percent of data to be used
	// reads file in ProcessFile
	// set training to data List multiplied by the percentage (e.g. 0.70)
	public void countData(double percent) throws IOException
	{
		file.readFile();
		training = (int) (file.data.size()*percent);
		
		// for the length of training, add the List from data List to studentsTraining List
		for(i=0; i< training; i++)
		{
			studentsTraining.add(file.data.get(i));
		}
		
		// for each element in studentsTraining,
		// if elemented 5 = Yes, increment labelYes
		// else if = No, increment labelNo to gather total with outcome yes
		// vs total with outcome no
		for(List<String> element: studentsTraining)
		{
			
			if(element.get(5).matches("Yes"))
			{
				labelYes++;
			}
			else if(element.get(5).matches("No"))
			{
				labelNo++;
			}
		}
		
		//System.out.println(labelYes);
		//System.out.println(labelNo);
		
		for(j=0; j< training; j++)
		{
					
			if(studentsTraining.get(j).get(0).matches("Female") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				femaleYes++;
						
			}
			else if(studentsTraining.get(j).get(0).matches("Female") && studentsTraining.get(j).get(5).matches("No"))
			{
				femaleNo++;
			}
			else if(studentsTraining.get(j).get(0).matches("Male") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				maleYes++;
			}
			else if(studentsTraining.get(j).get(0).matches("Male") && studentsTraining.get(j).get(5).matches("No"))
			{
				maleNo++;
			}
				
			
		}
		
		//System.out.println(femaleYes);
		//System.out.println(femaleNo);
		//System.out.println(maleYes);
		//System.out.println(maleNo);
		
		for(j=0; j< training; j++)
		{
					
			if(studentsTraining.get(j).get(1).matches("Yes") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				parentYesYes++;
						
			}
			else if(studentsTraining.get(j).get(1).matches("Yes") && studentsTraining.get(j).get(5).matches("No"))
			{
				parentYesNo++;
			}
			else if(studentsTraining.get(j).get(1).matches("No") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				parentNoYes++;
			}
			else if(studentsTraining.get(j).get(1).matches("No") && studentsTraining.get(j).get(5).matches("No"))
			{
				parentNoNo++;
			}
		}
		
		//System.out.println(parentYesYes);
		//System.out.println(parentYesNo);
		//System.out.println(parentNoYes);
		//System.out.println(parentNoNo);
		
		for(j=0; j< training; j++)
		{
					
			if(studentsTraining.get(j).get(2).matches("Yes") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				jobYesYes++;
						
			}
			else if(studentsTraining.get(j).get(2).matches("Yes") && studentsTraining.get(j).get(5).matches("No"))
			{
				jobYesNo++;
			}
			else if(studentsTraining.get(j).get(2).matches("No") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				jobNoYes++;
			}
			else if(studentsTraining.get(j).get(2).matches("No") && studentsTraining.get(j).get(5).matches("No"))
			{
				jobNoNo++;
			}
		}
		//System.out.println(jobYesYes);
		//System.out.println(jobYesNo);
		//System.out.println(jobNoYes);
		//System.out.println(jobNoNo);
		
		for(j=0; j< training; j++)
		{
					
			if(studentsTraining.get(j).get(3).contains("Urban") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				urbanYes++;
						
			}
			else if(studentsTraining.get(j).get(3).contains("Urban") && studentsTraining.get(j).get(5).matches("No"))
			{
				urbanNo++;
			}
			else if(studentsTraining.get(j).get(3).matches("Rural") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				ruralYes++;
			}
			else if(studentsTraining.get(j).get(3).matches("Rural") && studentsTraining.get(j).get(5).matches("No"))
			{
				ruralNo++;
			}
		}
		//System.out.println(urbanYes);
		//System.out.println(urbanNo);
		//System.out.println(ruralYes);
		//System.out.println(ruralNo);
		
		for(j=0; j< training; j++)
		{
					
			if(studentsTraining.get(j).get(4).contains("Yes") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				businessYesYes++;
						
			}
			else if(studentsTraining.get(j).get(4).contains("Yes") && studentsTraining.get(j).get(5).matches("No"))
			{
				businessYesNo++;
			}
			else if(studentsTraining.get(j).get(4).matches("No") && studentsTraining.get(j).get(5).matches("Yes"))
			{
				businessNoYes++;
			}
			else if(studentsTraining.get(j).get(4).matches("No") && studentsTraining.get(j).get(5).matches("No"))
			{
				businessNoNo++;
			}
		}
		//System.out.println(businessYesYes);
		//System.out.println(businessYesNo);
		//System.out.println(businessNoYes);
		//System.out.println(businessNoNo);
	}


	
}

	



