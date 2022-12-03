package io.beaniejoy.exception.throwable;

import io.beaniejoy.exception.throwable.ex.CalculationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * exception 발생에 대한 root cause 확인 테스트
 */
class AgeCalculatorTest {
    @Test
    @DisplayName("parsing exception에 대한 root cause 확인")
    public void findRootCauseWhenThrowingParsingException() {
        try {
            int calculateAge = AgeCalculator.calculateAge("ladsf-10-25");
            System.out.println("age: " + calculateAge);
        } catch (CalculationException ex) {
            Throwable rootCause = findCauseUsingPlainJava(ex);
            System.out.println("rootCause: " + rootCause.getClass());
            assertTrue(rootCause instanceof DateTimeParseException);
        }
    }

    public static Throwable findCauseUsingPlainJava(Throwable throwable) {
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