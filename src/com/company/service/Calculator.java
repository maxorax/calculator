package com.company.service;

import com.company.exceptions.NotCorrectExpression;
import com.company.service.ParseStringtoExpression;

import java.util.List;
import java.util.Stack;

public class Calculator extends ParseStringtoExpression {

    public  void Answer(String expr) throws NotCorrectExpression {
        List<String> rpn = ExpressionToReservePolishNotation(expr);
        Stack<Double> stack = new Stack<>();
        String answer = new String();
        for (int i = 0;i < rpn.size();i++){
            if(getPriority(rpn.get(i).charAt(0)) == 0){
                answer += rpn.get(i);
                stack.push(Double.parseDouble(answer));
                answer = new String();
            }

            if(getPriority(rpn.get(i).charAt(0))>1){
                double a= stack.pop();

                double b= stack.pop();
                if(rpn.get(i).charAt(0) == '+'){
                    stack.push(b+a);
                } else if(rpn.get(i).charAt(0) == '-'){
                    stack.push(b-a);
                } else if(rpn.get(i).charAt(0) == '*'){
                    stack.push(b*a);
                } else if(rpn.get(i).charAt(0) == '/' && a !=0){
                    stack.push(b/a);
                } else{
                    throw new NullPointerException("Деление на ноль невозможно");
                }

            }


        }

        System.out.println("Ответ = "+ stack.pop());

    }

}
