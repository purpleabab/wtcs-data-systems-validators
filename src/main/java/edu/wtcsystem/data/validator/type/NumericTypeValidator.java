package edu.wtcsystem.data.validator.type;

//TODO: Remove notes regarding NumericTypeValidator being a sample before final submission in [[[[[ ]]]]]

/**
 * [[[[[
 * NumericTypeValidator is the first concrete implementation of a TypeValidator
 * intended to be used by the team as a blueprint for further validators.
 * <p>
 * Implements a String validator for a specific, concrete regular expression
 * Each class that extends TypeValidatorBase should have its own descriptive final static regex string
 * which it calls the superclass constructor with.
 * ]]]]]
 * <p>
 * Regular-expression-based String validator.
 * <p>
 * NumericTypeValidator verifies that a type is only numbers.
 *
 * @author cwinebrenner
 * @since 2016-10-31
 */
public final class NumericTypeValidator extends TypeValidatorBase implements TypeValidator {

    private final static String NUMERIC_TYPE_REGEX = "^\\d+$";

    /**
     * Initializes the superclass (TypeValidatorBase) with the appropriate
     * regular expression to represent the type that this class validates.
     */
    public NumericTypeValidator() {
        super(NUMERIC_TYPE_REGEX);
    }

    @Override
    public String toString() {
        return "NUMERIC: Digits 0 through 9.";
    }

}
