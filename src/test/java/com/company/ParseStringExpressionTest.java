package com.company;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;
import com.company.service.ParseStringToExpression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParseStringExpressionTest extends ParseStringToExpression {

    @Test
    void testExpressionToReservePolishNotation() throws NotCorrectExpression, NotValidCharacterException {
        List<String> expected= new ArrayList<String>();
        expected.add("5.1");
        expected.add(" ");
        expected.add("2.0");
        expected.add("+");
        assertEquals(expected,ExpressionToReservePolishNotation("5.1+2.0"));
    }
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @CsvSource({
            "(0-1),(-1)",
            "3*(0-2),3*(-2)"
    })
    void testPreparingExpression(String expected, String actual){
        assertEquals(expected,preparingExpression(actual));
    }

    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @CsvSource({
            "3,*",
            "2,+",
            "1,(",
            "-1,)",
            "0,2",
            "-2,."
    })
    void testGetPriority(int expected, char actual) throws NotCorrectExpression, NotValidCharacterException {
        assertEquals(expected,getPriority(actual));
    }

}
