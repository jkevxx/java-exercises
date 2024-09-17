package org.example.threads;

public class Main {
    public static void main(String[] args) {
        ClassThread obj1 = new ClassThread("t1", 10);
        ClassThread obj2 = new ClassThread("t2", 20);
        ClassThread obj3 = new ClassThread("t3", 40);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);

        t1.start();
        t2.start();
        t3.start();
    }
}