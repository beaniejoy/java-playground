package io.beaniejoy.exception.trycatch;

/**
 * try ~ catch ~ finally 구문 순서 테스트
 * 궁금한 부분: try, catch 구문에서 throw 하는 경우 finally 부문은 어떤 순서로 실행?
 * 결과: finally 까지 먼저 진행되고 throw 처리(즉 throw 처리는 가장 마지막에)
 */
public class TryCatchFinallyDemo {
    static void tryCatchFinallyOrderTest() {
        try {
            System.out.println("### [tryCatchFinallyOrderTest] start");
            throw new RuntimeException("### [tryCatchFinallyOrderTest] test"); // 1.
        } catch (RuntimeException ex) {
            System.out.println("### [tryCatchFinallyOrderTest] catch");    // 2.
            throw new RuntimeException(ex);  // 4.
        } finally {
            System.out.println("### [tryCatchFinallyOrderTest] finally");  // 3.
        }
    }

    static void tryCatchFinallyOrderTest2() {
        try {
            System.out.println("### [tryCatchFinallyOrderTest2] start");
            throw new RuntimeException("### [tryCatchFinallyOrderTest2] test"); // 1.
        } finally {
            System.out.println("### [tryCatchFinallyOrderTest2] finally");  // 3.
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("### [main] start"); // 1.
//            tryCatchFinallyOrderTest();
            tryCatchFinallyOrderTest2();
        } catch (RuntimeException ex) {
            System.out.println("### [main] catch " + ex.getMessage());  // 5.
        } finally {
            System.out.println("### [main] finally");   // 6.
        }
    }
}
