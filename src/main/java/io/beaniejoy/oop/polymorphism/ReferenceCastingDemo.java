package io.beaniejoy.oop.polymorphism;

/**
 * 결국 fe, fe2, car 참조변수가 같은 FireEngine 객체를 참조하고 있는 것임
 * fe2 <- car 를 주목, down casting 경우 명시적으로 casting 지정해야함
 */
public class ReferenceCastingDemo {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;
//        car.water();

        fe2 = (FireEngine) car; // 상위 타입 -> 하위 타입 casting (명시적 casting 필요)
        fe2.water();

        // 하위 타입으로 instanceof 해도 실제 상위 타입의 참조변수가 해당 인스턴스를 가리키고 있으면 true
        if (car instanceof FireEngine) {
            System.out.println("car can be casted to FireEngine");
            FireEngine feRef = (FireEngine) car;
            feRef.water();
        }
    }
}
