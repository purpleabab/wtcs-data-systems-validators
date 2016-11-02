package edu.wtcsystem.data.entity.client;

import edu.wtcsystem.data.record.Record;
import edu.wtcsystem.data.record.RecordField;
import edu.wtcsystem.data.validator.type.ValidateType;

/**
 * @author cwinebrenner
 * @since 2016-11-01
 */
//TODO: Replace S9Record with this, and rename, after refactor to generic record definition/validation
public class ValidatableS9Record extends Record {

    /*
    1-2 Record Type Identifier (e.g. S1, S3, S9)
    3-4 District
    5-8 Fiscal Year
    9-17 District Student ID
    18-23 Program Number
    30 Program Graduate
    31 Technical Skills Attainment
    */

    public ValidatableS9Record(String recordLineText) {
        super(recordLineText);
        initializeRecord();
    }

    public ValidatableS9Record(String recordLineText, int recordLine) {
        super(recordLineText, recordLine);
        initializeRecord();
    }

    //TODO: This might need one more level of abstraction to avoid mass initializing RecordFields
    private void initializeRecord() {
        recordFields.add(new RecordField("recordTypeIdentifier", 0, 2, ValidateType.ALPHA_NUMERIC));
        recordFields.add(new RecordField("districtId", 2, 4, ValidateType.NUMERIC));
        recordFields.add(new RecordField("fiscalYear", 4, 8, ValidateType.NUMERIC));
        recordFields.add(new RecordField("districtStudentId", 8, 17, ValidateType.NUMERIC));
        recordFields.add(new RecordField("programNumber", 17, 23, ValidateType.NUMERIC));
        recordFields.add(new RecordField("programGraduate", 29, 30, ValidateType.NUMERIC));
        recordFields.add(new RecordField("technicalSkillsAttainment", 30, 31, ValidateType.NUMERIC));
    }

}
