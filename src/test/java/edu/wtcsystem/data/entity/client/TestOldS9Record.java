package edu.wtcsystem.data.entity.client;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cwinebrenner
 * @author nataliya.knudson
 * @since 2016-10-31
 */
public class TestOldS9Record {

    private final static Logger log = Logger.getLogger(TestOldS9Record.class.getSimpleName());

    final static String VALID_S9_RECORD = "S9102017123456789504999      12";
    final static String NOT_VALID_S9_RECORD = "S9AA20171234B67CD504999      W2";
    final static String NOT_VALID_S9_RECORD_TOO_SHORT = "S91020112";

    @BeforeClass
    public static void logStartingTest() {
        log.info("Unit Testing: Starting OLD S9 Record test(s).");
    }

    @Test
    public void testS9RecordCreate() {
        log.info("  Testing for valid OLD S9 Record creation pass...");
        OldS9Record testOldS9Record = new OldS9Record(VALID_S9_RECORD);
        assertNotNull(testOldS9Record);
    }

    @Test
    public void testS9RecordIsValid() {
        log.info("  Testing for internal valid OLD S9 Record self-validation pass...");
        OldS9Record testOldS9Record = new OldS9Record(VALID_S9_RECORD);
        assertTrue("S9 Record is not valid and should be!", testOldS9Record.isValid());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testS9RecordTooShort() {
        log.info("  Testing for short invalid OLD S9 Record fail...");
        OldS9Record testOldS9Record = new OldS9Record(NOT_VALID_S9_RECORD_TOO_SHORT);
        assertFalse("S9 Record too short and did not throw expected IndexOutOfBounds exception!", testOldS9Record.isValid());
    }

    @Test
    public void testS9RecordIsNotValid() {
        log.info("  Testing invalid OLD S9 Record fields fail...");
        OldS9Record testOldS9Record = new OldS9Record(NOT_VALID_S9_RECORD);
        assertFalse("S9 Record invalid internal field(s) INCORRECTLY marked as valid!", testOldS9Record.isValid());
    }

}
