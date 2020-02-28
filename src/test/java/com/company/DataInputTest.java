package com.company;

import com.company.exceptions.NotCorrectExpression;
import com.company.exceptions.NotValidCharacterException;
import com.company.service.DataInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

public class DataInputTest {
    @ParameterizedTest(name = "{index} => expected={0}, actual={1}")
    @CsvSource({
            "7.0,2+5",
            "2.4,2*1.2"
    })
    void testInput(Double expected,String actual) throws NotCorrectExpression, NotValidCharacterException {
        assertEquals(expected,new DataInput().input(actual));
    }

}
