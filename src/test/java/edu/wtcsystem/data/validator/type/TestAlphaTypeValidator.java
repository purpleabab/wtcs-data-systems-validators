package edu.wtcsystem.data.validator.type;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;



/**
 * Created by nataliya.knudson on 11/11/2016.
 */
public class TestAlphaTypeValidator {

    private final static Logger log = Logger.getLogger(TestAlphaNumericTypeValidator.class.getSimpleName());

    final static String ALPHA = "BAstfawe";
    final static String NOT_ALPHA = "{BA12- 45awe}";

    final static AlphaTypeValidator validator = new AlphaTypeValidator();

    @BeforeClass
    public static void logStartingTest() {
        log.info("Unit Testing: Starting AlphaTypeValidator test(s).");
    }

    @Test
    public void testAlphaTypePasses() {
        log.info("  Testing for AlphaTypeValidator alphas pass...");
        assertTrue("AlphaTypeValidator: String with only letters INCORRECTLY marked invalid!", validator.isValid(ALPHA));
    }

    @Test
    public void testNotAlphaTypeFails() {
        log.info("  Testing for AlphaTypeValidator other than alpha in strings fail...");
        assertFalse("AlphaTypeValidator: String with other than only letters INCORRECTLY marked valid!", validator.isValid(NOT_ALPHA));
    }
    @Test
    public void testAlphaTypeDescribeSelf(){
        log.info("  Testing toString for AlphaTypeValidator...");
        assertEquals("AlphaTypeValidator: ", validator.toString() ,"ALPHA: A through Z, upper or lower case.");
    }
}
