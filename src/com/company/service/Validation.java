package com.company.service;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;

public class Validation {
    public static void characterСheck(char ch) throws NotValidCharacterException {
        if(ch!='+' &&
            ch!='-'&&
            ch!='/'&&
            ch!='*'&&
            ch!=')'&&
            ch!='('&&
            ch!='.'&&
            String.valueOf(ch).matches("\\D")){
            throw new NotValidCharacterException("Введен не корректный символ");
        }
    }
    public static class ExpressionCheck{
        public static void expressionCheck(String expr) throws NotCorrectExpression {
            int i = expr.length() - 1;
            int p = 0;
            while (String.valueOf(expr.charAt(i)).matches("\\D")) {
                if (expr.charAt(i) == ')') {
                    i--;
                    continue;
                } else {
                    throw new NotCorrectExpression("Введено не корректное выражение");
                }
            }

            while (String.valueOf(expr.charAt(p)).matches("\\D")) {
                if (expr.charAt(p) == '(') {
                    p++;
                    continue;
                } else {
                    throw new NotCorrectExpression("Введено не корректное выражение");
                }
            }

            for (int j = 1; j < expr.length() - 1; j++) {
                if (String.valueOf(expr.charAt(j)).matches("\\D") &&
                    String.valueOf(expr.charAt(j+1)).matches("\\D") &&
                    expr.charAt(j) != ')' && expr.charAt(j) != '(') {
                    throw new NotCorrectExpression("Введено не корректное выражение");
                }
            }

             parenthesisCheck(expr);
        }

        public static void parenthesisCheck(String expr) throws NotCorrectExpression {
            int open = 0;
            int close = 0;
            for (int j = 0; j < expr.length(); j++) {
                if (expr.charAt(j) == ')') {
                    open++;
                } else if (expr.charAt(j) == '(') {
                    close++;
                }
            }

            if (close != open) {
                throw new NotCorrectExpression("Количество открывающих и закрывающих скобок не совпадает");
            }
        }
    }
}
