package chapter_09.employee_management;

public record Employee(int id, String name, String department, double salary) implements Comparable<Employee> {

    /**
     * Creates a new Employee instance with modified name, department, and salary.
     *
     * @param newName the new name for the Employee
     * @param newDepartment the new department for the Employee
     * @param newSalary the new salary for the Employee
     * @return a new Employee instance with the updated attributes
     */
    public Employee withAttributes(String newName, String newDepartment, double newSalary) {
        return new Employee(this.id, newName, newDepartment, newSalary);
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
}

