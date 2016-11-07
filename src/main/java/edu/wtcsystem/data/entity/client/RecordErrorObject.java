package edu.wtcsystem.data.entity.client;

import org.apache.log4j.Logger;

/**
 * Class to hold errors for records
 * <p>
 * Created by karen.rahmeier on 11/7/2016.
 */
public class RecordErrorObject {
    private final Logger log = Logger.getLogger(RecordErrorObject.class.getSimpleName());

    String fieldName;
    String expectedFieldDataTypeValues;// the toString of the data type
    String actualFieldValue;

    public RecordErrorObject() {
    }

    public RecordErrorObject(int recordLineCounter, String fieldName, String expectedFieldDataTypeValues, String actualFieldValue) {
        this.fieldName = fieldName;
        this.expectedFieldDataTypeValues = expectedFieldDataTypeValues;
        this.actualFieldValue = actualFieldValue;
    }

    public Logger getLog() {
        return log;
    }


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getExpectedFieldDataTypeValues() {
        return expectedFieldDataTypeValues;
    }

    public void setExpectedFieldDataTypeValues(String expectedFieldDataTypeValues) {
        this.expectedFieldDataTypeValues = expectedFieldDataTypeValues;
    }

    public String getActualFieldValue() {
        return actualFieldValue;
    }

    public void setActualFieldValue(String actualFieldValue) {
        this.actualFieldValue = actualFieldValue;
    }

    @Override
    public String toString() {
        return "RecordErrorObject{" +
                ", fieldName='" + fieldName + '\'' +
                ", expectedFieldDataTypeValues='" + expectedFieldDataTypeValues + '\'' +
                ", actualFieldValue='" + actualFieldValue + '\'' +
                '}';
    }
}
