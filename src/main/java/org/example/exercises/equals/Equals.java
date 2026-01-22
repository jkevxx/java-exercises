package org.example.exercises.equals;

import java.util.HashSet;
import java.util.Set;
/*
 * https://x.com/iamsaquibdev/status/1995055207844397425?s=20
 */

public class Equals {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "John";
        p2.name = "John";

        set.add(p1);
        System.out.println(set.contains(p2));
    }
}

class Person {
    String name;

    @Override
    public boolean equals(Object o) {
        return name.equals(((Person)o).name);
    }
}