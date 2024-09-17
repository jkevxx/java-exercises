package org.example.threads;

public class Test implements Runnable {
    int a = 0, b = 0;

    int incrementA() {
        return ++a;
    }

    int incrementB() {
        return ++b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.print("A:" + incrementA() + ", B:" + incrementB() + ", ");
        }
    }

    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        t1.start();
        t2.start();
    }

}
