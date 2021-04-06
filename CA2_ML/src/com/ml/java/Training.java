package com.ml.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Training {
	
	private double training;
	ProcessFile file = new ProcessFile("MLdata.csv");
	static List<List<String>> studentsTraining = new ArrayList<>();
	static List<List<String>> studentsTesting = new ArrayList<>();
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
	int i; 
	int j;
	
	public Training()
	{
		
	}
	
	public void countData() throws IOException
	{
		file.readFile();
		training = (int) (ProcessFile.data.size()*0.7);
		
		
		for(i=0; i< training; i++)
		{
			studentsTraining.add(ProcessFile.data.get(i));
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
	
	public void getTestData() throws IOException
	{
		countData();
		for(i = studentsTraining.size(); i < file.data.size(); i++)
		{
			studentsTesting.add(file.data.get(i));
		}
		//System.out.println(studentsTesting.size());
	}
	
	public void trainData() throws IOException
	{
		getTestData();
		
		//calculate prior
		double priorYes = labelYes / training;
		double priorNo = labelNo/ training;	
		
		//empty variables to hold probability of yea/no
		double probYes ;
		double probNo;
		
		
		double correct = 0;
		double wrong = 0;
		
		// for every element in training 
		for(j=0; j< studentsTesting.size(); j++)
		{
			// empty variables for numerator, for outcome yes and outcome no
			double yesNumerator = 0;
			double noNumerator = 0;
			
			// empty variable for denominator
			double denom = 0;
			
			//empty string vars
			String yesAttribs = "";
			String noAttribs = "";
			
			/**if first element in students training = specified element, 
			 * calculate the denom for specified element and and add to denom var (after first element, multiply the denom var by the new denom),
			 * calculate the numerator for outcome yes, add to yesNumerator var (after first element, multiply the yesNumerator var by the new yesNuerator),
			 * calculate the numerator for outcome no, add to noNumerator var (after first element, multiply the noNumerator var by the new noNumerator)
			 */
			
			if(studentsTesting.get(j).get(0).matches("Female"))
			{
				denom = ((femaleYes + femaleNo) / training);
				yesNumerator = (femaleYes/ labelYes);
				noNumerator = (femaleNo/ labelNo);
			
			}
			else if(studentsTesting.get(j).get(0).matches("Male"))
			{
				denom = ((maleYes + maleNo)/ training);
				yesNumerator = (maleYes/ labelYes);
				noNumerator = (maleNo/ labelNo);
			
			}
			
			if(studentsTesting.get(j).get(1).matches("Yes"))
			{
				denom = denom * ((parentYesYes + parentYesNo)/ training);
				yesNumerator = yesNumerator * (parentYesYes /labelYes);
				noNumerator = noNumerator * (parentYesNo / labelNo);	
			
			}
			else if(studentsTesting.get(j).get(1).matches("No"))
			{
				denom = denom * ((parentNoYes + parentNoNo)/ training);
				yesNumerator = yesNumerator * (parentNoYes /labelYes);
				noNumerator = noNumerator * (parentNoNo / labelNo);
				
			}
			
			if(studentsTesting.get(j).get(2).matches("Yes"))
			{
				denom = denom * ((jobYesYes + jobYesNo)/ training);
				yesNumerator = yesNumerator * (jobYesYes /labelYes);
				noNumerator = noNumerator * (jobYesNo / labelNo);
						
			}
			else if(studentsTesting.get(j).get(2).matches("No"))
			{
				denom = denom * ((jobNoYes + jobNoNo)/ training);
				yesNumerator = yesNumerator * (jobNoYes /labelYes);
				noNumerator = noNumerator * (jobNoNo / labelNo);

			}
			
			if(studentsTesting.get(j).get(3).contains("Urban"))
			{
				denom = denom * ((urbanYes + urbanNo)/ training);
				yesNumerator = yesNumerator * (urbanYes /labelYes);
				noNumerator = noNumerator * (urbanNo / labelNo);
			
			}
			else if(studentsTesting.get(j).get(3).matches("Rural"))
			{
				denom = denom * ((ruralYes + ruralNo)/ training);
				yesNumerator = yesNumerator * (ruralYes /labelYes);
				noNumerator = noNumerator * (ruralNo / labelNo);
				
			}
			
			if(studentsTesting.get(j).get(4).matches("Yes"))
			{
				denom = denom * ((businessYesYes + businessYesNo)/ training);
				yesNumerator = yesNumerator * (businessYesYes /labelYes);
				noNumerator = noNumerator * (businessYesNo / labelNo);
				
			}
			else if(studentsTesting.get(j).get(4).matches("No"))
			{
				denom = denom * ((businessNoYes + businessNoNo)/ training);
				yesNumerator = yesNumerator * (businessNoYes /labelYes);
				noNumerator = noNumerator * (businessNoNo / labelNo);
				
			}
			
			probYes = (yesNumerator * priorYes) / denom;
			probNo = (noNumerator * priorNo) / denom; 
			
			
	
			if(probYes > probNo && studentsTesting.get(j).get(5).matches("Yes"))
			{
				correct++;
			}
			else if(probNo > probYes && studentsTesting.get(j).get(5).matches("No"))
			{
				correct++;
			}
			else
			{
				wrong++;
			}
		}	

		correct = (correct / studentsTesting.size()) * 100;
		System.out.println("Accuracy: " + (double) Math.round(correct * 100)/100 + "%");
		
	}
}

	



