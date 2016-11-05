package edu.wtcsystem.data.validator.engine;

import java.util.Map;
import java.util.HashMap;

import edu.wtcsystem.data.validator.type.*;
import edu.wtcsystem.data.record.*;

import org.apache.log4j.Logger;

/**
 * Intended to be instantiated once per thread doing validation work.
 * @author cwinebrenner
 * @since 2016-11-02
 */
public class RecordValidatorEngine {

    private final Logger log = Logger.getLogger(this.getClass());

    private Map<ValidateType, TypeValidator> typeValidatorPool;

    public RecordValidatorEngine() {

        log.debug("Entering RecordValidatorEngine constructor");
        log.debug("Instantiating TypeValidator pool");
        typeValidatorPool = new HashMap<>();

        try {
            for (ValidateType vt : ValidateType.values()) {
                log.debug("Adding instance of " + vt.getClass().getSimpleName() + " to TypeValidator pool");
                typeValidatorPool.put(vt, vt.getImplementorClass().newInstance());
            }
        }
        catch (Exception e) {
            log.error("ERROR attempting to set up RecordValidatorEngine TypeValidator pool: ", e);
        }

        log.debug("Exiting RecordValidatorEngine constructor");
    }

    public boolean validateRecord(DefinedValidatableRecord record) {

        log.debug("Entering RecordValidatorEngine.validateRecord()");
        log.debug("Reading record definition and values");

        ValidatableRecordDefinition vrd = record.getRecordDefinition();
        Map<String, String> recordValues = record.getRecordValues();

        log.debug("Beginning validation of " + vrd.getRecordTypeName());

        boolean recordIsValid = true;
        log.debug(vrd.getRecordTypeName() + " is valid so far: " + recordIsValid);

        // Iterate through the fields from the record definition and check them
        for (ValidatableRecordFieldDefinition vrfd : vrd.getRecordFields()) {

            log.debug("Starting validation of field " + vrfd.getFieldName());
            log.debug("Getting " + vrfd.getFieldValidateType().getClass().getSimpleName() + " from TypeValidator pool");
            TypeValidator recordFieldValidator = typeValidatorPool.get(vrfd.getFieldValidateType());
            recordIsValid = recordIsValid && recordFieldValidator.isValid(recordValues.get(vrfd.getFieldName()));
            log.debug("Field " + vrfd.getFieldName() + (recordIsValid ? " passed" : " failed") + " validation");
            log.debug("Ending validation of field " + vrfd.getFieldName());
            log.debug(vrd.getRecordTypeName() + " is valid so far: " + recordIsValid);

            // Fail the record and quit checking if any individual field fails to validate
            // TODO: If implementing error logging, instead of failing fast here add an object describing the error to some Collection and do not break
            if (!recordIsValid) {
                log.debug(vrd.getRecordTypeName() + " failed validation on " + recordValues.get(vrfd.getFieldName()));
                log.debug(vrd.getRecordTypeName() + " validation failing fast; any remaining fields will not be validated!");
                break;
            }
        }

        log.debug("Ending validation of " + vrd.getRecordTypeName());

        log.debug("Exiting RecordValidatorEngine.validateRecord(); returning " + recordIsValid);
        return recordIsValid;
    }

    // TODO: If implementing error logging, write a method which takes an error reporting object with a wrappered DefinedValidatableRecord

}
