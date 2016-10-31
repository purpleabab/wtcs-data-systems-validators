package edu.wtcsystem.data.entity.client;

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

    //TODO implement error handling.  Ideally return  more than just boolean from isValid.  Ideally return record line and character with expected and actual result

    public S9Record() {
        //default empty constructor
    }

    public S9Record(String s9Record) {
        //TODO: parse out an S9 record into strings that are in S9
    }

    /**
     * Runs validator methods for each field and returns true if all pass
     *
     * @return boolean
     */
    public boolean isValid() {
        boolean isValid = false;
        //TODO implement validation for all fields

        if (new NumericTypeValidator().isValid(districtId)) {
            isValid = true;
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
