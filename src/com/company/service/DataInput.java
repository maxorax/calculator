package com.company.service;

import com.company.exceptions.NotCorrectExpression;
import com.company.service.Calculator;

import java.util.Scanner;

public class DataInput {

    public  void input() throws NotCorrectExpression {
        new Calculator().Answer(new Scanner(System.in).next());

    }
}
