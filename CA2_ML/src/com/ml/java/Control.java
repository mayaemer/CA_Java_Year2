package com.ml.java;

import java.io.IOException;

public class Control {

	public static void main(String[] args) throws IOException
	{
		Training train = new Training();
		//train.countData();
		train.getTestData();
		train.trainData();
		//ProcessFile file = new ProcessFile();
		//file.readFile();
		
		//Screen myScreen = new Screen("Entrepreneur Predicter");
		
		
	}
}
