package com.company.service;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;
import com.company.service.Validation;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParseStringtoExpression  {


    public  List<String> ExpressionToReservePolishNotation(String expression) throws NotCorrectExpression{
        String expr = preparingExpression(expression);
        Validation.ExpressionCheck.expressionCheck(expr);
        List<String> rpn = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<expr.length();i++) {
            int priority = getPriority(expr.charAt(i));
            if (priority == 0) {
                rpn.add(String.valueOf(expr.charAt(i)));
            }

            if (priority == 1) {
                stack.push(expr.charAt(i));
            }

            if (priority == -2) {
                String temp=rpn.get(rpn.size()-1)+ expr.charAt(i) + expr.charAt(i + 1);
                rpn.set(rpn.size()-1,temp);
                i++;
                if(expr.length() == i+1){
                    break;
                }

            }


            if(priority>1){
                rpn.add(" ");
                while (!stack.empty()){
                    if(getPriority(stack.peek()) >= priority){
                        rpn.add(String.valueOf(stack.pop()));
                    } else {
                        break;
                    }
                }
                stack.push(expr.charAt(i));

            }

            if (priority == -1){
                rpn.add(" ");
                while (getPriority(stack.peek()) != 1) {
                    rpn.add(String.valueOf(stack.pop()));
                }
                stack.pop();
            }
        }

        while (!stack.empty()){
            rpn.add(String.valueOf(stack.pop()));
        }
        return rpn;
    }

    private String preparingExpression(String expr){
        String preparingExpr=new String();
        for (int i = 0; i <expr.length() ; i++) {
            char ch = expr.charAt(i);
            if(i == 0 && ch == '-'){
                preparingExpr += 0;
            } else if(ch == '-' && expr.charAt(i-1) == '('){
                preparingExpr += 0;
            }
            preparingExpr+= ch;
        }
        return preparingExpr;
    }

    public int getPriority(char charachter)  {
        try {
            Validation.characterСheck(charachter);
        } catch (NotValidCharacterException e) {
            e.printStackTrace();
        }
        if(charachter == '*' || charachter == '/'){
            return 3;
        } else if(charachter == '+' || charachter == '-'){
            return 2;
        } else if(charachter == '('){
            return 1;
        }else if(charachter == ')'){
            return -1;
        }else if (charachter == '.'){
            return -2;
        }else {
            return 0;
        }

    }

}
