package com.company;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;
import com.company.service.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionsTest {


    @Test
    void testCharacterСheck() throws NotValidCharacterException {
        Throwable throwable= assertThrows(NotValidCharacterException.class,()->{
            new Calculator().Answer("y+5.3+2.1");
        });
        assertNotNull(throwable.getMessage());

    }
    @Test
    void testExpressionCheck() throws NotCorrectExpression {
        Throwable throwable= assertThrows(NotCorrectExpression.class,()->{
            new Calculator().Answer("(5.3+2.1)+");
        });
        assertNotNull(throwable.getMessage());
    }

    @Test
    void testParenthesisCheck() throws NotCorrectExpression {
        Throwable throwable= assertThrows(NotCorrectExpression.class,()->{
            new Calculator().Answer("(5.3+2.1)*5)");
        });
        assertNotNull(throwable.getMessage());
    }

    @Test
    void testNullPointerExceptions() throws NullPointerException{
        Throwable throwable= assertThrows(NullPointerException.class,()->{
            new Calculator().Answer("((5.3+2.1)/0)");
        });
        assertNotNull(throwable.getMessage());
    }
}
