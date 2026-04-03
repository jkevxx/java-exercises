package org.example.functional;

public class Main {

    public static void main(String[] args){
        // Function Interface examples
        System.out.println("--- Function Interface Examples ---");
        FunctionInterface.runExamples();

        // Or we can manually create an employee using a specific strategy
        Person p = new Person("Kevin Paez", "kevin.paez1010@gmail.com");
        Employee e = FunctionInterface.createEmployee(p, person -> "MANUAL-" + person.getName().toUpperCase());
        System.out.println("Manual: " + e);

        // Supplier Interface examples
        System.out.println("\n--- Supplier Interface Examples ---");
        SupplierInterface.runExamples();
    }
}
