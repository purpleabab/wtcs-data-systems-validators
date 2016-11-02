package edu.wtcsystem.data.record;

import edu.wtcsystem.data.validator.type.ValidateType;

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
public class RecordField {

    protected final String fieldName;
    protected final int startPosition;
    protected final int endPosition;
    protected final ValidateType fieldType;

    public RecordField(String fieldName, int startPosition, int endPosition, ValidateType fieldType) {
        this.fieldName = fieldName;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.fieldType = fieldType;
    }

}
