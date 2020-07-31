package com.company.exceptions;

public class NotValidCharacterException extends Exception {
    public NotValidCharacterException(String errorMessage){
        super(errorMessage);
    }

    public NotValidCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidCharacterException(Throwable cause) {
        super(cause);
    }

    public NotValidCharacterException() {
    }
}
