package chapter_09.employee_management;

import java.util.*;


/**
 * The EmployeeManager class manages a collection of Employee objects.
 * It allows adding, removing, updating employees, calculating the average salary of a department,
 * and searching for employees by name.
 */
public class EmployeeManager {
    private List<Employee> employees;
    private Set<Integer> uniqueEmployeeIds;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
        this.uniqueEmployeeIds = new HashSet<>();
    }

    /**
     * Adds a new Employee to the system.
     *
     * @param employee the Employee to be added
     * @throws IllegalArgumentException if an Employee with the same ID already exists
     */
    public void addEmployee(Employee employee){
        boolean isUniqueId = uniqueEmployeeIds.contains(employee.id());
        if(isUniqueId){
            throw new IllegalArgumentException("Employee ID must be unique.");
        }
        employees.add(employee);
        uniqueEmployeeIds.add(employee.id());
    }

    @Override
    public String toString() {
        return "EmployeeManager{" +
                "employees=" + employees +
                ", uniqueEmployeeIds=" + uniqueEmployeeIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeManager that = (EmployeeManager) o;
        return Objects.equals(employees, that.employees) && Objects.equals(uniqueEmployeeIds, that.uniqueEmployeeIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees, uniqueEmployeeIds);
    }
}
