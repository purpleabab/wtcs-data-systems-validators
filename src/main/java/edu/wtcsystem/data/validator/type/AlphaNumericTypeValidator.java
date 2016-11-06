package edu.wtcsystem.data.validator.type;

/**
 * Regular-expression-based String validator.
 * <p>
 * AlphaNumericTypeValidator verifies that a type is only letters and/or numbers.
 *
 * @author cwinebrenner
 * @since 2016-10-31
 */

public final class AlphaNumericTypeValidator extends TypeValidatorBase implements TypeValidator {

    private final static String ALPHA_NUMERIC_TYPE_REGEX = "^[0-9a-zA-Z]+$";

    /**
     * Initializes the superclass (TypeValidatorBase) with the appropriate
     * regular expression to represent the type that this class validates.
     */
    public AlphaNumericTypeValidator() {
        super(ALPHA_NUMERIC_TYPE_REGEX);
    }

    @Override
    public String toString() {
        return "ALPHA_NUMERIC: A through Z, upper or lower case, and digits 0 through 9.";
    }

}
