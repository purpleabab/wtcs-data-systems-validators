package edu.wtcsystem.data.validator.type;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cwinebrenner
 */
public class TestNumericTypeValidator {

    private final Logger log = Logger.getLogger(this.getClass());

    final static String NUMERIC = "123456789";
    final static String NOT_NUMERIC = "abcde";
    final static NumericTypeValidator validator = new NumericTypeValidator();

    @Test
    public void testNumericTypePasses() {
        log.info("Testing for AlphaNumericTypeValidator pass...");
        assertTrue("NumericTypeValidator: String with only numbers INCORRECTLY marked invalid!", validator.isValid(NUMERIC));
    }

    @Test
    public void testNotNumericTypeFails() {
        log.info("Testing for AlphaNumericTypeValidator fail...");
        assertFalse("NumericTypeValidator: String with no numbers INCORRECTLY marked valid!", validator.isValid(NOT_NUMERIC));
    }

}
