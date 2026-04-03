package org.example.functional;

import java.util.Objects;
import java.util.function.Function;

/**
 * Demonstrates the use of the Function functional interface to decouple 
 * object transformation logic from the core business process.
 */
public class FunctionInterface {

    // Predefined ID generation strategies for reuse and clarity
    public static final Function<Person, String> EMAIL_UPPERCASE = p -> p.getEmail().toUpperCase();
    public static final Function<Person, String> EMAIL_AND_NAME = p -> p.getEmail() + "_" + p.getName().replace(" ", "");

    /**
     * Generates an Employee from a Person using a customizable ID mapping function.
     * 
     * @param person   The person to convert.
     * @param idMapper The logic used to generate the unique employee ID.
     * @return A new Employee instance.
     */
    public static Employee createEmployee(Person person, Function<Person, String> idMapper) {
        Objects.requireNonNull(person, "Person cannot be null");
        Objects.requireNonNull(idMapper, "ID Mapper function cannot be null");

        Employee employee = new Employee(person.getName(), person.getEmail());
        employee.setEmployeeId(idMapper.apply(person));
        return employee;
    }

    /**
     * Demonstration methods for specific company logic.
     */
    public static void runExamples() {
        Person samplePerson = new Person("Kevin Paez", "kevin.paez1010@gmail.com");

        // Example 1: Using a predefined strategy
        Employee emp1 = createEmployee(samplePerson, EMAIL_UPPERCASE);
        System.out.println("Company 1 (Email UpperCase): " + emp1);

        // Example 2: Using an inline lambda for custom logic
        Employee emp2 = createEmployee(samplePerson, EMAIL_AND_NAME);
        System.out.println("Company 2 (Email + Name): " + emp2);
        
        // Example 3: Using a custom complex logic via method reference or lambda
        Employee emp3 = createEmployee(samplePerson, p -> "EMP-" + System.currentTimeMillis() + "-" + p.getName().hashCode());
        System.out.println("Company 3 (Complex Random ID): " + emp3);
    }
}
