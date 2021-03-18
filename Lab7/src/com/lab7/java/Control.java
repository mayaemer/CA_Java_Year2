package com.lab7.java;

public class Control 
{
	public static void main(String[] args)
	{
		Date d1 = new Date(11, 10, 1997);
		//System.out.println(d1);
		
		Date d2 = new Date(11, 10, 2020);
		//System.out.println(d1);
		
		Job j1= new Job(30000, "Carpeter", 02);
		
		
		Person p1 = new Person("Eoin", "Oshea", d1, "Male" );
		//System.out.println(p1);
		
		Employee e1 = new Employee("Maya", "OConnell", d1, "Female", j1, 1234, d2, 35 );
		System.out.println(e1);
		e1.writeToFile();
		
		
	}
}
