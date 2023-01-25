package io.beaniejoy.callbyvalue;

/**
 * 사실 call by reference는 없다. call by value만 있을뿐
 * 객체나 배열을 인자로 전달했을 때 해당 객체(배열)의 주소값이 복사되어 메소드 인자로 전달되는 것일뿐(call by value)
 */
public class CallByReferenceAndValue {

    // Person 객체의 주소값이 복사되어 전달받은 것일 뿐
    static void changeObjectValue(Person target) {
        System.out.println("call by reference(method): " + target);
        // 전달받은 주소값에 해당하는 객체 내용을 수정(heap memory에 있는 객체 정보를 수정하는 것)
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
