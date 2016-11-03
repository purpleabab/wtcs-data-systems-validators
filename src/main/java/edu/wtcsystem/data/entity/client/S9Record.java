package edu.wtcsystem.data.entity.client;

import edu.wtcsystem.data.record.*;
import edu.wtcsystem.data.validator.type.ValidateType;

/**
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class S9Record extends ValidatableRecord implements DefinedValidatableRecord {

    private static ValidatableRecordDefinition DEFINITION;
    static {
        /*
        1-2 Record Type Identifier (e.g. S1, S3, S9)
        3-4 District
        5-8 Fiscal Year
        9-17 District Student ID
        18-23 Program Number
        30 Program Graduate
        31 Technical Skills Attainment
        */

        DEFINITION = new ValidatableRecordDefinition(S9Record.class.getSimpleName(), 31);
        DEFINITION.add(new ValidatableRecordFieldDefinition("recordTypeIdentifier", 0, 2, ValidateType.ALPHA_NUMERIC));
        DEFINITION.add(new ValidatableRecordFieldDefinition("districtId", 2, 4, ValidateType.NUMERIC));
        DEFINITION.add(new ValidatableRecordFieldDefinition("fiscalYear", 4, 8, ValidateType.NUMERIC));
        DEFINITION.add(new ValidatableRecordFieldDefinition("districtStudentId", 8, 17, ValidateType.NUMERIC));
        DEFINITION.add(new ValidatableRecordFieldDefinition("programNumber", 17, 23, ValidateType.NUMERIC));
        DEFINITION.add(new ValidatableRecordFieldDefinition("programGraduate", 29, 30, ValidateType.NUMERIC));
        DEFINITION.add(new ValidatableRecordFieldDefinition("technicalSkillsAttainment", 30, 31, ValidateType.NUMERIC));
    }

    public S9Record(String recordLineText) {
        super(recordLineText, S9Record.DEFINITION);
    }

}
