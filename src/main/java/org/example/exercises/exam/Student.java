package org.example.exercises.exam;

import java.util.ArrayList;

public class Student implements Approvable {

    private String DNI;
    private String name;
    private String lastName;
    private ArrayList<Exam> exams;

    public Student(String DNI, String name, String lastName){
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.exams = new ArrayList<>();
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addExam(Exam ex){
        this.exams.add(ex);
    }

    @Override
    public boolean approve(){
        int i = 0;
        while (i < this.exams.size() && this.exams.get(i).approve()){
            i++;
        }

        return i == this.exams.size();
    }
}
