package chapter_09.employee_management;

import java.util.List;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System");
        System.out.println(printEmployeeManagementSysBanner());

        EmployeeManager manager = new EmployeeManager();

        List<Employee> employees = EmployeeData.getSampleEmployees();
        employees.forEach(manager::addEmployee);

        Employee employee = new Employee(131, "Mark Bula", "Sales", 2283.50);
        manager.addEmployee(employee);


        Employee existingEmployee = manager.getEmployeeById(110);

        manager.updateEmployee(existingEmployee.withAttributes("Tom Tesson", "Operation", 2000.00));

        manager.printEmployees();

        manager.getUniqueDepartment();

        manager.getEmployeesPerDepartment();

        // Search by name
        List<Employee> employeesByName = manager.searchEmployees(EmployeeSearchCriteria.byName(), "Alice Johnson");
        System.out.println("\n - Employees by name: " + employeesByName);


    }

    private static String printEmployeeManagementSysBanner() {
        return """
                  _____                 _                           __  __                                                   _       ____            _                \s
                 | ____|_ __ ___  _ __ | | ___  _   _  ___  ___    |  \\/  | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_    / ___| _   _ ___| |_ ___ _ __ ___ \s
                 |  _| | '_ ` _ \\| '_ \\| |/ _ \\| | | |/ _ \\/ _ \\   | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __|   \\___ \\| | | / __| __/ _ \\ '_ ` _ \\\s
                 | |___| | | | | | |_) | | (_) | |_| |  __/  __/   | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_     ___) | |_| \\__ \\ ||  __/ | | | | |
                 |_____|_| |_| |_| .__/|_|\\___/ \\__, |\\___|\\___|   |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__|   |____/ \\__, |___/\\__\\___|_| |_| |_|
                                 |_|            |___/                                        |___/                                         |___/ \s
                                                   \s
                 .--.       .--. .                .\s
                 |   )     :    :|          o     |\s
                 |--:.  .  |    ||.-. .-.   .  .-.|\s
                 |   )  |  :    ;|   |   )  | (   |\s
                 '--'`--|   `--' '`-' `-'`-' `-`-'`-
                        ;                          \s
                     `-'
                """;
    }
}
