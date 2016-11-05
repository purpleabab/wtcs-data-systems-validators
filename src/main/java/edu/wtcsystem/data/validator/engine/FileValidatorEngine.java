package edu.wtcsystem.data.validator.engine;

import edu.wtcsystem.data.entity.client.S9Record;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

import edu.wtcsystem.data.record.DefinedValidatableRecord;

/**
 * Takes a provided file, cuts it up into records (lines), generates record objects which implement
 * DefinedValidatableRecord, and feeds an instance of RecordValidatorEngine
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class FileValidatorEngine {

    private final Logger log = Logger.getLogger(FileValidatorEngine.class.getSimpleName());

    private BufferedReader fileBufferedReader;
    private RecordValidatorEngine recordValidatorEngine;

    // TODO: Add a static map or something for looking up record types for buildRecordFromLine

    public FileValidatorEngine(BufferedReader fileBufferedReader) {
        this.fileBufferedReader = fileBufferedReader;
        recordValidatorEngine = new RecordValidatorEngine();
    }

    private DefinedValidatableRecord buildRecordFromLine() {
        try {
            String fileRecordLine = fileBufferedReader.readLine();
        }
        catch (IOException ioe) {
            log.error("Error while reading uploaded file data!", ioe);
        }
        // TODO: return A VALID DefinedValidatableRecord; THIS WILL FAIL AT RUNTIME!!!
        return new S9Record("");
    }

    // method to read the first two characters of a line, compare them to a to-be-defined enum,
    // and instantiate the correct [A-Z][0-9] record (which needs to implment DefinedValidatableRecord).

    // TODO: If doing full error reporting, wrapper the record into another reporting object as a DefinedValidatableRecord
    // Consider wrapping the record in something that knows what line it came from, and some other stuff)

}
