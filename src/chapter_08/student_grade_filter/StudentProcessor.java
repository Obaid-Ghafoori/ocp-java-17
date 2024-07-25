package chapter_08.student_grade_filter;

import chapter_08.student_grade_filter.model.Student;

@FunctionalInterface
interface StudentProcessor {
    void processStudent(Student student);
}
