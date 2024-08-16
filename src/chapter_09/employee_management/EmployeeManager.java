package chapter_09.employee_management;

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

    public EmployeeManager() {
        this.employees = new ArrayList<>();
        this.uniqueEmployeeIds = new HashSet<>();
        this.departmentEmployees = new HashMap<>();
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
        departmentEmployees.computeIfAbsent(employee.department().toLowerCase(), k -> new ArrayList<>()).add(employee);

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
     * <p>
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
     * Searches for employees based on a generic criterion.
     *
     * @param criteria the criterion to be used for searching
     * @param value    the value to be used in the criterion
     * @param <T>      the type of the value parameter
     * @return a list of employees that match the criteria
     */
    public <T> List<Employee> searchEmployees(EmployeeCriteria<T> criteria, T value) {
        return employees.stream()
                .filter(employee -> criteria.test(employee, value))
                .collect(Collectors.toList());
    }

    /**
     * Prints the unique list of department names.
     * <p>
     * This method outputs all the unique department names stored in the
     * departmentEmployees map. Each department name is guaranteed to be unique,
     * as they are used as keys in the map.
     * <p>
     * Example Output:
     * <pre>
     * ------------- unique Departments --------------
     * Engineering
     * Marketing
     * HR
     *
     * </pre>
     */

    public void getUniqueDepartment() {
        Set<String> uniqueDepartments = departmentEmployees.keySet();

        // Print header
        System.out.println("\n+-------- unique Departments -----------+");

        // Print each department on a new line
        for (String department : uniqueDepartments) {
            System.out.printf("| \t%-35s |\n", department);
        }

        // Print footer
        System.out.println("+---------------- End ------------------+");
    }

    /**
     * Lists all employees grouped by their respective departments.
     * This method iterates over the departmentEmployees map and prints out each department name followed by
     * the employees that belong to that department.
     * <p>
     * Example Output:
     * <pre>
     * Department: Engineering
     *   - Employee{id=101, name='Alice Johnson', department='Engineering', salary=90000.0}
     *   - Employee{id=103, name='Carol White', department='Engineering', salary=95000.0}
     * Department: Marketing
     *   - Employee{id=102, name='Bob Smith', department='Marketing', salary=70000.0}
     * </pre>
     */
    public void getEmployeesPerDepartment() {
        for (Map.Entry<String, List<Employee>> entry : departmentEmployees.entrySet()) {
            String department = entry.getKey();
            List<Employee> employees = entry.getValue();
            System.out.println("\nDepartment of: " + department);

            employees.forEach(employee -> System.out.println(" - " + employee));
        }
    }


    /**
     * Calculates the average salary of employees in a specific department.
     * <p>
     * This method retrieves the list of employees for the given department from the internal
     * {@code departmentEmployees} map. If the department does not exist or has no employees,
     * the method returns {@code 0.0}. Otherwise, it computes the average of the salaries of
     * all employees in that department using Java Streams.
     *
     * @param department The name of the department to calculate the average salary for.
     *                   Should not be {@code null}. If the department does not exist or has
     *                   no employees, {@code 0.0} is returned.
     * @return The average salary of employees in the specified department. Returns {@code 0.0}
     * if the department has no employees or does not exist.
     */
    public double calculateAverageSalary(String department) {
        var deptEmployees = departmentEmployees.get(department.toLowerCase());
        if (deptEmployees == null || deptEmployees.isEmpty()) {
            return 0.00;
        }

        var averageSalary = deptEmployees.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0.00);

        System.out.printf("Average Salary in " + department.toUpperCase() +  ": %19s\n", averageSalary);
        return averageSalary;
    }


    public double calculateTotalSalary(String department) {
        var deptEmployees = departmentEmployees.get(department.toLowerCase());
        double totalSalary = deptEmployees.isEmpty() || deptEmployees == null ? 0.00 :
                deptEmployees.stream()
                        .mapToDouble(Employee::salary)
                        .sum();
        System.out.printf("Total Salary in " + department.toUpperCase() + ": %22s\n", totalSalary);
        return totalSalary;
    }

    public long countNumberOfEmployees(String department) {
        var deptEmployees = departmentEmployees.get(department.toLowerCase());
        var numberOfEmployees = deptEmployees == null || deptEmployees.isEmpty() ? 0 :
                deptEmployees.stream()
                        .mapToInt(Employee::id)
                        .count();

        System.out.println("Total number of employees in " + department.toUpperCase() + ":  " + numberOfEmployees);
        return numberOfEmployees;
    }

    public double calculateTotalWegCost(){
        var totalSalaryOfEmployees = employees.isEmpty() || employees == null ? 0.00 :
                employees.stream().mapToDouble(Employee::salary).sum();
        System.out.printf("Total weg cost is " + ": %32s\n", totalSalaryOfEmployees);
        return totalSalaryOfEmployees;
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
