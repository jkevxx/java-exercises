package org.example.exam;

import java.util.ArrayList;

public class School {
    private ArrayList<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student stu) {
        this.students.add(stu);
    }

    public int numberApproved() {
        int amount = 0;

        for (Student student : this.students) {
            if (student.approve()) {
                amount++;
            }
        }

        return amount;
    }
}
