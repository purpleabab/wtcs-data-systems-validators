package edu.wtcsystem.data.record;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class ValidatableRecordDefinition {

    private final int RECORD_MAX_LENGTH;
    private List<ValidatableRecordFieldDefinition> recordFields;

    public ValidatableRecordDefinition(int recordMaxLength) {
        this.RECORD_MAX_LENGTH = recordMaxLength;
        recordFields = new ArrayList<>();
    }

    public void add(ValidatableRecordFieldDefinition recordDefinition) {
        recordFields.add(recordDefinition);
    }

    public int getRecordMaxLength() {
        return RECORD_MAX_LENGTH;
    }

    public List<ValidatableRecordFieldDefinition> getRecordFields() {
        return Collections.unmodifiableList(recordFields);
    }

}
