package edu.wtcsystem.data.record;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Stub for later refactoring (e.g. S3Record extends Record).
 *
 * @author cwinebrenner
 * @since 2016-10-31
 */
public abstract class Record implements Validatable {

    //TODO: Unsure how to implement-iterate fields and add RecordField, value to Map (require Map<> change) or just name, value

    protected int recordLine = 0;
    protected String recordLineText;
    protected List<RecordField> recordFields;
    protected Map<String, String> recordValues;

    public Record(String recordLineText) {
        this.recordLineText = recordLineText;
        recordFields = new ArrayList<>();
        recordValues = new HashMap<>();
    }

    public Record(String recordLineText, int recordLine) {
        this(recordLineText);
        this.recordLine = recordLine;
    }

    //TODO: Actually implement generic record validation
    @Override
    public boolean isRecordValid() {
        return true;
    }

}
