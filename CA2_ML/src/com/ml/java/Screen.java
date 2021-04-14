package com.ml.java;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// Screen inherits from JFrame, implements ActionListener interface
public class Screen extends JFrame implements ActionListener{

	//Attributes
	private JPanel headerPanel, genderPanel, parentPanel, jobPanel, areaPanel, businessPanel, predictPanel;
	private JLabel header, genderLabel, parentLabel, jobLabel, areaLabel, businessLabel;
	private JRadioButton female, male, parentYes, parentNo, jobYes, jobNo, urban, rural, businessYes, businessNo;
	private JButton predict, viewStats, clear;
	
	// instance of training
	Training train = new Training();
	
	// String array to hold information for prediction
	private String[] predictInfo = new String[5];
	
	// constructor
	Screen(String title) throws IOException
	{
		// set size, layout
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		// call the training class to count all data in csv file
		train.countData(1);
		
		// create panel and label for header
		headerPanel = new JPanel();
		header = new JLabel("Welcome to Entrepreneur Predicter, please enter the answers to the following:");
		
		// create panel, label, radio buttons for gender 
		// this is done for each of the attribute sets
		genderPanel = new JPanel();
		genderLabel = new JLabel("Gender: ");
		female = new JRadioButton("Female");
		male = new JRadioButton("Male");
		
		//create a button group for gender, to allow only one of the two options to be selected
		// this is done for each of the attribute sets
		ButtonGroup gender=new ButtonGroup();
		gender.add(female);
		gender.add(male);
		
		//panel, label, and buttons created for each section with each attribute option
		parentPanel = new JPanel();
		parentLabel = new JLabel("Parent/ Guardian had own business: ");
		parentYes = new JRadioButton("Yes");
		parentNo = new JRadioButton("No");
		
		ButtonGroup parent=new ButtonGroup();
		parent.add(parentYes);
		parent.add(parentNo);
		
		jobPanel = new JPanel();
		jobLabel = new JLabel("Do you currently have a part-time job?: ");
		jobYes = new JRadioButton("Yes");
		jobNo = new JRadioButton("No");
		
		ButtonGroup job=new ButtonGroup();
		job.add(jobYes);
		job.add(jobNo);
		
		
		areaPanel = new JPanel();
		areaLabel = new JLabel("Is your area: ");
		urban = new JRadioButton("Urban");
		rural = new JRadioButton("Rural");
		
		ButtonGroup area=new ButtonGroup();
		area.add(urban);
		area.add(rural);
		
		businessPanel = new JPanel();
		businessLabel = new JLabel("Do you study business?: ");
		businessYes = new JRadioButton("Yes");
		businessNo = new JRadioButton("No");
		
		ButtonGroup business=new ButtonGroup();
		business.add(businessYes);
		business.add(businessNo);
		
		//panel for the predict button
		//predict button created
		predictPanel = new JPanel();
		predict = new JButton("Predict");
		viewStats = new JButton("View Stats");
		clear = new JButton("Clear");
		
		// add action listeners to each of the buttons
		female.addActionListener(this);
		male.addActionListener(this);
		parentYes.addActionListener(this);
		parentNo.addActionListener(this);
		jobYes.addActionListener(this);
		jobNo.addActionListener(this);
		urban.addActionListener(this);
		rural.addActionListener(this);
		businessYes.addActionListener(this);
		businessNo.addActionListener(this);
		predict.addActionListener(this);
		viewStats.addActionListener(this);
		clear.addActionListener(this);
		
		// set header background as grey
		headerPanel.setBackground(Color.lightGray);
		
		predict.setToolTipText("Be sure to clear previous information before you try again.");
		viewStats.setToolTipText("View the calculated probability of each outcome");
		clear.setToolTipText("Clear previously entered data.");
		
		// add header panel and label 
		add(headerPanel);
		headerPanel.add(header);
		
		// add panel to gui
		// add each of labels and buttons -- done for all attributes
		add(genderPanel);
		genderPanel.add(genderLabel);
		genderPanel.add(female);
		genderPanel.add(male);
		
		add(parentPanel);
		parentPanel.add(parentLabel);
		parentPanel.add(parentYes);
		parentPanel.add(parentNo);
		
		add(jobPanel);
		jobPanel.add(jobLabel);
		jobPanel.add(jobYes);
		jobPanel.add(jobNo);
		
		add(areaPanel);
		areaPanel.add(areaLabel);
		areaPanel.add(urban);
		areaPanel.add(rural);
		
		add(businessPanel);
		businessPanel.add(businessLabel);
		businessPanel.add(businessYes);
		businessPanel.add(businessNo);
		
		add(predictPanel);
		predictPanel.add(predict);
		predictPanel.add(viewStats);
		predictPanel.add(clear);
		
		setVisible(true);
		
	}
	

	// overrides actionPerformed method from action listener interface
	// set each index in predictInfo array as String in accordance w/ the selected button
	// when predict button is pressed convert predictInfo to List and add to studentsTesting List of Lists
	// call testData method and return whether student will/ will not become entrepreneur
	// when view stats is pressed, print the probability for each outcome
	// when clear is pressed, clear the students testing array of the information previously entered
	@Override
	public void actionPerformed(ActionEvent e) {

		if(female.isSelected())
		{
			predictInfo[0] = "Female";
		}
		else if(male.isSelected())
		{
			predictInfo[0] = "Male";
		}
		else
		{
			predictInfo[0] = "null";
		}
		
		if(parentYes.isSelected())
		{
			predictInfo[1] = "Yes";
		}
		else if(parentNo.isSelected())
		{
			predictInfo[1] = "No";
		}
		else
		{
			predictInfo[1] = "null";
		}
		
		if(jobYes.isSelected())
		{
			predictInfo[2] = "Yes";
		}
		else if(jobNo.isSelected())
		{
			predictInfo[2] = "No";
		}
		else
		{
			predictInfo[2] = "null";
		}
		
		if(urban.isSelected())
		{
			predictInfo[3] = "Urban";	
		}
		else if(rural.isSelected())
		{
			predictInfo[3] = "Rural";	
		}
		else
		{
			predictInfo[3] = "null";
		}
		
		if(businessYes.isSelected())
		{
			predictInfo[4] = "Yes";
		}
		else if(businessNo.isSelected())
		{
			predictInfo[4] = "No";
		}
		else
		{
			predictInfo[4] = "null";
		}
		
		if(e.getSource() == predict)
		{
			for(int i=0; i< predictInfo.length; i++)
			{
				if(predictInfo[i] != null)
				{
					List asList = Arrays.asList(predictInfo);
					train.studentsTesting.add(asList);
					try {
						JOptionPane.showMessageDialog(this,train.testData());
						
						break;
						} catch (HeadlessException | IOException e1)
						{
							e1.printStackTrace();
						}
				}
				
			}
		}
		
		if(e.getSource() == viewStats)
		{
			JOptionPane.showMessageDialog(this,train.stats());
		}
		
		if(e.getSource() == clear)
		{
			train.studentsTesting.clear();
			JOptionPane.showMessageDialog(this,"Previous information cleared");
		}
	}
}
