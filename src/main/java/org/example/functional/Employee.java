package org.example.functional;

public class Employee extends Person{

    protected String employeeId;

    public Employee(){}

    public Employee(String name, String email){
        super(name, email);
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee [ Id: " + employeeId + ", name: " + super.getName() + ", email: " + super.getEmail() + "]";
    }
}
