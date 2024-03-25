/*
 * Francine Vo
 * Assignment 7
 * CS 251
 */
import java.io.*;
import java.util.*;

import Data.Course;
import Transcripts.Graduate;
import Transcripts.Postgrad;
import Transcripts.Undergraduate;

public class Main {

	public static void main(String[] args) {
		// UNDERGRADUATE
		List<Course> coursesTakenForJohn = readFile("John Ringo.txt", null, null, 0);

		// Create an Undergraduate object
		Undergraduate uTranscript = new Undergraduate("John Ringo", "Bachelor of Science", "Computer Science",
				"Fall 2020", coursesTakenForJohn, 4);

		// Print the transcript
		System.out.println(uTranscript.printTranscript());
		// Write the transcript to file
		uTranscript.writeToFile("Undergrad.txt");
		
		// GRADUATE
	    String fileName = "Cher.txt";
	    List<String> researchTopics = new ArrayList<>();
	    String bachelorsSchool = "";
	    float bachelorsGPA = 0.0f;
	    float gpa = 0.0f;
	    List<Course> coursesTaken = readFile(fileName, researchTopics, bachelorsSchool, bachelorsGPA);

	    Graduate gTranscript = new Graduate("Cher", "Master's", "Computer Science",
	            "Fall 2019", coursesTaken, gpa, researchTopics, bachelorsSchool, bachelorsGPA);

	    System.out.println(gTranscript.printTranscript());
	    gTranscript.writeToFile("Graduate.txt");
	    
	    
	    // POSTGRADUATE
	    List<Course> coursesTakenForPostGrad = readFile(fileName, researchTopics, bachelorsSchool, bachelorsGPA);
	    String graduationDate = "12-18-2021";
	    String degree = "Bachelor of Computer Science";
	    String prevUniversity = "Old Dominion University";

	    Postgrad pgTranscript = new Postgrad("Cher", "Bachelor", "Computer Science",
	            "Fall 2018", coursesTakenForPostGrad, gpa, graduationDate, degree, prevUniversity);

	    System.out.println(pgTranscript.printTranscript());
	    pgTranscript.writeToFile("Postgrad.txt");

	}
	// Method that reads in the files and adjusts to the file info accordingly.
	static List<Course> readFile(String fileName, List<String> researchTopics, String bachelorsSchool, float bachelorGPA) {
	    List<Course> coursesTaken = new ArrayList<>();

	    try (Scanner scanner = new Scanner(new File(fileName))) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] data = line.split(",");
	            // Accommodates for the difference in the two given text files
	            if (data.length == 2) {
	                String category = data[0];
	                String value = data[1];

	                switch (category) {
	                    case "Previous University":
	                        bachelorsSchool = value;
	                        break;
	                    case "Research":
	                        researchTopics.add(value);
	                        break;
	                }
	            } else if (data.length == 6) {
	                String subject = data[0];
	                String courseName = data[1];
	                String courseNumber = data[2];
	                String semester = data[3];
	                int credits = Integer.parseInt(data[4]);
	                String grade = data[5];

	                Course course = new Course(subject, courseNumber, courseName, credits, semester, grade);
	                coursesTaken.add(course);
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.err.println("File not found: " + fileName);
	    }

	    return coursesTaken;
	}
}
