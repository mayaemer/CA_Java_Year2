package com.ml.java;

import java.io.IOException;


public class Training {
	
	
	ProcessFile file = new ProcessFile();
	DataCounter d1 = new DataCounter();
	double totalStudents;
	double priorYes;
	double priorNo;
	
	public Training()
	{
		
	}
	
	public void priorCalc() throws IOException
	{
		
		d1.countEntrepreneurs();
		totalStudents = file.studentsTraining.size() * 1;
		double entrepreneurYes = (d1.entrepreneurYes / totalStudents);
		priorYes =  (double) Math.round(entrepreneurYes*100.0) /100.0;
		System.out.println(priorYes);
		
		double entrepreneurNo = (d1.entrepreneurNo / totalStudents);
		priorNo = (double)Math.round(entrepreneurNo*100) / 100;
		System.out.println(priorNo);
		
	}
	
	public void denomCalc()
	{
		
	}

}
