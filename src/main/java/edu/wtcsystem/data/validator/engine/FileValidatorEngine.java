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
     *
     * Returns null if file is valid.
     * returns FileErrorObject which is a list of record error objects
     */
    public FileErrorObject validateFile() {
        FileErrorObject fileErrorObject = new FileErrorObject();
        RecordErrorObject recordErrorObject = new RecordErrorObject();
        int recordLineCounter = 0;

        try {
            String fileLine;
            while (((fileLine = fileBufferedReader.readLine()) != null) && (fileLine.length() != 0)) {
                log.info("inside validateFile, fileLine is: " + fileLine.toString());
                recordLineCounter++;
                log.info("recordLineCounter: " +recordLineCounter);
                //only validate S9 records
                if (fileLine.substring(0, 2).equalsIgnoreCase("S9")) {


                    //loop through each record, setting isValid and error object on each record

                    //if a not-null recordErrorObject is returned by the validateRecord, add it to the list that becomes the FileErrorObject
                    //there is one recordErrorObject for each file line having an erro
                    recordErrorObject=recordValidatorEngine.validateRecord(new S9Record(fileLine));

                    //if record was valid, recordErrorObject will be null, don't add it to fileErrorObject
                    if(recordErrorObject!=null){
                        fileErrorObject.getListRecordErrors().add(recordLineCounter,recordErrorObject);
                    }

                    //fileIsValid = fileIsValid && recordValidatorEngine.validateRecord(new S9Record(fileLine));
                }
            }
        } catch (IOException ioe) {
            log.error("Error while reading uploaded file data!", ioe);
        }
        return fileErrorObject;
    }

//    // TODO: This shouldn't be called unless we know that the line isn't null; move that out of this class!
//    private DefinedValidatableRecord S9R(String fileLine) {
//
//        // TODO: Consider better validation of Record type
//
//        //String dataSystemRecordClass = DATA_SYSTEM_ENTITY_CLASS_BASE + "." + dataSystem + "." + fileLine.substring(0,2) + "Record";
//        // TODO: Attempt to instantiate a class of that type, and handle failures to do so - try classloading it first?

//        // TODO: return a valid DefinedValidatableRecord - using DummyRecord to force return
//        return new DummyRecord("00");
//    }


    // TODO: If doing full error reporting, wrapper the record into another reporting object as a DefinedValidatableRecord
    // Consider wrapping the record in something that knows what line it came from, and some other stuff)

}
