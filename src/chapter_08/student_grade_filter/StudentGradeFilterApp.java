package chapter_08.student_grade_filter;

public class StudentGradeFilterApp {
    public static void main(String[] args) {
        StudentGenerator studentGenerator = new StudentGenerator();
        studentGenerator.showcaseStudents(System.out::println);
        System.out.println("\n|--------------------------| Using Student processor interface |------------------------------|");
        studentGenerator.filterStudentGrade();
        System.out.println("\n|--------------------------| Printing Student name and then grade |------------------------------|");
        studentGenerator.printStudentNameAndGrade();
    }

}
