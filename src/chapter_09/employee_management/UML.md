    +-----------------------------------------------+
    |                <<interface>>                  |
    |               EmployeeCriteria<T>             |
    +-----------------------------------------------+
    | + test(employee: Employee, value: T): boolean |
    +-----------------------------------------------+
                        ^
                        |
                        | Implements
                        |
                        v
    +-----------------------------------------------+                               +--------------------------------------------------------------------------------------+
    |           EmployeeSearchCriteria              |                               |                                   EmployeeManager                                    |
    +-----------------------------------------------+                               +--------------------------------------------------------------------------------------+
    | + byName(): EmployeeCriteria<String>          |                               | - employees: List<Employee>                                                          |
    | + byDepartment(): EmployeeCriteria<String>    |                               | - departmentEmployees: Map<String, List<Employee>>                                   |
    | + bySalaryRange(): EmployeeCriteria<Double[]> |                               | - uniqueEmployeeIds: Set<Integer>                                                    |
    +-----------------------------------------------+                               | - employeeSearchMap: Map<String, Employee>                                           |
                                                                                    +--------------------------------------------------------------------------------------+
                                                                                    | + searchEmployees(criteria: EmployeeCriteria<Object>, value: Object): List<Employee> |
                                                                                    +--------------------------------------------------------------------------------------+
                                                                                                                       ^
                                                                                                                       |
                                                                                                                       | Uses
                                                                                                                       |
                                                                                                                       v
                                                                                                            +-----------------------+
                                                                                                            |     Employee          |
                                                                                                            +-----------------------+
                                                                                                            | - id: int             |
                                                                                                            | - name: String        |
                                                                                                            | - department: String  |
                                                                                                            | - salary: double      |
                                                                                                            +-----------------------+
                                                                                                            | + id(): int           |
                                                                                                            | + name(): String      |
                                                                                                            | + department(): String|
                                                                                                            | + salary(): double    |
                                                                                                            +-----------------------+
