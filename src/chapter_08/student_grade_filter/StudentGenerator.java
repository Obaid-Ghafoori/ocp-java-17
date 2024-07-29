package chapter_08.student_grade_filter;

import chapter_08.student_grade_filter.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
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

    public void printStudentNameAndGradeReport(){
        Consumer<Student> printStudentName = student -> System.out.println("\nstudent name is:\t\t" + student.name());
        Consumer<Student> printStudentGrade = student -> System.out.println("& the grades are:\t\t" + student.grade());
        
        students.stream()
                .filter(isItGradedAtLeastEighty())
                .forEach(printStudentName.andThen(printStudentGrade));
    }

    public void filterScienceStudent(){
        Predicate<Student> isPassingGrade = isItGradedAtLeastEighty();
        Predicate<Student> isScienceStudent = student -> student.major().equals("Science");

        students.stream()
                .filter(isPassingGrade.and(isScienceStudent))
                .forEach(System.out::println);
    }

    /**
     * Prints students with passing grades (>= 80) along with their grade information.
     */
    public void expressCongratulationToThePassingStudent() {
        BiFunction<Student, Double,String> getStudentGradeMessage = (student, grade ) -> String.format("Congratulation to %s with a grade of %s", student.name(), grade);
        BiFunction<String, String,String> addPassingMessage = (message, passingMessage ) -> String.format("%s and who is successfully passed!", message);

        students.stream().filter(isItGradedAtLeastEighty())
                .map(student -> getStudentGradeMessage.apply(student, student.grade()))
                .map(message -> addPassingMessage.apply(message,""))
                .forEach(System.out::println);
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
