package com.ml.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Training {
	
	private int training;
	ProcessFile file = new ProcessFile("MLdata.csv");
	static List<List<String>> studentsTraining = new ArrayList<>();
	double labelYes=0;
	double labelNo=0;
	double femaleYes=0;
	double femaleNo=0;
	double maleYes=0;
	double maleNo=0;
	double parentYesYes = 0;
	double parentYesNo = 0;
	double parentNoYes = 0;
	double parentNoNo = 0;
	double jobYesYes = 0;
	double jobYesNo = 0;
	double jobNoYes = 0;
	double jobNoNo =0;
	double urbanYes = 0;
	double urbanNo = 0;
	double ruralYes = 0;
	double ruralNo = 0;
	double businessYesYes = 0;
	double businessYesNo = 0;
	double businessNoYes = 0;
	double businessNoNo = 0;
	
	public Training()
	{
		
	}
	
	public void countData() throws IOException
	{
		file.readFile();
		training = (int) (file.data.size()*0.7);
		int i; 
		int j;
		
		for(i=0; i< training; i++)
		{
			studentsTraining.add(file.data.get(i));
		}
		
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
		
		System.out.println(labelYes);
		System.out.println(labelNo);
		
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
	



