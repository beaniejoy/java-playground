package io.beaniejoy.oop.inner;

class InnerEx {
    private int outerIv = 0;
    static int outerCv = 0;

    static class StaticInner {
        //        int siv = outerIv;
        int siv = new InnerEx().outerIv;
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0;
        final int LV = 0;

        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv; // JDK 1.8부터 에러 X
            int liv4 = LV;
        }
    }

}
