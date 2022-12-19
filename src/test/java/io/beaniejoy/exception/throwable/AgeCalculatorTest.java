package io.beaniejoy.exception.throwable;

import io.beaniejoy.exception.throwable.ex.CalculationException;
import io.beaniejoy.exception.throwable.ex.DateOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * exception 발생에 대한 root cause 확인 테스트
 */
class AgeCalculatorTest {
    @Test
    @DisplayName("parsing exception에 대한 root cause 확인")
    void getAge() {
        int age = AgeCalculator.calculateAge("2000-10-25");
        System.out.println("age: " + age);
        assertEquals(22, age);
    }

    @Test
    @DisplayName("parsing exception에 대한 root cause 확인")
    void findRootCauseWhenThrowingParsingException() {
        CalculationException ex = assertThrows(CalculationException.class, () -> {
            AgeCalculator.calculateAge("abcd-10-25");
        });

        Throwable rootCause = findCauseUsingPlainJava(ex);
        System.out.println("rootCause: " + rootCause.getClass());
        assertTrue(rootCause instanceof DateTimeParseException);    // DateTimeParseException
    }

    @Test
    @DisplayName("현재 날짜 이후 입력값에 대한 root cause 확인")
    void findRootCauseWhenThrowingOutOfRangeException() {
        CalculationException ex = assertThrows(CalculationException.class, () -> {
            AgeCalculator.calculateAge("2999-10-25");
        });

        Throwable rootCause = findCauseUsingPlainJava(ex);
        System.out.println("rootCause: " + rootCause.getClass());
        assertTrue(rootCause instanceof DateOutOfRangeException);   // DateOutOfRangeException
    }

    private static Throwable findCauseUsingPlainJava(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable rootCause = throwable;
        int index = 0;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            System.out.println("## [" + (index++) + "] cause: " + rootCause.getCause().getClass());
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
}