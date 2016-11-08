package edu.wtcsystem.data.validator.engine;

import edu.wtcsystem.data.entity.client.*;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.wtcsystem.data.record.DefinedValidatableRecord;

/**
 * Takes a provided file, cuts it up into records (lines), generates record objects which implement
 * DefinedValidatableRecord, and feeds an instance of RecordValidatorEngine
 *
 * @author cwinebrenner
 * @author karen.rahmeier
 * @since 2016-11-02
 */

public class FileValidatorEngine {

    private final static String DATA_SYSTEM_ENTITY_CLASS_BASE = "edu.wtcsystem.data.entity";
    private final Logger log = Logger.getLogger(this.getClass());

    private String dataSystem;
    private BufferedReader fileBufferedReader;
    private RecordValidatorEngine recordValidatorEngine;
    private int recordLineCounter;

    public FileValidatorEngine(String dataSystem, BufferedReader fileBufferedReader) {
        this.dataSystem = dataSystem;
        this.fileBufferedReader = fileBufferedReader;
        recordValidatorEngine = new RecordValidatorEngine();
        this.recordLineCounter = recordLineCounter;
    }

    /**
     * validates file one line at a time
     * <p>
     * Returns null if file is valid.
     * returns FileErrorObject which is a list of record error objects, if file is not valid
     */
    public FileErrorObject validateFile() {
        FileErrorObject fileErrorObject = new FileErrorObject();
        RecordErrorObject recordErrorObject = new RecordErrorObject();
        int recordLineCounter = 0;

        try {
            String fileLine;
            while (((fileLine = fileBufferedReader.readLine()) != null) && (fileLine.length() != 0)) {

                log.info("inside validateFile, fileLine is: " + fileLine.toString());
                log.info("recordLineCounter: " + recordLineCounter);

                //only validate S9 records for now...
                if (fileLine.substring(0, 2).equalsIgnoreCase("S9")) {
                    recordErrorObject = recordValidatorEngine.validateRecord(new S9Record(fileLine));

                    //if a not-null recordErrorObject is returned by the validateRecord, add it to the list that becomes the FileErrorObject
                    if (recordErrorObject != null) {
                        //if no listRecordsErrors exists yet, create it
                        if (fileErrorObject.getListRecordErrors() == null) {
                            fileErrorObject.setListRecordErrors(new ArrayList<RecordErrorObject>());
                        }
                        log.info("about to add reo to feo, recordLineCounter: " + recordLineCounter + " recordErrorObject.toString " + recordErrorObject.toString());
                        log.info("fileErrorObject.getListRecordErrors().size(): " + fileErrorObject.getListRecordErrors().size());
                        //add recordError to array list of errors
                        fileErrorObject.getListRecordErrors().add(recordLineCounter, recordErrorObject);
                    }
                    //if record was valid, recordErrorObject will be null, do nothing, don't add it to fileErrorObject
                }
                recordLineCounter++;
            }

        } catch (IOException ioe) {
            log.error("IOE error while reading uploaded file data!", ioe);
        } catch (Exception e) {
            log.error("Unexpected error while reading uploaded file data!", e);
        }

        //TODO consider refactor to be better about returning null object.
        if (fileErrorObject.getListRecordErrors() == null) {
            return null;
        } else {
            return fileErrorObject;
        }
    }

 /*   TODO possible refactor to more abstract validation of more than just S9 records

    // This shouldn't be called unless we know that the line isn't null; move that out of this class!
    private DefinedValidatableRecord S9R(String fileLine) {

        //Consider better validation of Record type

        //String dataSystemRecordClass = DATA_SYSTEM_ENTITY_CLASS_BASE + "." + dataSystem + "." + fileLine.substring(0,2) + "Record";
        //Attempt to instantiate a class of that type, and handle failures to do so - try classloading it first?

        // return a valid DefinedValidatableRecord - using DummyRecord to force return
        return new DummyRecord("00");
    }
*/

}
