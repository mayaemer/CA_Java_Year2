package com.ml.java;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Training {
	
	// create instance of process file
	ProcessFile file = new ProcessFile();
	
	// create List of Lists students training to store training data
	static List<List<String>> studentsTraining = new ArrayList<>();
	// static List of lists to store testing data
	static List<List<String>> studentsTesting = new ArrayList<>();
	// List of strings to store the yes/no outcome for each students
	private List<String> outcomes = new ArrayList<>();
	
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
	
	//attribs for testing
	private String outcome;
	private double probYes;
	private double probNo;
	
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
	
	// takes in percent of data to be used
	// calls readFile method from ProcessFile
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
		// and total with outcome no
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
		
		//Loops from 0 through length of training and totals up where 
		//gender = female + outcome = yes
		// gender = female + outcome = no
		// gender = male + outcome = yes
		// gender = male + outcome = no
		// increments each of the vars accordingly
		// this pattern is used for each of the attributes below
		// Print lines display the totals gathered for each, but are commented out
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
	// loop through the remaining data after students training and add to studentsTesting to collect data 
	// for testing
	public void getTestData() throws IOException
	{
		for(i = studentsTraining.size(); i < file.data.size(); i++)
		{
			studentsTesting.add(file.data.get(i));
		}
		//System.out.println(t.studentsTraining.size());
	}
	
	// calculates the probabilities
	public String testData() throws IOException
	{
		
		//calculate prior
		double priorYes = labelYes / training;
		double priorNo = labelNo / training;	
		
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
			else if(studentsTesting.get(j).get(0).matches("null"))
			{
				nullCounter++;
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
			else if(studentsTesting.get(j).get(1).matches("null"))
			{
				nullCounter++;
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
				noNumerator = noNumerator * (jobNoNo /labelNo);

			}
			else if(studentsTesting.get(j).get(2).matches("null"))
			{
				nullCounter++;
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
			else if(studentsTesting.get(j).get(3).matches("null"))
			{
				nullCounter++;
			}
			
			if(studentsTesting.get(j).get(4).matches("Yes"))
			{
				denom = denom * ((businessYesYes + businessYesNo)/training);
				yesNumerator = yesNumerator * (businessYesYes /labelYes);
				noNumerator = noNumerator * (businessYesNo /labelNo);
				
			}
			else if(studentsTesting.get(j).get(4).matches("No"))
			{
				denom = denom * ((businessNoYes + businessNoNo)/training);
				yesNumerator = yesNumerator * (businessNoYes /labelYes);
				noNumerator = noNumerator * (businessNoNo / labelNo);
				
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

	



