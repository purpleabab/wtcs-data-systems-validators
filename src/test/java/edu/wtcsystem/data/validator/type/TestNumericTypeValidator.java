package edu.wtcsystem.data.validator.type;

import org.junit.Test;

import static org.junit.Assert.*;

//TODO: Implement log4j either to a file or database (prefer database)
import org.apache.logging.log4j.*;

/**
 * @author cwinebrenner
 */
public class TestNumericTypeValidator {

    final static NumericTypeValidator validator = new NumericTypeValidator();
    final static String NUMBERS = "123456789";
    final static String NOT_NUMBERS_LETTERS = "abcde";
    final static String NOT_NUMBERS_WILD_CHARACTERS = "!@#$%^&*()_-+=<>?~`";
    final static String NULL_STRING = new String();
    final static String EMPTY_STRING = "";

    @Test
    public void testNumericTypePasses() {
        assertTrue("NumericTypeValidator: String with only numbers INCORRECTLY marked invalid", validator.isValid(NUMBERS));
    }

    @Test
    public void testAlphaFails() {
        assertFalse("NumericTypeValidator: String with alpha, no numbers INCORRECTLY marked valid", validator.isValid(NOT_NUMBERS_LETTERS));
    }

    @Test
    public void testWildFails() {
        assertFalse("NumericTypeValidator: String with whild characters, no numbers INCORRECTLY marked valid", validator.isValid(NOT_NUMBERS_WILD_CHARACTERS));
    }

    @Test
    public void testNullPasses() {
        assertTrue("NumericTypeValidator: NULL String INCORRECTLY marked valid", validator.isValid(NULL_STRING));
    }

    @Test
    public void testEmptyStringPasses() {
        assertTrue("NumericTypeValidator: NULL String INCORRECTLY marked valid", validator.isValid(EMPTY_STRING));
    }
}
