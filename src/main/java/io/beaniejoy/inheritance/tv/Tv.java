package io.beaniejoy.inheritance.tv;

public class Tv {
    // default modifier -> allowed in the same class file or package
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        System.out.println("Tv channelUp");
        ++channel;
    }

    void channelDown() {
        System.out.println("Tv channelDown");
        --channel;
    }
}
