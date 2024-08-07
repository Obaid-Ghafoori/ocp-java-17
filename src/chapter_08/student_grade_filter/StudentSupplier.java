package chapter_08.student_grade_filter;

import chapter_08.student_grade_filter.model.Student;

import java.util.function.Supplier;

public class StudentSupplier implements Supplier<Student> {
    private String[] firstNames = {"John", "Emily", "Michael", "Sarah", "William", "Olivia", "James", "Ava", "George", "Isabella"};
    private String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
    private String[] majors = {"Science", "IT", "Mathematics", "Business", "Administration"};
    private int count = 0;

    @Override
    public Student get() {
        String firstName = firstNames[count % firstNames.length];
        String lastName = lastNames[count % lastNames.length];
        String major = majors[count % majors.length];
        String name = firstName + " " + lastName;
        double grade = 80.0 + (count % 10);
        String specialization  = major;

        count++;

        return new Student(name, grade, specialization);
    }
}

