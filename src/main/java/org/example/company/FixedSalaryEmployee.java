package org.example.company;

public class FixedSalaryEmployee extends Employee {

    private static final double PORC1 = 0.05;
    private static final double PORC2 = 0.1;
    private static final int YEAR1 = 2;
    private static final int YEAR2 = 5;
    private double basicSalary;

    public FixedSalaryEmployee(String DNI, String name, String lastName, int yearEntry, double basicSalary) {
        super(DNI, name, lastName, yearEntry);
        this.basicSalary = basicSalary;
    }

    private double additionalPercent() {
        int seniority = employeeSeniority();
        double percent = 0;
        if (seniority > YEAR2) {
            percent = PORC2;
        } else if (seniority > YEAR1) {
            percent = PORC1;
        }

        return percent;
    }

    @Override
    public double getSalary() {
        return basicSalary + (basicSalary * additionalPercent());
    }
}
