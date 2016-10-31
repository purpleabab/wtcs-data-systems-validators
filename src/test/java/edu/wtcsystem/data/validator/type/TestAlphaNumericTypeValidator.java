package edu.wtcsystem.data.validator.type;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author nataliya.knudson
 * @since 2016-10-31
 */

public class TestAlphaNumericTypeValidator {

    final static String ALPHANUMERIC = "BA1245awe";
    final static String NOT_ALPHANUMERIC = "{BA12- 45awe}";
    final static AlphaNumericTypeValidator validator = new AlphaNumericTypeValidator();

    @Test
    public void testNumericTypePasses() {
        assertTrue("NumericTypeValidator: String with only numbers INCORRECTLY marked invalid", validator.isValid(ALPHANUMERIC));
    }

    @Test
    public void testNotNumericFails() {
        assertFalse("NumericTypeValidator: String with no numbers INCORRECTLY marked valid", validator.isValid(NOT_ALPHANUMERIC));
    }

}
