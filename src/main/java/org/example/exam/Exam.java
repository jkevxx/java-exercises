package org.example.exam;

import java.time.LocalDate;

public abstract class Exam implements Approvable{

    public String date;

    public Exam(String date){
        this.date = date;
    }

}
