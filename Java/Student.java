package com.sdsu.cs635.assignment2;

/****************************************************************************************************
 * 
 * author : Durgashree Shetty date : Sept. 25 2018
 * 
 * This class holds students details. Each record consists of six fields: - -
 * First name - Last name - Red Id - Email address - GPA between 0 to 4 - Units
 * taken between 0 to 150
 *
 * A students priority is determined 70% by the number of units taken and 30% by
 * their GPA .
 * 
 ***************************************************************************************************/

public class Student {

	private String firstName;
	private String lastName;
	private int redID;
	private String email;
	private double gpa = 0.0; /* values between 0.0 to 4.0 */
	private double gpaPercentage = 0.3;
	private double numberOfUnits = 0.0;/* vaues between 0 to 150 */
	private double unitsPercentage = 0.7;
	private double priority = 0.0;
	public static double FULL_GPA = 4.0;
	public static double TOTAL_UNITS = 150;

	public double getPriority() {
		double priorityValue = 0.0;
		priorityValue = (double) Math.round(((((this.numberOfUnits / TOTAL_UNITS) * unitsPercentage) * 100
				+ ((this.gpa / FULL_GPA) * gpaPercentage) * 100)) * 100d) / 100d;
		priority = priorityValue;
		return (priority);
	}

	public void setStudentsPriority(double studentsPriority) {
		this.priority = studentsPriority;
	}

	public Student(int studentRedID, String studentlName, String Studentfname, String studentEmail,
			double studentTotalUnits, double studentGPA) {
		this.redID = studentRedID;
		this.lastName = studentlName;
		this.firstName = Studentfname;
		this.email = studentEmail;
		this.numberOfUnits = studentTotalUnits;
		this.gpa = studentGPA;
	}

	public double getStudentGPA() {
		return gpa;
	}

	public void setStudentGPA(double studentGPA) {
		this.gpa = studentGPA;
	}

	public double getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(double numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public String toString() {
		return this.redID + "  " + this.lastName + "," + this.firstName + " GPA : " + this.gpa + " Number of Units : "
				+ this.numberOfUnits + " Priority:" + getPriority();
	}

}
