package edu.wtcsystem.data.validator.type;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
public class TestNumericTypeValidator {

    private final static Logger log = Logger.getLogger(TestNumericTypeValidator.class.getSimpleName());

    final static String NUMERIC = "123456789";
    final static String NOT_NUMERIC_LETTERS = "abcde";
    final static String NOT_NUMERIC_SYMBOLS = "!@#$%^&*()_-+=<>?~`";
    final static String UNINITIALIZED_STRING = new String();
    final static String EMPTY_STRING = "";

    final static NumericTypeValidator validator = new NumericTypeValidator();

    @BeforeClass
    public static void logStartingTest() {
        log.info("Unit Testing: Starting NumericTypeValidator test(s).");
    }

    @Test
    public void testNumericTypePasses() {
        log.info("  Testing for NumericTypeValidator numbers pass...");
        assertTrue("NumericTypeValidator: String with only numbers INCORRECTLY marked invalid!", validator.isValid(NUMERIC));
    }

    @Test
    public void testAlphaFails() {
        log.info("  Testing for NumericTypeValidator alphas fail...");
        assertFalse("NumericTypeValidator: String with alpha, no numbers INCORRECTLY marked valid!", validator.isValid(NOT_NUMERIC_LETTERS));
    }

    @Test
    public void testSymbolsFails() {
        log.info("  Testing for NumericTypeValidator symbols fail...");
        assertFalse("NumericTypeValidator: String with symbols, no numbers INCORRECTLY marked valid!", validator.isValid(NOT_NUMERIC_SYMBOLS));
    }

    @Test
    public void testUninitializedStringFails() {
        log.info("  Testing for NumericTypeValidator uninitialized String() fails...");
        assertFalse("NumericTypeValidator: uninitialized String INCORRECTLY marked valid!", validator.isValid(UNINITIALIZED_STRING));
    }

    @Test
    public void testEmptyStringFails() {
        log.info("  Testing for NumericTypeValidator empty string fails...");
        assertFalse("NumericTypeValidator: Empty String INCORRECTLY marked valid!", validator.isValid(EMPTY_STRING));
    }

    @Test(expected = NullPointerException.class)
    public void testNullObjectReferenceFails() {
        log.info("  Testing for NumericTypeValidator null fails...");
        assertFalse("NumericTypeValidator: null reference INCORRECTLY marked valid!", validator.isValid(null));
    }

}
