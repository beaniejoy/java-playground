package io.beaniejoy.exception.throwable;

import io.beaniejoy.exception.throwable.ex.CalculationException;
import io.beaniejoy.exception.throwable.ex.DateOutOfRangeException;
import io.beaniejoy.exception.throwable.ex.DateParseException;
import io.beaniejoy.exception.throwable.ex.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

/**
 * > about "Root Cause"
 * - DateParseException 상속받은 exception
 *      - DateOutOfRangeException
 *      - InvalidFormatException
 * [code reference] https://www.baeldung.com/java-exception-root-cause
 */
@Slf4j
public class AgeCalculator {
    private static LocalDate parseDate(String birthDateAsString) {
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateAsString);
        } catch (DateTimeParseException ex) {
            // InvalidFormatException -> DateTimeParseException
            log.error("[DateTimeParseException] {}", ex.getMessage());
            throw new InvalidFormatException(birthDateAsString, ex);
        }

        if (birthDate.isAfter(LocalDate.now())) {
            log.error("[DateOutOfRangeException] birthDate must be before now");
            throw new DateOutOfRangeException(birthDateAsString);
        }

        return birthDate;
    }


    public static int calculateAge(String birthDate) {
        if (birthDate == null || birthDate.isEmpty()) {
            log.error("[IllegalArgumentException] birthDate must not be null or empty");
            throw new IllegalArgumentException();
        }

        try {
            return Period
                    .between(parseDate(birthDate), LocalDate.now())
                    .getYears();
        } catch (DateParseException ex) {
            // CalculationException -> DateParseException -> DateTimeParseException
            log.error("[DateParseException] {}", ex.getMessage());
            throw new CalculationException(ex);
        }
    }
}
