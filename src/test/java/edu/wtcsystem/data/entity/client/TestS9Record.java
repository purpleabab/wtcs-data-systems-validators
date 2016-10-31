package edu.wtcsystem.data.entity.client;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cwinebrenner
 * @author nataliya.knudson
 * @since 2016-10-31
 */
public class TestS9Record {

    final static String VALIDS9RECORD = "S9102017123456789504999      12";
    final static String NOT_VALIDS9RECORD = "S9AA20171234B67CD504999      W2";


    @Test
    public void testS9RecordCreate() {
        S9Record testS9Record = new S9Record(VALIDS9RECORD);
        assertNotNull(testS9Record);


    }

    @Test
    public void testS9RecordIsValid() {
        S9Record testS9Record = new S9Record(VALIDS9RECORD);
        assertTrue("S9 is not valid and should be: ", testS9Record.isValid());

    }
}
