package edu.wtcsystem.data.validator.engine;

import edu.wtcsystem.data.entity.client.RecordErrorObject;
import edu.wtcsystem.data.entity.client.S9Record;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by karen.rahmeier on 11/8/2016.
 */
public class RecordValidatorEngineTest {
    private final static Logger log = Logger.getLogger(RecordValidatorEngineTest.class.getSimpleName());

    final private static String VALID_S9_RECORD = "S9102017123456789504999      12";
    final private static String NOT_VALID_S9_RECORD = "S9AA20171234B67CD504999      W2";
    private RecordValidatorEngine recordValidatorEngine;
    private RecordErrorObject recordErrorObject;

    @Before
    public void setup() {
        recordValidatorEngine = new RecordValidatorEngine();
        recordErrorObject = new RecordErrorObject();
    }


    @Test
    public void validateRecordValidS9RecordPasses() throws Exception {
        S9Record testS9 = new S9Record(VALID_S9_RECORD);
        recordErrorObject = recordValidatorEngine.validateRecord(testS9);
        assertNull("Valid S9 record failed validation!",recordErrorObject);
    }

    @Test
    public void validateRecordInvalidS9RecordFails() throws Exception {
        S9Record testS9 = new S9Record(NOT_VALID_S9_RECORD);
        recordErrorObject = recordValidatorEngine.validateRecord(testS9);
        assertNotNull("Invalid S9 record passed validation!",recordErrorObject);
    }
}