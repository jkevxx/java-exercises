package org.example.functional;

import java.util.function.Function;

/**
 * - What do functions (with a capital F) do?
 * - Allow us to convert one thing to another...
 * - So let's see an example:
 *    - Say we are a HR system
 *    - We want to allow different companies using our software to be able to specify how they generate an employee id
 *    - We can use a function for that
 */

public class FunctionInterface {

    Employee generateEmployeeId(Person p, Function<Person, String> mapToId){
        Employee e = new Employee();
        e.setName(p.getName());
        e.setEmail(p.getEmail());
        e.setEmployeeId(mapToId.apply(p)); // here we apply the logic that we received as parameter
        System.out.println(e);
        return e;
    };

    Person p = new Person("Kevin", "kevin.paez1010@gmail.com");

    public void company1GenerateEmployee() {
        generateEmployeeId(p, pp -> pp.getEmail().toUpperCase());
    }

    public void company2GenerateEmployee(){
        generateEmployeeId(p, pp -> pp.getEmail() + pp.getName());
    }

}
