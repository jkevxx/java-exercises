package org.example.functional;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Demonstrates the use of the Predicate functional interface.
 * Predicates are used for evaluation/testing, accepting a single input 
 * and returning a boolean result. They are commonly used for filtering 
 * and validation.
 */
public class PredicateInterface {

    /**
     * - A predicate takes a value and returns a boolean (true or false).
     * - It is essentially a "test" or a "condition".
     */

    // Predefined predicates for common validations
    public static final Predicate<Employee> HAS_VALID_EMAIL = e -> e.getEmail() != null && e.getEmail().contains("@");
    public static final Predicate<Employee> IS_ADMIN = e -> e.getEmployeeId() != null && e.getEmployeeId().startsWith("ADM-");

    /**
     * Validates if an Employee meets a specific condition.
     * 
     * @param e         The employee to validate.
     * @param condition The predicate logic to apply.
     * @return true if the condition is met, false otherwise.
     */
    public static boolean validateEmployee(Employee e, Predicate<Employee> condition) {
        Objects.requireNonNull(e, "Employee cannot be null");
        Objects.requireNonNull(condition, "Condition predicate cannot be null");

        System.out.println("--- Executing Validation Operation ---");
        return condition.test(e); // Here we execute the logic we receive as a parameter
    }

    /**
     * Demonstration methods for Predicate logic.
     */
    public static void runExamples() {
        Employee validEmployee = new Employee("Kevin", "kevin@example.com");
        validEmployee.setEmployeeId("EMP-001");

        Employee adminEmployee = new Employee("Admin User", "admin@company.com");
        adminEmployee.setEmployeeId("ADM-999");

        Employee invalidEmployee = new Employee("Guest", "no-email");

        // Example 1: Basic test for email validation
        System.out.println("Is 'Kevin' email valid? " + validateEmployee(validEmployee, HAS_VALID_EMAIL));
        System.out.println("Is 'Guest' email valid? " + validateEmployee(invalidEmployee, HAS_VALID_EMAIL));
        /*
         * OUTPUT:
         * --- Executing Validation Operation ---
         * Is 'Kevin' email valid? true
         * --- Executing Validation Operation ---
         * Is 'Guest' email valid? false
         */

        // Example 2: Checking for Admin status
        System.out.println("Is 'Admin User' an admin? " + validateEmployee(adminEmployee, IS_ADMIN));
        /*
         * OUTPUT:
         * --- Executing Validation Operation ---
         * Is 'Admin User' an admin? true
         */

        // Example 3: Predicate composition using 'and'
        // Both conditions must be true
        System.out.println("--- Chained Predicates (AND) ---");
        Predicate<Employee> isValidAdmin = HAS_VALID_EMAIL.and(IS_ADMIN);
        System.out.println("Is 'Admin User' a valid admin? " + validateEmployee(adminEmployee, isValidAdmin));
        /*
         * OUTPUT:
         * --- Executing Validation Operation ---
         * Is 'Admin User' a valid admin? true
         */

        // Example 4: Predicate composition using 'or'
        // At least one condition must be true
        System.out.println("--- Chained Predicates (OR) ---");
        Predicate<Employee> isSpecialUser = IS_ADMIN.or(e -> e.getName().equals("Kevin"));
        System.out.println("Is 'Kevin' a special user? " + validateEmployee(validEmployee, isSpecialUser));
        /*
         * OUTPUT:
         * --- Executing Validation Operation ---
         * Is 'Kevin' a special user? true
         */

        // Example 5: Using 'negate' to flip the result
        System.out.println("--- Negated Predicate ---");
        Predicate<Employee> isNOTAdmin = IS_ADMIN.negate();
        System.out.println("Is 'Kevin' NOT an admin? " + validateEmployee(validEmployee, isNOTAdmin));
        /*
         * OUTPUT:
         * --- Executing Validation Operation ---
         * Is 'Kevin' NOT an admin? true
         */
    }
}
