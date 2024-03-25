/*
 * Francine Vo
 * Assignment 7
 * CS 251
 */
package Transcripts;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Data.Course;
import Data.Transcript;

public class Postgrad extends Transcript {

	private String graduationDate;
	private String degree;
	private String prevUniversity;

	public Postgrad(String studentName, String currentDegree, String major, String semesterStart,
			List<Course> coursesTaken, float gpa, String graduationDate, String degree, String prevUniversity) {
		super(studentName, currentDegree, major, semesterStart, coursesTaken, gpa);
		this.setGraduationDate(graduationDate);
		this.setDegree(degree);
		this.setPrevUniversity(prevUniversity);
	}

	public Postgrad(String studentName, String currentDegree, String major, String semesterStart,
			List<Course> coursesTaken, float gpa, String graduationDate, String degree) {

		super(studentName, currentDegree, major, semesterStart, coursesTaken, gpa);
		this.setGraduationDate(graduationDate);
		this.setDegree(degree);
	}

	// Implemented a method that determines academic distinction
	public String honor(float gpa) {
		if (gpa >= 3.9) {
			return "Summa Cum Laude";
		} else if (gpa >= 3.7) {
			return "Magna Cum Laude";
		} else if (gpa >= 3.5) {
			return "Cum Laude";
		} else {
			return "";
		}
	}

	// Created a method to help with centering the text in the diploma
	private String centerText(String text, int width) {
		int padding = (width - text.length()) / 2;
		return " ".repeat(padding) + text + " ".repeat(width - padding - text.length());
	}

	@Override
	public String printTranscript() {
		String result = String.format(
				"Name: %s%nDegree: %s%nMajor: %s%nStart Semester: %s%nGPA: %.2f%nGraduation Date: %s%nPast Degree: %s%n",
				studentName, currentDegree, major, semesterStart, gpa, graduationDate, degree);

		HashMap<String, ArrayList<Course>> coursePerSemester = CoursePerSemester();
		for (Map.Entry<String, ArrayList<Course>> entry : coursePerSemester.entrySet()) {
			String semester = entry.getKey();
			ArrayList<Course> coursesInSemester = entry.getValue();

			result += String.format("%n%-15s%n%-15s%-15s%-20s%-15s%-15s%n", semester, "Subject", "Course", "Name",
					"Credits", "Grade");
			String lines = "-";
			result += lines.repeat(70) + "\n";

			for (Course course : coursesInSemester) {
				result += String.format("%-15s%-15s%-20s%-15d%-15s\n", course.getSubject(), course.getCourseNumber(),
						course.getCourseName(), course.getCredits(), course.getGrade());
			}
		}
		// Print out diploma
		String honor = honor(gpa);

		int width = 50; // Specify the desired width of the diploma box

		result += "\nDiploma:\n";
		result += String.format("GPA: %.2f\n", gpa);
		result += "+" + "-".repeat(width - 2) + "+\n";
		result += "|" + " ".repeat(width - 2) + "|\n";
		result += "|" + centerText(prevUniversity, width - 2) + "|\n";
		result += "|" + centerText(degree, width - 2) + "|\n";
		if (!honor.isEmpty()) {
			result += "|" + centerText(honor, width - 2) + "|\n";
		}
		result += "|" + centerText("upon", width - 2) + "|\n";
		result += "|" + centerText(studentName, width - 2) + "|\n";
		result += "|" + " ".repeat(width - 2) + "|\n";
		result += "+" + "-".repeat(width - 2) + "+\n";

		return result;
	}

	@Override
	public void writeToFile(String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(printTranscript());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPrevUniversity() {
		return prevUniversity;
	}

	public void setPrevUniversity(String prevUniversity) {
		this.prevUniversity = prevUniversity;
	}

}
