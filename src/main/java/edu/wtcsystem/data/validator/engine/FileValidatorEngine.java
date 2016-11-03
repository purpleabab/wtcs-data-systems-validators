package edu.wtcsystem.data.validator.engine;

/**
 * Takes a provided file, cuts it up into records (lines), generates record objects which implement
 * DefinedValidatableRecord, and feeds an instance of RecordValidatorEngine
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class FileValidatorEngine {

    private RecordValidatorEngine rve;

    public FileValidatorEngine() {
        rve = new RecordValidatorEngine();
    }

    // method to read the first two characters of a line, compare them to a to-be-defined enum,
    // and instantiate the correct [A-Z][0-9] record (which needs to implment DefinedValidatableRecord).

    // TODO: If doing full error reporting, wrapper the record into another reporting object as a DefinedValidatableRecord
    // Consider wrapping the record in something that knows what line it came from, and some other stuff)

}
