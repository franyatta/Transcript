/*
 * Francine Vo
 * Assignment 7
 * CS 251
 */
package Data;

public class Course {

	private String grade;
	private int credits;
	private String courseName;
	private String courseNumber;
	private String semester;
	private String subject;

	public Course(String subject, String courseNumber, String courseName, int credits, String semester, String grade) {
		this.grade = grade;
		this.credits = credits;
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.semester = semester;
		this.subject = subject;
	}

	public Course() {
		grade = "E";
		credits = 0;
		courseName = "Potions";
		courseNumber = "0001";
		semester = "Spring";
		subject = "Core";
	}
	// Accommodate for - and + scores in grade points
    public float getGradePoints(String grade) {
        switch (grade) {
            case "A":
                return 4f;
            case "A-":
            	return 3.7f;
            case "B+":
            	return 3.3f;
            case "B":
                return 3f;
            case "B-":
            	return 2.7f;
            case "C+":
            	return 2.3f;
            case "C":
                return 2f;
            case "C-":
            	return 1.7f;
            case "D+":
            	return 1.3f;
            case "D":
                return 1f;
            case "D-":
            	return 0.7f;
            default:
                return 0f;
        }
    }


	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
