package edu.wtcsystem.data.entity.client;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold list of record error objects
 * <p>
 * <p>
 * <p>
 * Created by karen.rahmeier on 11/7/2016.
 */
public class FileErrorObject {
    private final Logger log = Logger.getLogger(FileErrorObject.class.getSimpleName());

    /**
     * map of file line number, error record pairs
     */
    private List<RecordErrorObject> listRecordErrors;

    public FileErrorObject(List<RecordErrorObject> listRecordErrors) {
        this.listRecordErrors = listRecordErrors;
    }


    /**
     * constructor
     */
    public FileErrorObject() {
        this.listRecordErrors = new ArrayList<>();
    }

    public List<RecordErrorObject> getListRecordErrors() {
        return (listRecordErrors.size() == 0 ? null : listRecordErrors);
    }


    public void addRecordError(RecordErrorObject recordErrorObject) {
        listRecordErrors.add(recordErrorObject);
    }

    /**
     * Nice display of all errors
     */
    public String getDisplayOfAllErrors() {
        String displayMessage = "";
        if (getListRecordErrors().size() > 0) {
            for (RecordErrorObject recordErrorObject : getListRecordErrors()) {
                displayMessage = displayMessage + recordErrorObject.toString();
            }
        } else {
            displayMessage = "No errors found.";
        }
        return displayMessage;
    }

}
