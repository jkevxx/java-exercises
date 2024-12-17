package org.example.exercises.company;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void showSalaries() {
        for (Employee emp : employees) {
            System.out.println(emp.FullName() + ": $" + emp.getSalary());
        }
    }

    public Employee employeeMoreClients() {
        int max = -1;
        Employee maxEmployee = null;
        for (Employee emp : employees) {
            if (emp instanceof CommissionEmployee) {
                int clients = ((CommissionEmployee) emp).getNumberClientsCaptured();
                if (clients > max) {
                    max = clients;
                    maxEmployee = emp;
                }
            }
        }
        return maxEmployee;
    }

}
