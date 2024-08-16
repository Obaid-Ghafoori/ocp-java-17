package chapter_09.employee_management;

import chapter_08.student_grade_filter.StudentSupplier;

import java.util.*;
import java.util.stream.Collectors;


/**
 * The EmployeeManager class manages a collection of Employee objects.
 * It allows adding, removing, updating employees, calculating the average salary of a department,
 * and searching for employees by name.
 */
public class EmployeeManager {
    private final List<Employee> employees;
    private final Set<Integer> uniqueEmployeeIds;
    private final Map<String, List<Employee>> departmentEmployees;
    private final Map<String, Employee> employeeSearchMap;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
        this.uniqueEmployeeIds = new HashSet<>();
        this.departmentEmployees = new HashMap<>();
        this.employeeSearchMap = new HashMap<>();
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
        departmentEmployees.computeIfAbsent(employee.department(), k -> new ArrayList<>()).add(employee);
        employeeSearchMap.put(employee.name(), employee);

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

    /**
     * Retrieves an employee by their unique ID.
     *
     * This method searches for an employee with the specified employee ID
     * from the employees list. If an employee with the given ID is found,
     * it is returned. If no employee with the given ID exists, a
     * {@link NoSuchElementException} is thrown.
     *
     * @param employeeIdToUpdate the ID of the employee to search for
     * @return the Employee object with the specified ID
     * @throws NoSuchElementException if no employee is found with the given ID
     */
    public Employee getEmployeeById(int employeeIdToUpdate) {
        return employees.stream()
                .filter(employee -> employee.id() == employeeIdToUpdate)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such Employee found with id " + employeeIdToUpdate));
    }

    /**
     * Searches for an Employee by their name.
     *
     * @param name the name of the Employee to search for
     * @return the Employee with the given name, or null if no such Employee exists
     */
    public Employee searchEmployeeByName(String name) {
        return employeeSearchMap.get(name);
    }

    /**
     * Prints the unique list of department names.
     *
     * This method outputs all the unique department names stored in the
     * departmentEmployees map. Each department name is guaranteed to be unique,
     * as they are used as keys in the map.
     *
     * Example Output:
     * <pre>
     * ------------- unique Departments --------------
     * [Engineering, Marketing, HR]
     * </pre>
     */
    public void getUniqueDepartment() {
        System.out.println("------------- unique Departments --------------");
        System.out.println(departmentEmployees.keySet());
    }

    /**
     * Lists all employees grouped by their respective departments.
     * This method iterates over the departmentEmployees map and prints out each department name followed by
     * the employees that belong to that department.
     *
     * Example Output:
     * <pre>
     * Department: Engineering
     *   - Employee{id=101, name='Alice Johnson', department='Engineering', salary=90000.0}
     *   - Employee{id=103, name='Carol White', department='Engineering', salary=95000.0}
     * Department: Marketing
     *   - Employee{id=102, name='Bob Smith', department='Marketing', salary=70000.0}
     * </pre>
     */
    public void getEmployeesPerDepartment(){
        for (Map.Entry<String, List<Employee>> entry: departmentEmployees.entrySet()) {
            String department = entry.getKey();
            List<Employee> employees = entry.getValue();
            System.out.println("\nDepartment of: " +department);

            employees.forEach(employee -> System.out.println(" - " + employee));
        }
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
