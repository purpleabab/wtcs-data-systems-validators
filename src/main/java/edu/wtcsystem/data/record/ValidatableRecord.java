package edu.wtcsystem.data.record;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
 * @author cwinebrenner
 * @since 2016-11-02
 */

public abstract class ValidatableRecord extends Record {

    private final ValidatableRecordDefinition RECORD_DEFINITION;
    private Map<String, String> RECORD_VALUES;

    // TODO:It's possible that the record values and parsing of them should move to Record
    public ValidatableRecord(String recordLineText, ValidatableRecordDefinition recordDefinition) {
        // Save the String that makes up the record and note the definition
        super(recordLineText);
        this.RECORD_DEFINITION = recordDefinition;

        // Initialize the Map that will hold record data and parse it using the definition
        RECORD_VALUES = new HashMap<>();
        parseRecord(RECORD_DEFINITION);
    }

    private void parseRecord(ValidatableRecordDefinition recordDefinition) {

        // RECORD_LINE_TEXT is shorter than specified in the recordDefinition
        if (RECORD_LINE_TEXT.length() < recordDefinition.getRecordMaxLength()) {
            throw new IndexOutOfBoundsException();
        }

        for (ValidatableRecordFieldDefinition vrfd : recordDefinition.getRecordFields()) {
            RECORD_VALUES.put(vrfd.FIELD_NAME, RECORD_LINE_TEXT.substring(vrfd.FIELD_START_POSITION, vrfd.FIELD_END_POSITION));
        }
    }

    public ValidatableRecordDefinition getRecordDefinition() {
        return RECORD_DEFINITION;
    }

    public Map<String, String> getRecordValues() {
        return Collections.unmodifiableMap(RECORD_VALUES);
    }

}
