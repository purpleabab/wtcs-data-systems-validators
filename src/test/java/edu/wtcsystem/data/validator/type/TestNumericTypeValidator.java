package edu.wtcsystem.data.validator.type;

import org.junit.Test;

import static org.junit.Assert.*;

//TODO: Implement log4j either to a file or database (prefer database)
import org.apache.logging.log4j.*;

/**
 * @author cwinebrenner
 */
public class TestNumericTypeValidator {

    final static String NUMBERS = "123456789";
    final static String NOT_NUMBERS = "abcde";
    final static NumericTypeValidator validator = new NumericTypeValidator();

    @Test
    public void testNumericTypePasses() {
        assertTrue("NumericTypeValidator: String with only numbers INCORRECTLY marked invalid", validator.isValid(NUMBERS));
    }

    @Test
    public void testNotNumericFails() {
        assertFalse("NumericTypeValidator: String with no numbers INCORRECTLY marked valid", validator.isValid(NOT_NUMBERS));
    }

}
