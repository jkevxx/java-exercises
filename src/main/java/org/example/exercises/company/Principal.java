/**
 * https://youtu.be/gHy4Ls7E49c?si=U0R026maCFbEg46B
 */

package org.example.exercises.company;

public class Principal {

    public static void main(String[] args){
        Company company = new Company();
        company.addEmployee(new FixedSalaryEmployee("123A", "John", "Doe", 2022, 1000.0));
        company.addEmployee(new FixedSalaryEmployee("123B", "Jane", "Doe", 2016, 2000.0));
        company.addEmployee(new CommissionEmployee("123C", "Joe", "Smith", 2012, 1000.0, 100, 500));
        company.addEmployee(new CommissionEmployee("123D", "Janet", "Smith", 2012, 10000.0, 101, 60));

        company.showSalaries();

        System.out.println(company.employeeMoreClients().FullName());

    }
}
