package edu.wtcsystem.data.validator.type;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author nataliya.knudson
 * @author cwinebrenner
 * @since 2016-10-31
 */
public class TestAlphaNumericTypeValidator {

    private final Logger log = Logger.getLogger(this.getClass());

    final static String ALPHA_NUMERIC = "BA1245awe";
    final static String NOT_ALPHA_NUMERIC = "{BA12- 45awe}";
    final static AlphaNumericTypeValidator validator = new AlphaNumericTypeValidator();

    @Test
    public void testAlphaNumericTypePasses() {
        log.info("Testing for AlphaNumericTypeValidator pass...");
        assertTrue("AlphaNumericTypeValidator: String with only letters and numbers INCORRECTLY marked invalid!", validator.isValid(ALPHA_NUMERIC));
    }

    @Test
    public void testNotAlphaNumericTypeFails() {
        log.info("Testing for AlphaNumericTypeValidator fail...");
        assertFalse("AlphaNumericTypeValidator: String with other than only letters and numbers INCORRECTLY marked valid!", validator.isValid(NOT_ALPHA_NUMERIC));
    }

}
