package edu.wtcsystem.data.entity.client;

import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

import org.apache.logging.log4j.Logger;

/**
 * @author cwinebrenner
 * @author nataliya.knudson
 * @since 2016-10-31
 */
public class TestS9Record {
    //private final Logger log = Logger.//Logger.getLogger(this.getClass());

    final static String VALIDS9RECORD = "S9102017123456789504999      12";
    final static String NOT_VALIDS9RECORD = "S9AA20171234B67CD504999      W2";
    final static String NOT_VALIDS9RECORD_TOO_SHORT = "S91020112";


    @Test
    public void testS9RecordCreate() {
        S9Record testS9Record = new S9Record(VALIDS9RECORD);
        assertNotNull(testS9Record);


    }
    // @Test(expected = IllegalStateException.class)

    @Test
    public void testS9RecordIsValid() {
        S9Record testS9Record = new S9Record(VALIDS9RECORD);
        System.out.println("toString of s9" + testS9Record.toString());

        assertTrue("S9 is not valid and should be: ", testS9Record.isValid());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testS9RecordIsValid_IOE() {
        S9Record testS9Record = new S9Record(NOT_VALIDS9RECORD_TOO_SHORT );
        assertFalse("S9 did not throw expected IOE exception: ", testS9Record.isValid());
    }

    @Test
    public void testS9RecordIsNotValid(){
        S9Record testS9RecordIsNotValid = new S9Record(NOT_VALIDS9RECORD);
        System.out.println("toString of s9" + testS9RecordIsNotValid.toString());
        assertFalse("S9 is not valid and should be: ", testS9RecordIsNotValid.isValid());
    }

}
