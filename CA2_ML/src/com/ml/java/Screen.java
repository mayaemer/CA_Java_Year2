package com.ml.java;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Screen extends JFrame implements ActionListener{

	JPanel genderPanel, parentPanel, jobPanel, areaPanel, businessPanel, predictPanel;
	JLabel genderLabel, parentLabel, jobLabel, areaLabel, businessLabel;
	JRadioButton female, male, parentYes, parentNo, jobYes, jobNo, urban, rural, businessYes, businessNo;
	JButton predict, clear;
	Testing test = new Testing();
	String[] predictInfo = new String[5];
	
	Screen(String title)
	{
		// set size, layout
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		// gender 
		genderPanel = new JPanel();
		genderLabel = new JLabel("Gender: ");
		female = new JRadioButton("Female");
		male = new JRadioButton("Male");
		
		ButtonGroup gender=new ButtonGroup();
		gender.add(female);
		gender.add(male);
		
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
		
		predictPanel = new JPanel();
		predict = new JButton("Predict");
		
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
		
		
		setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if(female.isSelected())
		{
			predictInfo[0] = "Female";
		}
		if(male.isSelected())
		{
			predictInfo[0] = "Male";
		}
		
		if(parentYes.isSelected())
		{
			predictInfo[1] = "Yes";
		}
		
		if(parentNo.isSelected())
		{
			predictInfo[1] = "No";
		}
		
		if(jobYes.isSelected())
		{
			predictInfo[2] = "Yes";
		}
		if(jobNo.isSelected())
		{
			predictInfo[2] = "No";
		}
		
		if(urban.isSelected())
		{
			predictInfo[3] = "Urban";	
		}
		if(rural.isSelected())
		{
			predictInfo[3] = "Rural";	
		}
		
		if(businessYes.isSelected())
		{
			predictInfo[4] = "Yes";
		}
		if(businessNo.isSelected())
		{
			predictInfo[4] = "No";
		}
		
		if(e.getSource() == predict)
		{
			List asList = Arrays.asList(predictInfo);
			test.studentsTesting.add(asList);
			
			try {
				JOptionPane.showMessageDialog(this, test.testData());
				test.studentsTesting.clear();
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		
			
			

		}
		
	}

}
