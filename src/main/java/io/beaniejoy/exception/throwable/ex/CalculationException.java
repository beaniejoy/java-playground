package io.beaniejoy.exception.throwable.ex;

public class CalculationException extends RuntimeException {
    public CalculationException(DateParseException ex) {
        super(ex);
    }
}
