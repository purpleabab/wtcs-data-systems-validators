package edu.wtcsystem.data.entity.client;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Class to hold list of record error objects
 *
 *
 *
 * Created by karen.rahmeier on 11/7/2016.
 */
public class FileErrorObject {
    private final Logger log = Logger.getLogger(FileErrorObject.class.getSimpleName());

    /**map of file line number, error record pairs*/
    List<RecordErrorObject> listRecordErrors;

    public FileErrorObject() {
    }

    public FileErrorObject(List<RecordErrorObject> listRecordErrors) {
        this.listRecordErrors = listRecordErrors;
    }

    public List<RecordErrorObject> getListRecordErrors() {
        return listRecordErrors;
    }

    public void setListRecordErrors(List<RecordErrorObject> listRecordErrors) {
        this.listRecordErrors = listRecordErrors;
    }
}
