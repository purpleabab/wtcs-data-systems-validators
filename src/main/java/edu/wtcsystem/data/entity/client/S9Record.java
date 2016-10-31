package edu.wtcsystem.data.entity.client;

import edu.wtcsystem.data.validator.type.AlphaNumericTypeValidator;
import edu.wtcsystem.data.validator.type.NumericTypeValidator;

/**
 * @author cwinebrenner
 * @author karen.rahmeier
 * @since 2016-10-31
 */
public class S9Record {

    /*
    1-2 Record Type Identifier (e.g. S1, S3, S9)
    3-4 District
    5-8 Fiscal Year
    9-17 District Student ID
    18-23 Program Number
    30 Program Graduate
    31 Technical Skills Attainment
    */

    private String recordTypeIdentifier;
    private String districtId;
    private String fiscalYear;
    private String districtStudentId;
    private String programNumber;
    private String programGraduate;
    private String technicalSkillsAttainment;

    //TODO: Implement error handling. Ideally return  more than just boolean from isValid. Ideally return record line and character with expected and actual result.

    public S9Record(String s9Record) {

        // String indexes are zero-based; all position values from the comment above are reduced by 1
        if (s9Record.length() >= 31) {
            this.recordTypeIdentifier = s9Record.substring(0, 1);
            this.districtId = s9Record.substring(2, 3);
            this.fiscalYear = s9Record.substring(4, 7);
            this.districtStudentId = s9Record.substring(8, 16);
            this.programNumber = s9Record.substring(17, 22);
            this.programGraduate = s9Record.substring(29, 29);  //TODO: maybe don't use substring
            this.technicalSkillsAttainment = s9Record.substring(30, 30);  //TODO: maybe don't use substring
        }
        //TODO: Handle other things for length besides <= 31
        //TODO: Fix substring is not getting what we want
    }

    /**
     * Runs validator methods for each field in the record. Any failure changes isValid to false.
     *
     * @return boolean
     */
    public boolean isValid() {
        boolean isValid = true;
        //TODO: implement validation for all fields
        //TODO: do validation without a bunch of if statements

        if (!(new AlphaNumericTypeValidator().isValid(recordTypeIdentifier))) {
            isValid = false;
        }
        if (!(new NumericTypeValidator().isValid(districtId))) {
            isValid = false;
        }
        if (!(new NumericTypeValidator().isValid(fiscalYear))) {
            isValid = false;
        }
        if (!(new NumericTypeValidator().isValid(districtStudentId))) {
            isValid = false;
        }
        if (!(new NumericTypeValidator().isValid(programNumber))) {
            isValid = false;
        }
        if (!(new NumericTypeValidator().isValid(programGraduate))) {
            isValid = false;
        }
        if (!(new NumericTypeValidator().isValid(technicalSkillsAttainment))) {
            isValid = false;
        }
        return isValid;
    }

    public String getRecordTypeIdentifier() {
        return recordTypeIdentifier;
    }

    public void setRecordTypeIdentifier(String recordTypeIdentifier) {
        this.recordTypeIdentifier = recordTypeIdentifier;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getDistrictStudentId() {
        return districtStudentId;
    }

    public void setDistrictStudentId(String districtStudentId) {
        this.districtStudentId = districtStudentId;
    }

    public String getProgramNumber() {
        return programNumber;
    }

    public void setProgramNumber(String programNumber) {
        this.programNumber = programNumber;
    }

    public String getProgramGraduate() {
        return programGraduate;
    }

    public void setProgramGraduate(String programGraduate) {
        this.programGraduate = programGraduate;
    }

    public String getTechnicalSkillsAttainment() {
        return technicalSkillsAttainment;
    }

    public void setTechnicalSkillsAttainment(String technicalSkillsAttainment) {
        this.technicalSkillsAttainment = technicalSkillsAttainment;
    }

}
