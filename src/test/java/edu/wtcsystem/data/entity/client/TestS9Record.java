package edu.wtcsystem.data.entity.client;

import java.util.List;

import edu.wtcsystem.data.validator.engine.RecordValidatorEngine;
import edu.wtcsystem.data.record.ValidatableRecordFieldDefinition;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class TestS9Record {

    private final static Logger log = Logger.getLogger(TestS9Record.class.getSimpleName());

    final static String RECORD_TYPE_NAME = "S9Record";
    final static int VALID_S9_RECORD_MAX_LENGTH = 31;
    final static String VALID_S9_RECORD = "S9102017123456789504999      12";
    final static String NOT_VALID_S9_RECORD = "S9AA20171234B67CD504999      W2";
    final static String NOT_VALID_S9_RECORD_TOO_SHORT = "S91020112";

    final static RecordValidatorEngine RVE = new RecordValidatorEngine();

    @Test
    public void testS9RecordCreate() {
        S9Record testS9 = new S9Record(VALID_S9_RECORD);
        assertNotNull(testS9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testS9RecordTooShort() {
        S9Record testS9 = new S9Record(NOT_VALID_S9_RECORD_TOO_SHORT);
        assertNull("S9 Record too short and did not throw expected IndexOutOfBounds exception!", testS9);
    }

    @Test
    public void testS9ReadDefinition() {
        S9Record testS9 = new S9Record(VALID_S9_RECORD);

        assertEquals("S9: Can't read record class type!", RECORD_TYPE_NAME, testS9.getRecordDefinition().getRecordTypeName());
        assertEquals("S9: Can't read definition max length!", VALID_S9_RECORD_MAX_LENGTH, testS9.getRecordDefinition().getRecordMaxLength());

        List<ValidatableRecordFieldDefinition> testFieldsDefinition = testS9.getRecordDefinition().getRecordFields();
        assertNotNull("S9Record: Can't read list of fields!", testFieldsDefinition);
    }

    // TODO: Maybe these two tests should go in a tester for the RecordValidationEngine
    @Test
    public void testValidS9RecordPasses() {
        S9Record testS9 = new S9Record(VALID_S9_RECORD);
        boolean testS9IsValid = RVE.validateRecord(testS9);
        assertTrue("Valid S9 record failed validation!", testS9IsValid);
    }

    @Test
    public void testInvalidS9RecordFails() {
        S9Record testS9 = new S9Record(NOT_VALID_S9_RECORD);
        boolean testS9IsValid = RVE.validateRecord(testS9);
        assertFalse("Invalid S9 record passed validation!", testS9IsValid);
    }

}
