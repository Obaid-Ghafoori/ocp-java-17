package chapter_09.employee_management;

import java.util.Comparator;

/**
 * Provides various comparators for sorting employees.
 */
public class EmployeeComparators {
    public static Comparator<Employee> byName() {
        return Comparator.comparing(Employee::name);
    }
    public static Comparator<Employee> byDepartment() {
        return Comparator.comparing(Employee::department);
    }
    public static Comparator<Employee> bySalary() {
        return Comparator.comparingDouble(Employee::salary);
    }
}
