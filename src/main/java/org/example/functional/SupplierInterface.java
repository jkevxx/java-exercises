package org.example.functional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Demonstrates the use of the Supplier functional interface.
 * Suppliers are useful for "lazy evaluation" – generating values only when they are actually needed.
 */
public class SupplierInterface {

    /**
    * - A supplier supplies some value
    * - It gives us something
    * - The benefit is that something that is costly to produce but only needed in some situations
    *   can be passed as a supplier and then only evaluated if needed
    * */

    // Predefined suppliers for common error messages
    public static final Supplier<String> DEFAULT_ERROR = () -> "Error: Employee details are missing.";
    public static final Supplier<String> TIMESTAMPED_ERROR = () -> "Validation failed at: " + LocalDateTime.now();

    /**
     * Simulates account creation with lazy error message evaluation.
     * 
     * @param e        The employee for whom to create an account.
     * @param errorMsg A supplier that provides the error message if validation fails.
     */
    public static void createAccount(Employee e, Supplier<String> errorMsg){
        Objects.requireNonNull(e, "Employee cannot be null");
        Objects.requireNonNull(errorMsg, "Error message supplier cannot be null");

        if (e.getEmail() == null || e.getEmail().isEmpty()){
            // The supplier is only 'get()' called here, saving resources if the error never occurs
            // System.err.println("LOG: " + errorMsg.get());
            System.out.println("LOG: " + errorMsg.get());
        } else {
            System.out.println("Account created successfully for: " + e.getName());
        }
    }

    /**
     * Demonstration methods for Supplier logic.
     */
    public static void runExamples(){
        Employee invalidEmployee = new Employee(); // No email set
        Employee validEmployee = new Employee("Kevin", "kevin@example.com");

        System.out.println("--- Supplier Examples ---");

        // Example 1: Using a predefined constant supplier
        createAccount(invalidEmployee, DEFAULT_ERROR);

        // Example 2: Using a lazy timestamped supplier (only evaluated on failure)
        createAccount(invalidEmployee, TIMESTAMPED_ERROR);

        // Example 3: Using an inline lambda for custom context-aware messages
        createAccount(validEmployee, () -> "Failed to create account for " + validEmployee.getName());
    }
}
