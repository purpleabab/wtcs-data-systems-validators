package edu.wtcsystem.data.entity.client;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cwinebrenner
 * @author nataliya.knudson
 * @since 2016-10-31
 */
public class TestS9Record {

    private final Logger log = Logger.getLogger(this.getClass());

    final static String VALID_S9_RECORD = "S9102017123456789504999      12";
    final static String NOT_VALID_S9_RECORD = "S9AA20171234B67CD504999      W2";
    final static String NOT_VALID_S9_RECORD_TOO_SHORT = "S91020112";

    @Test
    public void testS9RecordCreate() {
        S9Record testS9Record = new S9Record(VALID_S9_RECORD);
        assertNotNull(testS9Record);
    }
    // @Test(expected = IllegalStateException.class)

    @Test
    public void testS9RecordIsValid() {
        S9Record testS9Record = new S9Record(VALID_S9_RECORD);
        System.out.println("toString of s9" + testS9Record.toString());

        assertTrue("S9 is not valid and should be: ", testS9Record.isValid());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testS9RecordTooShort() {
        S9Record testS9Record = new S9Record(NOT_VALID_S9_RECORD_TOO_SHORT);
        assertFalse("S9 did not throw expected IOE exception: ", testS9Record.isValid());
    }

}
