package com.company.exceptions;

public class NotValidCharacterException extends Exception {
    public NotValidCharacterException(String errorMessage){
        super(errorMessage);
    }

}
