package edu.wtcsystem.data.validator.type;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author nataliya.knudson
 * @author cwinebrenner
 * @since 2016-10-31
 */
public class TestAlphaNumericTypeValidator {

    private final static Logger log = Logger.getLogger(TestAlphaNumericTypeValidator.class.getSimpleName());

    final static String ALPHA_NUMERIC = "BA1245awe";
    final static String NOT_ALPHA_NUMERIC = "{BA12- 45awe}";

    final static AlphaNumericTypeValidator validator = new AlphaNumericTypeValidator();

    @BeforeClass
    public static void logStartingTest() {
        log.info("Unit Testing: Starting AlphaNumericTypeValidator test(s).");
    }

    @Test
    public void testAlphaNumericTypePasses() {
        log.info("  Testing for AlphaNumericTypeValidator alphas and numbers pass...");
        assertTrue("AlphaNumericTypeValidator: String with only letters and numbers INCORRECTLY marked invalid!", validator.isValid(ALPHA_NUMERIC));
    }

    @Test
    public void testNotAlphaNumericTypeFails() {
        log.info("  Testing for AlphaNumericTypeValidator other than alpha and number in strings fail...");
        assertFalse("AlphaNumericTypeValidator: String with other than only letters and numbers INCORRECTLY marked valid!", validator.isValid(NOT_ALPHA_NUMERIC));
    }
    @Test
    public void testAlphaNumericTypeDescribeSelf(){
        log.info("  Testing toString for AlphaNumericTypeValidator...");
        assertEquals("AlphaNumericTypeValidator: ", validator.toString() ,"ALPHA_NUMERIC: A through Z, upper or lower case, and digits 0 through 9.");
    }

}
