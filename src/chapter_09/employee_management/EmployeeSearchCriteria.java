package chapter_09.employee_management;

public class EmployeeSearchCriteria {

    // Criteria for searching by employee name
    public static EmployeeCriteria<String> byName() {
        return (employee, name) -> employee.name().equalsIgnoreCase(name);
    }

    // Criteria for searching by employee department
    public static EmployeeCriteria<String> byDepartment() {
        return (employee, department) -> employee.department().equalsIgnoreCase(department);
    }

    // Criteria for searching by employee salary
    public static EmployeeCriteria<Double[]> bySalaryRange() {
        return (employee, range) ->{
            double minSalary = range[0];
            double maxSalary = range[1];
            return employee.salary() >= minSalary && employee.salary() <= maxSalary;
        };
    }
}