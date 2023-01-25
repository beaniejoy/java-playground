package io.beaniejoy.inheritance.composite;

/**
 * composite(포함) 관계
 * - is a 관계: 상속관계가 낫다.
 * - has a 관계: 포함관계가 낫다.
 */
public class Circle {
    // Circle has a Point < 말이 된다.
    Point point = new Point();
    int r;
}
