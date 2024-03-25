# Transcript
handles 3 different types of university transcripts
A university has asked you to create a program to create transcripts.
It should take in a file (studentName.txt) of classes taken by the student, where
studentName is the name of the student. It should then create a text file that outputs a
readable transcript.
There should be three kinds of transcripts, undergraduate, graduate, and post-grad.
All transcripts should have a name, current degree, major, semester start, courses
taken, and GPA.
If a student has graduated (with either an undergraduate or graduate degree) then their
transcript is a post-grad transcript and it should also have the day of graduation and a
printable version of their degree.
A master’s student should also have any research completed through the university on
it as well as the university they obtained their bachelor’s degree from as well their
bachelor’s degree GPA. A master’s student’s research may involve one or more topics.
GPA can be calculated using the following point scale.
Grade A B C D F
Points per
credit hour
4.0 3.0 2.0 1.0 0.0
Example:
Course CS 151 CS 251 CS 330
# of credits 4 4 3
Grade B (3.0) A (4.0) A (4.0)
Grade points for
course
12.0 16.0 12.0
GPA (12.0 + 16.0 + 12.0) / 11 = 40 / 11 = 3.63
Your code should have a single abstract class called Transcript. You should have 3
classes which extend this class for undergraduate, graduate, and post-grad transcripts.
Inside of Transcript you should have all variables mentioned above, 2 abstract
methods:
• String printTranscript()
• void writeToFile(String File))
The concrete methods:
• float calculateGPA()
• HashMap<String,ArrayList<String>> CoursePerSemeter()
as well as setters and getters. Make the proper additions to the extended classes from
the task description.
All course information should be stored in a Course class:
• Grade received.
• Course credits.
• Course name.
• Course number.
• Semester taken.
• Course subject.
