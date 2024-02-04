package com.example.DemoSwagger.Exception;

public class AlumnoNotFoundException extends RuntimeException {

    public AlumnoNotFoundException(String message) {
        super(message);
    }

    public AlumnoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}