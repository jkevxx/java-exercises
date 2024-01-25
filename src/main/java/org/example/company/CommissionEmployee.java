package org.example.company;

public class CommissionEmployee extends Employee {
    private double minSalary;
    private int numberClientsCaptured;
    private double amountClient;

    public CommissionEmployee(String DNI, String name, String lastName, int yearEntry, double minSalary, int numberClientsCaptured, double amountClient) {
        super(DNI, name, lastName, yearEntry);
        this.minSalary = minSalary;
        this.numberClientsCaptured = numberClientsCaptured;
        this.amountClient = amountClient;
    }

    public int getNumberClientsCaptured() {
        return numberClientsCaptured;
    }

    @Override
    public double getSalary() {
        double salary = numberClientsCaptured * amountClient;

        if (salary < minSalary) {
            salary = minSalary;
        }
        return salary;
    }

}
