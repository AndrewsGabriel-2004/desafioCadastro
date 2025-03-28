package Exceptions;

import java.io.IOException;

public class InvalidIOException extends IOException {
    public InvalidIOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
