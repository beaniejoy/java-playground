package io.beaniejoy.loop;

public class NamedLoop {

    /**
     * break Loop; 2 * 4에서 완전 종료
     * continue Loop1; 구구단에서 각 단은 4까지만 진행
     */
    static void multiplyInOrder() {
        Loop1 : for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 5) {
                    break Loop1;    // Loop1으로 지정된 전체 for loop을 종료
                    //continue Loop1;
                }
                System.out.println(i + "*" + j + "=" + i * j);
            } // end of nested for loop
            System.out.println();
        } // end of Loop1
    }

    public static void main(String[] args) {
        multiplyInOrder();
    }
}
