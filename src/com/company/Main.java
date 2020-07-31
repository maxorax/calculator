package com.company;

import com.company.exceptions.NotCorrectExpression;
import com.company.service.DataInput;


public class Main {

    public static void main(String[] args) throws NotCorrectExpression {
        System.out.println("Введите выражение:");
	    new DataInput().input();
    }
}
