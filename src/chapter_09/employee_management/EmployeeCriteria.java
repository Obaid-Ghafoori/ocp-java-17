package chapter_09.employee_management;

/**
 * A functional interface for defining search criteria for employees.
 *
 * @param <T> the type of the employee attribute to be searched
 */
@FunctionalInterface
public interface EmployeeCriteria<T> {
    /**
     * Tests whether the given employee matches the criteria.
     *
     * @param employee the employee to be tested
     * @param value the value to be used in the test
     * @return true if the employee matches the criteria, otherwise false
     */
    boolean test(Employee employee, T value);
}
