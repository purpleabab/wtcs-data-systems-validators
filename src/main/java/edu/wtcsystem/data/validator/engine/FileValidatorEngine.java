package edu.wtcsystem.data.validator.engine;

import edu.wtcsystem.data.entity.client.*;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

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

    public FileValidatorEngine(String dataSystem, BufferedReader fileBufferedReader) {
        this.dataSystem = dataSystem;
        this.fileBufferedReader = fileBufferedReader;
        recordValidatorEngine = new RecordValidatorEngine();
    }

    public boolean validateFile() {
        boolean fileIsValid = false;
        try {
            String fileLine;
            fileIsValid = true;
            while (((fileLine = fileBufferedReader.readLine()) != null) && (fileLine.length() != 0)) {
                log.info("inside validateFile, fileLine is: " + fileLine.toString());
                //only validate S9 records
                if (fileLine.substring(0, 2).equalsIgnoreCase("S9")) {
                    fileIsValid = fileIsValid && recordValidatorEngine.validateRecord(new S9Record(fileLine));
                }
            }
        } catch (IOException ioe) {
            log.error("Error while reading uploaded file data!", ioe);
        }
        return fileIsValid;
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
