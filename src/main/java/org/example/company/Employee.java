package org.example.company;

import java.time.LocalDate;

public abstract class Employee {

    private String DNI;
    private String name;
    private String lastName;
    private int yearEntry;


    public Employee(String DNI, String name, String lastName, int yearEntry){
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.yearEntry = yearEntry;
    }

    public int employeeSeniority(){
        int yearActual = LocalDate.now().getYear();
        return yearActual - yearEntry;
    }

    public String FullName(){
        return name + " " + lastName;
    }

    public abstract double getSalary();


}
