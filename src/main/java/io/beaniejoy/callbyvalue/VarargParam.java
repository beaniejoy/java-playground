package io.beaniejoy.callbyvalue;

import java.util.Arrays;

public class VarargParam {
    // java에서 가변인자는 메소드 호출시 아무것도 기입해주시 않으면 size 0인 빈 array로 처리된다.
    static void varargTest(String... varargs) {
        System.out.println("varargs: " + Arrays.toString(varargs));
        System.out.println("varargs size: " + varargs.length);
    }

    public static void main(String[] args) {
        /*
          아무것도 기입 안하면
          varargs: []
          varargs size: 0
         */
        varargTest();
    }
}
