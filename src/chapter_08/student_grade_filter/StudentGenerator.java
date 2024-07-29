package chapter_08.student_grade_filter;

import chapter_08.student_grade_filter.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentGenerator {
    public static final int EIGHTY = 80;
    private List<Student> students;
    private Supplier<Student> studentSupplier;

    public StudentGenerator() {
        this.studentSupplier = new StudentSupplier();
        students = createStudentsList(10, studentSupplier);
    }


    public void showcaseStudents(Consumer<Student> studentConsumer) {
        students.forEach(studentConsumer);
    }

    public void filterStudentGrade() {
        StudentProcessorImpl processor = new StudentProcessorImpl();
        students.stream()
                .filter(isItGradedAtLeastEighty())
                .forEach(processor::processStudentName);
    }

    public void filterScienceStudent(){
        Predicate<Student> isPassingGrade = isItGradedAtLeastEighty();
        Predicate<Student> isScienceStudent = student -> student.major().equals("Science");

        students.stream()
                .filter(isPassingGrade.and(isScienceStudent))
                .forEach(System.out::println);
    }

    public void printStudentNameAndGrade(){
        Consumer<Student> printStudentName = student -> System.out.println("\nstudent name is:\t\t" + student.name());
        Consumer<Student> printStudentGrade = student -> System.out.println("& the grades are:\t\t" + student.grade());
        
        students.stream()
                .filter(isItGradedAtLeastEighty())
                .forEach(printStudentName.andThen(printStudentGrade));
    }

    private Predicate<Student> isItGradedAtLeastEighty(){
        Predicate<Student> isPassingGrade = student -> student.grade() >= EIGHTY;
        return isPassingGrade;
    }

    private static List<Student> createStudentsList(int size, Supplier<Student> supplier) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            students.add(supplier.get());
        }

        return students;
    }
}
