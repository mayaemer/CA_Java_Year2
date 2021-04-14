package com.ml.java;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Testing {

	// instance of training/ process file created
	Training t = new Training();
	ProcessFile file = new ProcessFile();
	
	// static List of lists to store testing data
	static List<List<String>> studentsTesting = new ArrayList<>();
	// List of strings to store the yes/no outcome for each students
	private List<String> outcomes = new ArrayList<>();
	
	//attribs
	private String outcome;
	private double probYes;
	private double probNo;

	// index for loop attributes
	private int i;
	private int j;
	
	// constructor
	public Testing()
	{
		
	}
	
	// Getters and Setters
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
	
	
	// loop through the remaining data after students training and add to studentsTesting to collect data 
	// for testing
	public void getTestData() throws IOException
	{
		for(i = t.studentsTraining.size(); i < file.data.size(); i++)
		{
			studentsTesting.add(file.data.get(i));
		}
		//System.out.println(t.studentsTraining.size());
	}
	
	// calculates the probabilities
	public String testData() throws IOException
	{
		
		//calculate prior
		double priorYes = t.getLabelYes() / t.getTraining();
		double priorNo = t.getLabelNo() / t.getTraining();	
		
		//System.out.println(t.getLabelYes()+ t.getLabelNo());
		
		// for every element in testing
		for(j=0; j< studentsTesting.size(); j++)
		{
			// empty variables for numerator, for outcome yes and outcome no
			double yesNumerator = 0;
			double noNumerator = 0;
			
			// empty variable for denominator
			double denom = 0;
			
			// empty variable to count any null values
			double nullCounter = 0;
			
		
			
			/**if first element in students training = specified element, 
			 * calculate the denom for specified element and and add to denom var (after first element, multiply the denom var by the new denom),
			 * calculate the numerator for outcome yes, add to yesNumerator var (after first element, multiply the yesNumerator var by the new yesNuerator),
			 * calculate the numerator for outcome no, add to noNumerator var (after first element, multiply the noNumerator var by the new noNumerator)
			 * occurs for each element
			 * if an index in the studentsTesting List = null, incremenet the null counter
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
			else if(studentsTesting.get(j).get(0).matches("null"))
			{
				nullCounter++;
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
			else if(studentsTesting.get(j).get(1).matches("null"))
			{
				nullCounter++;
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
			else if(studentsTesting.get(j).get(2).matches("null"))
			{
				nullCounter++;
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
			else if(studentsTesting.get(j).get(3).matches("null"))
			{
				nullCounter++;
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
			else if(studentsTesting.get(j).get(4).matches("null"))
			{
				nullCounter++;
			}
			
			//calculate the probability of the outcome being yes or no
			// by multiplying the numerator with the prior, all over the denom
			probYes = (yesNumerator * priorYes) / denom;
			probNo = (noNumerator * priorNo) / denom; 
			
			// if the probability of yes is greater than no and null counter =0, print student will become entrepreneur
			// and add Yes to the outcome List
			// else if probability no is greater and null counter = 0, print student wont be entrepreneur and add no to outcomes List
			// else if null counter is greater than 0 print error message
			if(probYes > probNo && nullCounter == 0)
			{
				outcome = "Student will likely become entrepreneur";
				outcomes.add("Yes");
			}
			else if(probNo > probYes && nullCounter == 0)
			{
				outcome = "Student will not likely become entrepreneur";
				outcomes.add("No");
			}
			else if(nullCounter > 0)
			{
				outcome = "Error, not enough values entered";
			}
			
		}
		
		return outcome;
		
	}
	
	// method to return to calculation of likelihood for each outcome
	// used https://www.programiz.com/java-programming/examples/round-number-decimal for decimal format
	public String stats()
	{
		String stats = "";
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);

		for(j=0; j< studentsTesting.size(); j++)
		{
			stats = "Probability of Yes: " + df.format(probYes) + "\n Probability of No: " + df.format(probNo);
		}
		return stats;
		
	}
	
	// calculate the accuracy of the prediction
	// for each element in outcomes, add the outcome of that index to the outcome string
	// if the outcome in the students testing info of the same index matches
	// it is correct
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
		
	// calculate correct outcomes as percentage
	correct = (correct / studentsTesting.size()) * 100;
	System.out.println("Accuracy: " + (double) Math.round(correct * 100)/100 + "%");
	
	}

	
}
