package org.example.exam;

public class OralExam extends Exam {
    private SatisfactionLevel satisfactionLevel;

    public OralExam(SatisfactionLevel satisfactionLevel, String date) {
        super(date);
        this.satisfactionLevel = satisfactionLevel;
    }

    @Override
    public boolean approve() {
        return satisfactionLevel.ordinal() >= SatisfactionLevel.SUFFICIENT.ordinal();
    }
}
