package com.ml.java;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JFrame implements ActionListener{

	JPanel genderPanel, parentPanel, jobPanel, areaPanel, businessPanel;
	JLabel genderLabel, parentLabel, jobLabel, areaLabel, businessLabel;
	JCheckBox female, male, parentYes, parentNo, jobYes, jobNo, urban, rural, businessYes, businessNo;
	
	Screen(String title)
	{
		// set size, layout
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		// gender 
		genderPanel = new JPanel();
		genderLabel = new JLabel("Gender: ");
		female = new JCheckBox("Female");
		male = new JCheckBox("Male");
		
		parentPanel = new JPanel();
		parentLabel = new JLabel("Parent/ Guardian had own business: ");
		parentYes = new JCheckBox("Yes");
		parentNo = new JCheckBox("No");
		
		jobPanel = new JPanel();
		jobLabel = new JLabel("Do you currently have a part-time job?: ");
		jobYes = new JCheckBox("Yes");
		jobNo = new JCheckBox("No");
		
		areaPanel = new JPanel();
		areaLabel = new JLabel("Is your area: ");
		urban = new JCheckBox("Urban");
		rural = new JCheckBox("Rural");
		
		businessPanel = new JPanel();
		businessLabel = new JLabel("Do you study business?: ");
		businessYes = new JCheckBox("Yes");
		businessNo = new JCheckBox("No");
		
		
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
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
