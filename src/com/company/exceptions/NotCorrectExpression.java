package com.company.exceptions;

public class NotCorrectExpression extends Exception {
    public NotCorrectExpression(String errorMessage){
        super(errorMessage);
    }

    public NotCorrectExpression(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectExpression(Throwable cause) {
        super(cause);
    }

    public NotCorrectExpression() {
    }
}
