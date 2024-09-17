package org.example.threads;

public class ClassThread implements Runnable {

    private String name;
    private int number;

    public ClassThread(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < number) {
            System.out.println("Thread " + name + ": " + count);
            count++;
        }
    }
}
