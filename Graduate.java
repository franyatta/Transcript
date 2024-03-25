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

public class Graduate extends Transcript {

	private List<String> researchTopics;
	private String bachelorsSchool;
	private float bachelorsGPA;

	public Graduate(String studentName, String currentDegree, String major, String semesterStart,
			List<Course> coursesTaken, float gpa, List<String> researchTopics, String bachelorsSchool,
			float bachelorsGPA) {
		super(studentName, currentDegree, major, semesterStart, coursesTaken, gpa);

		this.researchTopics = researchTopics;
		this.bachelorsSchool = bachelorsSchool;
		this.bachelorsGPA = bachelorsGPA;
	}

	@Override
	public String printTranscript() {
		String result = String.format("Name: %s%nDegree: %s%nMajor: %s%nStart Semester: %s%nGPA: %.2f%n", studentName,
				currentDegree, major, semesterStart, gpa);

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

		result += "\nResearch Topics:\n";
		for (String topics : researchTopics) {
			result += "\t" + topics + "\n";
		}
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

	// Getters and Setters
	public List<String> getResearchTopics() {
		return researchTopics;
	}

	public void setResearchTopics(List<String> researchTopics) {
		this.researchTopics = researchTopics;
	}

	public String getBachelorsSchool() {
		return bachelorsSchool;
	}

	public void setBachelorsSchool(String bachelorsSchool) {
		this.bachelorsSchool = bachelorsSchool;
	}

	public float getBachelorsGPA() {
		return bachelorsGPA;
	}

	public void setBachelorsGPA(float bachelorsGPA) {
		this.bachelorsGPA = bachelorsGPA;
	}

}