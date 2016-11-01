package edu.wtcsystem.data.record;

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
public class RecordField {

    //TODO: Make all protected for direct access (make all final, a la immutable?) or add getters/setters
    private String fieldName;
    private int startPosition;
    private int endPosition;
    protected final ValidateType fieldType;

    public RecordField(String fieldName, int startPosition, int endPosition, ValidateType fieldType) {
        this.fieldName = fieldName;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.fieldType = fieldType;
    }

}
