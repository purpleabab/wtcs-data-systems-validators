package edu.wtcsystem.data.record;

import edu.wtcsystem.data.validator.type.ValidateType;

/**
 * @author cwinebrenner
 * @since 2016-11-02
 */

public class ValidatableRecordFieldDefinition extends RecordFieldDefinition {

    private final ValidateType FIELD_VALIDATE_TYPE;

    public ValidatableRecordFieldDefinition(String fieldName, int startPosition, int endPosition, ValidateType fieldType) {
        super(fieldName, startPosition, endPosition);
        this.FIELD_VALIDATE_TYPE = fieldType;
    }

    public ValidateType getFieldValidateType() {
        return FIELD_VALIDATE_TYPE;
    }

    @Override
    public String toString() {
        return FIELD_NAME + " in position " +
                ((FIELD_START_POSITION + 1) == (FIELD_END_POSITION) ?
                        (FIELD_END_POSITION) : ((FIELD_START_POSITION + 1) + "-" + (FIELD_END_POSITION))) +
                " is validated as " + FIELD_VALIDATE_TYPE.toString();
    }

}
