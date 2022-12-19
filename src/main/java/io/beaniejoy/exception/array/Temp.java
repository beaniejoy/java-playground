package io.beaniejoy.exception.array;

public class Temp {

    static void changeObjectValue(Person target) {
        System.out.println("call by reference(method): " + target);
        target.setName("changed");
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("hello");

        System.out.println("before method - Person name: " + person.getName());
        System.out.println("call by reference: " + person);
        changeObjectValue(person);

        System.out.println("after method - Person name: " + person.getName());
    }

    static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
