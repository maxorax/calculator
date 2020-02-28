package com.company;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;
import com.company.service.DataInput;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws NotCorrectExpression, NotValidCharacterException {
        System.out.println("Введите выражение:");
        System.out.println("Ответ ="+new DataInput().input(new Scanner(System.in).next()));
    }
}
