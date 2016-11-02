package edu.wtcsystem.data.record;

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
abstract class RecordFieldDefinition {

    final String FIELD_NAME;
    final int FIELD_START_POSITION;
    final int FIELD_END_POSITION;

    RecordFieldDefinition(String fieldName, int startPosition, int endPosition) {
        this.FIELD_NAME = fieldName;
        this.FIELD_START_POSITION = startPosition;
        this.FIELD_END_POSITION = endPosition;
    }

}
