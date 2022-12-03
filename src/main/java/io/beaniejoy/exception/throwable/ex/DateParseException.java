package io.beaniejoy.exception.throwable.ex;

public class DateParseException extends RuntimeException {
    public DateParseException(String message) {
        super(message);
    }

    public DateParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
