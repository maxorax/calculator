package com.company.service;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator extends ParseStringToExpression {

    public Double Answer(String expr) throws NotCorrectExpression, NotValidCharacterException {
        List<String> rpn = ExpressionToReservePolishNotation(expr);
        String expression= String.valueOf(rpn).replaceAll(", ","");
        expression=expression.replaceAll("\\[","");
        expression=expression.replaceAll("]","");

        Stack<Double> stack = new Stack<>();
        String answer = new String();
        for (int i = 0;i < expression.length();i++){
            if(expression.charAt(i)== ' ') continue;
            if(getPriority(expression.charAt(i)) == 0){
                while (getPriority(expression.charAt(i)) == 0 &&
                        expression.charAt(i)!= ' ' ||
                        getPriority(expression.charAt(i))==-2){
                    answer+=expression.charAt(i);
                    i++;
                    if(i==expression.length()) break;
                }
                stack.push(Double.parseDouble(answer));
                answer = new String();
            }

            if(getPriority(expression.charAt(i))>1  ){
                double a= stack.pop();

                double b= stack.pop();

                if(expression.charAt(i) == '+'){
                    stack.push(b+a);
                } else if(expression.charAt(i) == '-'){
                    stack.push(b-a);
                } else if(expression.charAt(i) == '*'){
                    stack.push(b*a);
                } else if(expression.charAt(i) == '/' && a !=0){
                    stack.push(b/a);
                } else{
                    throw new NullPointerException("Деление на ноль невозможно");
                }

            }


        }
            return stack.pop();
    }

}
