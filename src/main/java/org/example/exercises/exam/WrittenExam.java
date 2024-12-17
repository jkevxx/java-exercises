package org.example.exercises.exam;

public class WrittenExam extends Exam {

    private static final int MIN_NOTE = 0;
    private static final int MAX_NOTE = 10;
    private static final int APPROVE_NOTE = 6;
    private static final int MIN_DURATION = 90;

    private int duration;
    private int note;

    public WrittenExam(int duration, int note, String date) {
        super(date);
        this.duration = duration;
        this.note = note;
    }


    @Override
    public boolean approve() {
        return note >= APPROVE_NOTE && duration <= MIN_DURATION;
    }
}
