package chapter_09.employee_management;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System");
        System.out.println(printEmployeeManagementSysBanner());

        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.addEmployee(new Employee(1, "Mark", "Sales", 2233.50));

        employeeManager.printEmployees();


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
