package src;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static src.Utils.*;

class MainTest {

    @Test
    public void argsLenCheckTest(){
        //Should throw an exception if there are more than 2 arguments
        assertThrows(IllegalArgumentException.class, () -> argsLenCheck("1, 2, 3"));

        //Should not throw an exception if there are 2 arguments or less
        assertDoesNotThrow(() -> argsLenCheck("1, 5"));

        assertDoesNotThrow(() -> argsLenCheck("1"));
    }

    @Test
    public void parseInputTest() {
        //Should parse the input and return a list of numbers
        List<Integer> result = parseInput("1, 3");
        assertEquals(Arrays.asList(1, 3), result);

        //Should handle invalid numbers
        result = Utils.parseInput("1, B");
        assertEquals(Arrays.asList(1, 0), result);

        //Should handle new line delimiters
        result = Utils.parseInput("1\n5");
        assertEquals(Arrays.asList(1, 5), result);
    }

    @Test
    public void parseNumberTest(){
        //Should parse numbers and return a number
        Integer result = parseNumber("1");
        assertEquals(1, result);

        result = parseNumber("25");
        assertEquals(25, result);

        //Should convert invalid numbers to 0
        result = parseNumber("b");
        assertEquals(0, result);

        result = parseNumber("-z");
        assertEquals(0, result);
    }

    @Test
    public void sumTest(){
        //Should sum list of ints, handling an empty list
        int results = sum(Arrays.asList(3, 5));
        assertEquals(8, results);

        results = sum(Arrays.asList(20));
        assertEquals(20, results);

        results = sum(Collections.emptyList());
        assertEquals(0, results);
    }

    @Test
    public void positiveNumberTest(){
        //Should check to see if string contains a number
        boolean isNumber = isNumeric("1");
        assertTrue(isNumber);

        isNumber = isNumeric ("-10");
        assertTrue(isNumber);

        isNumber = isNumeric ("b");
        assertFalse(isNumber);
    }

}
