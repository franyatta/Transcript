/*
 * Francine Vo
 * Assignment 7
 * CS 251
 */
package Data;

import java.util.*;

public abstract class Transcript {

	// Create protected fields so only the other sub classes can access it
	protected String studentName;
	protected String currentDegree;
	protected String major;
	protected String semesterStart;
	protected List<Course> coursesTaken;
	protected float gpa;

	public Transcript(String studentName, String currentDegree, String major, String semesterStart,
			List<Course> coursesTaken, float gpa) {
		this.studentName = studentName;
		this.currentDegree = currentDegree;
		this.major = major;
		this.semesterStart = semesterStart;
		this.coursesTaken = coursesTaken;
		this.gpa = calculateGPA(); // Invoke the concrete method
	}

	// Abstract methods
	public abstract String printTranscript();

	public abstract void writeToFile(String fileName);

	// Concrete methods
	float calculateGPA() {
		int totalCredits = 0;
		float totalGPA = 0;

		for (Course c : coursesTaken) {
			int credits = c.getCredits();
			String grade = c.getGrade();
			float gradePoints = c.getGradePoints(grade);
			
			totalCredits += credits;
			totalGPA += credits * gradePoints;
		}

		return totalGPA / totalCredits;
	}

	// Iterate through each Course object and add to hashmap if needed
	protected HashMap<String, ArrayList<Course>> CoursePerSemester() {
		HashMap<String, ArrayList<Course>> result = new HashMap<>();

		for (Course c : coursesTaken) {
			String semester = c.getSemester();
			if (!result.containsKey(semester)) {
				result.put(semester, new ArrayList<>());
			}
			result.get(semester).add(c);
		}

		return result;
	}

	// Getters and setters
	protected String getStudentName() {
		return studentName;
	}

	protected void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	protected String getCurrentDegree() {
		return currentDegree;
	}

	protected void setCurrentDegree(String currentDegree) {
		this.currentDegree = currentDegree;
	}

	protected String getMajor() {
		return major;
	}

	protected void setMajor(String major) {
		this.major = major;
	}

	protected String getSemesterStart() {
		return semesterStart;
	}

	protected void setSemesterStart(String semesterStart) {
		this.semesterStart = semesterStart;
	}

	protected List<Course> getCoursesTaken() {
		return coursesTaken;
	}

	protected void setCoursesTaken(List<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	protected float getGpa() {
		return gpa;
	}

	protected void setGpa(float gpa) {
		this.gpa = gpa;
	}

}
