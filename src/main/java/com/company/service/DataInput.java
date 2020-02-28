package com.company.service;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;

public class DataInput {

    public Double input(String expression) throws NotCorrectExpression, NotValidCharacterException {
      return new Calculator().Answer(expression);

    }
}
