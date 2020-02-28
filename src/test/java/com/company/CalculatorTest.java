package com.company;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;
import com.company.service.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {


    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @CsvSource({
            "7.1,5.1+2.0",
            "8.0,4.5+3.5",
            "8.4,1.7+6.7"
    })
    void testAnswerPlus(Double expected, String actual) throws NotCorrectExpression, NotValidCharacterException {
            assertEquals(expected,new Calculator().Answer(actual));
    }

    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @CsvSource({
            "2.0,5.5-3.5",
            "1.0,4.5-3.5",
            "-5.0,1.7-6.7"
    })
    void testAnswerMinus(Double expected, String actual) throws NotCorrectExpression, NotValidCharacterException {
        assertEquals(expected, new Calculator().Answer(actual));
    }

    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @CsvSource({
            "10.2,5.1*2.0",
            "15.75,4.5*3.5",
            "11.39,1.7*6.7"
    })
    void testAnswerMultiply(Double expected, String actual) throws NotCorrectExpression, NotValidCharacterException {
        assertEquals(expected, new Calculator().Answer(actual));
    }

    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @CsvSource({
            "2.55,5.1/2.0",
            "1.2857142857142858,4.5/3.5",
            "0.2537313432835821,1.7/6.7"
    })
    void testAnswerDivide(Double expected, String actual) throws NotCorrectExpression, NotValidCharacterException {
        assertEquals(expected, new Calculator().Answer(actual));
    }
}
