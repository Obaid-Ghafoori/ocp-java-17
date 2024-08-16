package chapter_09.employee_management;

public class EmployeeSearchCriteria {

    // Criteria for searching by employee name
    public static EmployeeCriteria<String> byName() {
        return (employee, name) -> employee.name().equalsIgnoreCase(name);
    }
}