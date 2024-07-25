package chapter_08.student_grade_filter;

import chapter_08.student_grade_filter.model.Student;
import chapter_08.task_management.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StudentGenerator {
    private List<Student> students;
    private Supplier<Student> studentSupplier;

    public StudentGenerator() {
        this.studentSupplier = new StudentSupplier();
        students = createStudentsList(10, studentSupplier);
    }


    public void showcaseStudents(Consumer<Student> studentConsumer) {
        students.forEach(studentConsumer);
    }


    private static List<Student> createStudentsList(int size, Supplier<Student> supplier) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            students.add(supplier.get());
        }

        return students;
    }
}
