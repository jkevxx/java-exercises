/**
 * https://youtu.be/utvV8syEYLw?si=4raWFd8HyQEuSUdE
 */

package org.example.exercises.exam;

public class Principal {

    public static void main(String[] args) {
        School school = new School();

        Student pepe = new Student("123", "Pepe", "X");
        Student maria = new Student("321", "Maria", "Y");
        Student luis = new Student("231", "Luis", "Z");

        pepe.addExam(new WrittenExam(40, 7, "00/00/000"));
        pepe.addExam(new OralExam(SatisfactionLevel.SUFFICIENT, "00/00/000"));

        maria.addExam(new WrittenExam(60, 4, "00/00/000"));
        maria.addExam(new WrittenExam(65, 8, "00/00/000"));
        maria.addExam(new OralExam(SatisfactionLevel.EXCELLENT, "00/00/000"));

        luis.addExam(new WrittenExam(100, 9, "00/00/000"));
        luis.addExam(new OralExam(SatisfactionLevel.INSUFFICIENT, "00/00/000"));
        luis.addExam(new OralExam(SatisfactionLevel.EXCELLENT, "00/00/000"));

        school.addStudent(pepe);
        school.addStudent(maria);
        school.addStudent(luis);

        System.out.println("Approved number: " + school.numberApproved());

    }
}
