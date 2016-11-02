package edu.wtcsystem.data.entity.client;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

import java.util.List;

import edu.wtcsystem.data.record.ValidatableRecordFieldDefinition;

/**
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class TestS9RecordFields {

    private final static Logger log = Logger.getLogger(TestS9RecordFields.class.getSimpleName());

    final static String VALID_S9_RECORD = "S9102017123456789504999      12";
    //final static String NOT_VALID_S9_RECORD = "S9AA20171234B67CD504999      W2";

    @Ignore
    public void testS9RecordFieldModify() {
        S9Record testS9 = new S9Record(VALID_S9_RECORD);
        List<ValidatableRecordFieldDefinition> S9fields = testS9.getRecordDefinition().getRecordFields();
        ValidatableRecordFieldDefinition tvrfd = S9fields.get(0);
    }

}