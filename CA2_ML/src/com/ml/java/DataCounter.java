package com.ml.java;

import java.io.IOException;
import java.util.List;

public class DataCounter {

	static double entrepreneurYes = 0;
	static double entrepreneurNo = 0;
	static int femaleYes = 0;
	static int femaleNo =0;
	static int maleYes = 0;
	static int maleNo = 0;
	static int parentYesYes = 0;
	static int parentYesNo = 0;
	static int parentNoYes = 0;
	static int parentNoNo = 0;
	static int jobYesYes = 0;
	static int jobYesNo = 0;
	static int jobNoYes = 0;
	static int jobNoNo =0;
	static int urbanYes = 0;
	static int urbanNo = 0;
	static int ruralYes = 0;
	static int ruralNo = 0;
	static int businessYesYes = 0;
	static int businessYesNo = 0;
	static int businessNoYes = 0;
	static int businessNoNo = 0;	
	ProcessFile file = new ProcessFile();
	
	public DataCounter()
	{
		
	}
	
	public void count() throws IOException
	{
		
		file.readFile();
		
		for(int i =0; i < file.studentsTraining.size(); i++)
		{
			if(file.studentsTraining.get(i).get(0).matches("Female") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				femaleYes++;
			}
			else if(file.studentsTraining.get(i).get(0).matches("Female") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				femaleNo++;
			}
			else if(file.studentsTraining.get(i).get(0).matches("Male") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				maleYes++;
			}
			else if(file.studentsTraining.get(i).get(0).matches("Male") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				maleNo++;
			}
			
		}
		
		System.out.println(femaleYes);
		System.out.println(femaleNo);
		System.out.println(maleYes);
		System.out.println(maleNo);
		
		
	}
	
	public void countParents() throws IOException
	{
		file.readFile();
		
		for(int i =0; i < file.studentsTraining.size(); i++)
		{
			if(file.studentsTraining.get(i).get(1).matches("Yes") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				parentYesYes++;
			}
			else if(file.studentsTraining.get(i).get(1).matches("Yes") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				parentYesNo++;
			}
			else if(file.studentsTraining.get(i).get(1).matches("No") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				parentNoYes++;
			}
			else if(file.studentsTraining.get(i).get(1).matches("No") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				parentNoNo++;
			}
		}
		System.out.println(parentYesYes);
		System.out.println(parentYesNo);
		System.out.println(parentNoYes);
		System.out.println(parentNoNo);
	}
	
	public void countJob() throws IOException
	{
		file.readFile();
		
		for(int i =0; i < file.studentsTraining.size(); i++)
		{
			
			if(file.studentsTraining.get(i).get(2).matches("Yes") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				jobYesYes++;
			}
			else if(file.studentsTraining.get(i).get(2).matches("Yes") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				jobYesNo++;
			}
			else if(file.studentsTraining.get(i).get(2).matches("No") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				jobNoYes++;
			}
			else if(file.studentsTraining.get(i).get(2).matches("No") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				jobNoNo++;
			}
		}
		System.out.println(jobYesYes);
		System.out.println(jobYesNo);
		System.out.println(jobNoYes);
		System.out.println(jobNoNo);
	}
	
	public void countUrbanRural() throws IOException
	{
		file.readFile();
		
		for(int i =0; i < file.studentsTraining.size(); i++)
		{
			//System.out.println(file.students);
			
			if(file.studentsTraining.get(i).get(3).contains("Urban") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				urbanYes++;
			}
			else if(file.studentsTraining.get(i).get(3).contains("Urban") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				urbanNo++;
			}
			else if(file.studentsTraining.get(i).get(3).matches("Rural") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				ruralYes++;
			}
			else if(file.studentsTraining.get(i).get(3).matches("Rural") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				ruralNo++;
			}
		}
		System.out.println(urbanYes);
		System.out.println(urbanNo);
		System.out.println(ruralYes);
		System.out.println(ruralNo);
	}
	
	public void countBusiness() throws IOException
	{
		file.readFile();
		
		for(int i =0; i < file.studentsTraining.size(); i++)
		{
			
			if(file.studentsTraining.get(i).get(4).matches("Yes") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				businessYesYes++;
			}
			else if(file.studentsTraining.get(i).get(4).contains("Yes") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				businessYesNo++;
			}
			else if(file.studentsTraining.get(i).get(4).matches("No") && file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				businessNoYes++;
			}
			else if(file.studentsTraining.get(i).get(4).matches("No") && file.studentsTraining.get(i).get(5).matches("No"))
			{
				businessNoNo++;
			}
		}
		System.out.println(businessYesYes);
		System.out.println(businessYesNo);
		System.out.println(businessNoYes);
		System.out.println(businessNoNo);
	}
	
	public void countEntrepreneurs() throws IOException
	{
		file.readFile();
		
		for(int i =0; i < file.studentsTraining.size(); i++)
		{
			
			if(file.studentsTraining.get(i).get(5).matches("Yes"))
			{
				entrepreneurYes++;
			}
			else if(file.studentsTraining.get(i).get(5).matches("No"))
			{
				entrepreneurNo++;
			}
		
		}
		//System.out.println(entrepreneurYes);
		//System.out.println(entrepreneurNo);
		
	}
	}
