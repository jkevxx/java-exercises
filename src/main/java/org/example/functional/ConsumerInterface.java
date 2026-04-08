package org.example.functional;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Demonstrates the use of the Consumer functional interface.
 * Consumers are used for operations that accept a single input and return no result,
 * typically used for side effects like logging, updating state, or processing data.
 */
public class ConsumerInterface {

    /**
     * - A consumer take a value and does something with it
     * - It returns nothing
     */

    // Predefined loggers for consistency and reuse
    public static final Consumer<Employee> BASIC_LOGGER = e -> System.out.println("Employee: " + e.getName());
    public static final Consumer<Employee> DETAILED_LOGGER = e -> {
        System.out.println("Detailed Log -> Name: " + e.getName() + " | Email: " + e.getEmail() + " | ID: " + e.getEmployeeId());
    };

    /**
     * Executes a logging operation on an Employee.
     * 
     * @param e      The employee to log.
     * @param logger The consumer logic to apply (e.g., printing to console, saving to a file).
     * @throws NullPointerException if the employee or logger is null.
     */
    public static void logEmployee(Employee e, Consumer<Employee> logger){
        Objects.requireNonNull(e, "Employee cannot be null");
        Objects.requireNonNull(logger, "Logger cannot be null");

        System.out.println("--- Executing Log Operation ---");
        logger.accept(e); // Here we execute the logic we receive as a parameter
    }

    /**
     * Demonstration methods for Consumer logic.
     */
    public static void runExamples(){
        Employee sampleEmployee = new Employee("Kevin", "kevin@example.com");
        sampleEmployee.setEmployeeId("EMP-001");

        // Example 1: Using a predefined basic logger
        logEmployee(sampleEmployee, BASIC_LOGGER);
        /*
        * OUTPUT:
        * --- Executing Log Operation ---
        * Employee: Kevin
        * */

        // Example 2: Using a predefined detailed logger
        logEmployee(sampleEmployee, DETAILED_LOGGER);
        /*
         * OUTPUT:
         * --- Executing Log Operation ---
         * Detailed Log -> Name: Kevin | Email: kevin@example.com | ID: EMP-001
         * */

        // Example 3: Using Consumer composition with 'andThen'
        // This executes the first consumer and then the second one
        System.out.println("--- Chained Consumers ---");
        Consumer<Employee> combinedLogger = BASIC_LOGGER.andThen(e -> System.out.println("Logging timestamp: " + java.time.LocalDateTime.now()));
        logEmployee(sampleEmployee, combinedLogger);
        /*
        * --- Executing Log Operation ---
        * Employee: Kevin
        * Logging timestamp: 2026-04-07T19:54:02.022032
        * */

        // Example 4: Using an inline lambda for custom logic
        logEmployee(sampleEmployee, e -> {
            System.out.println("Custom Log: Sending notification to " + e.getEmail());
        });
        /*
         * --- Executing Log Operation ---
         * Custom Log: Sending notification to kevin@example.com
         * */
    }
}
