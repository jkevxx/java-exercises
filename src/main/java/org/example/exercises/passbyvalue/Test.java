// Source: https://x.com/SumitM_X/status/2004121074666295523?s=20

package org.example.exercises.passbyvalue;

class Person {
    String name;
}

public class Test {

    static void modify(Person obj){
        obj.name = "Rahul";
        obj = new Person();
        obj.name = "Amit";

    }

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Submit";
        modify(p);
        System.out.println(p.name); // Rahul
    }
}

