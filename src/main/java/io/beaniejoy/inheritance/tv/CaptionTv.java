package io.beaniejoy.inheritance.tv;

public class CaptionTv extends Tv{
    boolean caption;

    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
            System.out.println("power: " + power);
            System.out.println("channel: " + channel);
        }
    }

    @Override
    void channelUp() {
        System.out.println("CaptionTv channelUp");
        ++channel;

        // CaptionTv에 channel 필드 추가한 경우 별개로 움직임(일종의 Overriding)
        // channel 필드 없는 경우 상속 받은 Tv의 channel 필드를 그대로 사용하게 됨
        System.out.println("CaptionTv channel: " + this.channel);
        System.out.println("Tv channel: " + super.channel);
    }

    @Override
    void channelDown() {
        System.out.println("CaptionTv channelDown");
        --channel;

        System.out.println("CaptionTv channel: " + this.channel);
        System.out.println("Tv channel: " + super.channel);
    }
}
