package edu.wtcsystem.data.entity.client;

import edu.wtcsystem.data.record.*;
import edu.wtcsystem.data.validator.type.ValidateType;

/**
 * @author cwinebrenner
 * @since 2016-11-07
 */

public class DummyRecord extends ValidatableRecord implements DefinedValidatableRecord {

    private static ValidatableRecordDefinition DEFINITION;
    static {
        /*
        A dummy record with only 2 characters for a fake type identifier
        1-2 Record Type Identifier (e.g. S1, S3, S9)
        */

        DEFINITION = new ValidatableRecordDefinition(DummyRecord.class.getSimpleName(), 2);
        DEFINITION.add(new ValidatableRecordFieldDefinition("recordTypeIdentifier", 0, 2, ValidateType.ALPHA_NUMERIC));
    }

    public DummyRecord(String recordLineText) {
        super(recordLineText, DummyRecord.DEFINITION);
    }

}
