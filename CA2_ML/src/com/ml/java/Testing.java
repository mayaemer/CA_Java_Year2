package com.ml.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Testing {

	Training t = new Training();
	ProcessFile file = new ProcessFile();
	static List<List<String>> studentsTesting = new ArrayList<>();
	private int i;
	private int j;
	private String outcome;
	List<String> outcomes = new ArrayList<>();
	//empty variables to hold probability of yea/no
	private double probYes;
	private double probNo;

	public double getProbYes() {
		return probYes;
	}

	public void setProbYes(double probYes) {
		this.probYes = probYes;
	}

	public double getProbNo() {
		return probNo;
	}

	public void setProbNo(double probNo) {
		this.probNo = probNo;
	}
	
	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	
	public void getTestData() throws IOException
	{
		for(i = t.studentsTraining.size(); i < file.data.size(); i++)
		{
			studentsTesting.add(file.data.get(i));
		}
		System.out.println(t.studentsTraining.size());
	}
	
	public String testData() throws IOException
	{
		
		//calculate prior
		double priorYes = t.getLabelYes() / t.getTraining();
		double priorNo = t.getLabelNo() / t.getTraining();	
		
		System.out.println(t.getLabelYes()+ t.getLabelNo());
		
		// for every element in training 
		for(j=0; j< studentsTesting.size(); j++)
		{
			// empty variables for numerator, for outcome yes and outcome no
			double yesNumerator = 0;
			double noNumerator = 0;
			
			// empty variable for denominator
			double denom = 0;
			
		
			
			/**if first element in students training = specified element, 
			 * calculate the denom for specified element and and add to denom var (after first element, multiply the denom var by the new denom),
			 * calculate the numerator for outcome yes, add to yesNumerator var (after first element, multiply the yesNumerator var by the new yesNuerator),
			 * calculate the numerator for outcome no, add to noNumerator var (after first element, multiply the noNumerator var by the new noNumerator)
			 */
			
			if(studentsTesting.get(j).get(0).matches("Female"))
			{
				denom = ((t.getFemaleYes() + t.getFemaleNo()) / t.getTraining());
				yesNumerator = (t.getFemaleYes()/ t.getLabelYes());
				noNumerator = (t.getFemaleNo()/ t.getLabelNo());
			
			}
			else if(studentsTesting.get(j).get(0).matches("Male"))
			{
				denom = ((t.getMaleYes() + t.getMaleNo())/ t.getTraining());
				yesNumerator = (t.getMaleYes()/ t.getLabelYes());
				noNumerator = (t.getMaleNo()/ t.getLabelNo());
			
			}
			
			if(studentsTesting.get(j).get(1).matches("Yes"))
			{
				denom = denom * ((t.getParentYesYes() + t.getParentYesNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getParentYesYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getParentYesNo() / t.getLabelNo());	
			
			}
			else if(studentsTesting.get(j).get(1).matches("No"))
			{
				denom = denom * ((t.getParentNoYes() + t.getParentNoNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getParentNoYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getParentNoNo() / t.getLabelNo());
				
			}
			
			if(studentsTesting.get(j).get(2).matches("Yes"))
			{
				denom = denom * ((t.getJobYesYes() + t.getJobYesNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getJobYesYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getJobYesNo() / t.getLabelNo());
						
			}
			else if(studentsTesting.get(j).get(2).matches("No"))
			{
				denom = denom * ((t.getJobNoYes() + t.getJobNoNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getJobNoYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getJobNoNo() / t.getLabelNo());

			}
			
			if(studentsTesting.get(j).get(3).contains("Urban"))
			{
				denom = denom * ((t.getUrbanYes() + t.getUrbanNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getUrbanYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getUrbanNo() / t.getLabelNo());
			
			}
			else if(studentsTesting.get(j).get(3).matches("Rural"))
			{
				denom = denom * ((t.getRuralYes() + t.getRuralNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getRuralYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getRuralNo() / t.getLabelNo());
				
			}
			
			if(studentsTesting.get(j).get(4).matches("Yes"))
			{
				denom = denom * ((t.getBusinessYesYes() + t.getBusinessYesNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getBusinessYesYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getBusinessYesNo() / t.getLabelNo());
				
			}
			else if(studentsTesting.get(j).get(4).matches("No"))
			{
				denom = denom * ((t.getBusinessNoYes() + t.getBusinessNoNo())/ t.getTraining());
				yesNumerator = yesNumerator * (t.getBusinessNoYes() /t.getLabelYes());
				noNumerator = noNumerator * (t.getBusinessNoNo() / t.getLabelNo());
				
			}
			
			probYes = (yesNumerator * priorYes) / denom;
			probNo = (noNumerator * priorNo) / denom; 
			
		
			
	
			if(probYes > probNo)
			{
				outcome = "Student will become entrepreneur";
				outcomes.add("Yes");
			}
			else if(probNo > probYes)
			{
				outcome = "Student will not become entrepreneur";
				outcomes.add("No");
			}
		}
		return outcome;
		
	}
	
	public void getAccuracy()
	{
		double correct =0;
		
		for(j=0; j< outcomes.size(); j++)
		{
			outcome = outcomes.get(j);
			
			if(studentsTesting.get(j).get(5).matches(outcome))
			{
				correct++;
			}
			
		}
		

	
	
	correct = (correct / studentsTesting.size()) * 100;
	System.out.println("Accuracy: " + (double) Math.round(correct * 100)/100 + "%");
	
	}

	
}
