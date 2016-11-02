package edu.wtcsystem.data.validator.engine;

/**
 * Takes a provided file, cuts it up into records (lines), and feeds the RecordValidatorEngine
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class FileValidatorEngine {

    public FileValidatorEngine() {

    }

    // method to read the first two characters of a line, compare them to a to-be-defined enum,
    // and instantiate the correct [A-Z][0-9] record (which needs to implment DefinedValidatableRecord).
    // Consider wrapping the record in something that knows what line it came from, and some other stuff)

}
