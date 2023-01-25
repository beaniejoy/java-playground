package io.beaniejoy.inheritance.tv;

public class CaptionTvTestMain {
    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();

        ctv.displayCaption("Hello CaptionTv!");
        ctv.caption = true;
        ctv.displayCaption("Hello CaptionTv after caption mode on");

        System.out.println("-------------");

        // CaptionTv에 channel 필드 추가한 경우
        Tv tv = new CaptionTv();
        // Tv class의 channel 필드에 반영 (CaptionTv channel 필드 X)
        tv.channel = 20;
        // CaptionTv의 Overriding channelUp 메소드 사용
        tv.channelUp();
    }
}
