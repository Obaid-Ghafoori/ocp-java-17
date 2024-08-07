package chapter_08.student_grade_filter;

import chapter_08.student_grade_filter.model.Student;

public class StudentProcessorImpl implements StudentProcessor{
    @Override
    public void processStudentName(Student student) {
        System.out.println(String.format("%s passed with a total grade of \t\t%s", student.name(),student.grade()));
    }
}
