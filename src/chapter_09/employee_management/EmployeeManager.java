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
    public void addEmployee(Employee employee) {
        Objects.requireNonNull(employee, "Employee cannot be null");
        boolean isUniqueId = uniqueEmployeeIds.contains(employee.id());
        if (isUniqueId) {
            throw new IllegalArgumentException("Employee ID must be unique.");
        }
        employees.add(employee);
        uniqueEmployeeIds.add(employee.id());
    }


    /**
     * Removes an Employee from the system by their unique ID.
     *
     * @param id the unique ID of the Employee to be removed
     */

    public void removeEmployeeById(int id) {
        boolean employeeToRemove = employees.removeIf(employee -> employee.id() == id);
        uniqueEmployeeIds.remove(id);
        if (!employeeToRemove) {
            throw new IllegalArgumentException("Employee with id [" + id + "] does not exist in the system");
        }
    }

    /**
     * Updates an existing Employee's information in the system.
     * The method first removes the old Employee record and then adds the updated record.
     *
     * @param updatedEmployee the Employee object containing updated information
     */
    public void updateEmployee(Employee updatedEmployee) {
        removeEmployeeById(updatedEmployee.id());
        addEmployee(updatedEmployee);
    }

    /**
     * prints out all the employees of the system
     */
    public void printEmployees() {
        employees.forEach(System.out::println);
    }

    public Employee getEmployeeById(int employeeIdToUpdate) {
        return employees.stream().filter(employee -> employee.id() == employeeIdToUpdate).findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such Employee found with id "+ employeeIdToUpdate));
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
