package edu.wtcsystem.data.validator.type;

//TODO: Remove note regarding NumericTypeValidator being a sample before final submission

/**
 * NumericTypeValidator is the first concrete implementation of a TypeValidator
 * intended to be used by the team as a blueprint for further validators.
 * <p>
 * Implements a String validator for a specific, concrete regular expression
 * Each class that extends TypeValidatorBase should have its own descriptive final static regex string
 * which it calls the superclass constructor with.
 * <p>
 * NumericTypeValidator verifies that a type is only numbers.
 *
 * @author cwinebrenner
 */
public final class NumericTypeValidator extends TypeValidatorBase {

    private final static String NUMERIC_TYPE_REGEX = "^\\d+$";

    /**
     * Initializes the superclass (TypeValidatorBase) with the appropriate
     * regular expression to represent the type that this class validates.
     */
    public NumericTypeValidator() {
        super(NUMERIC_TYPE_REGEX);
    }

}
