package chapter_08.student_grade_filter;

import chapter_08.student_grade_filter.model.Student;

public class StudentProcessorImpl implements StudentProcessor{
    @Override
    public void processStudentName(Student student) {
        System.out.println("Student " + student.name() + " passed!");
    }
}
