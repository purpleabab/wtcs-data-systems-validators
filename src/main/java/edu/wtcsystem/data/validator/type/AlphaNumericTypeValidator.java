package edu.wtcsystem.data.validator.type;

//TODO: Add a description of what this type is
//TODO: Add yourself as another @author field if you worked on this class

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
public final class AlphaNumericTypeValidator extends TypeValidatorBase implements TypeValidator {

    private final static String ALPHA_NUMERIC_TYPE_REGEX = "^[0-9a-zA-Z]+$";

    public AlphaNumericTypeValidator() {
        super(ALPHA_NUMERIC_TYPE_REGEX);
    }

}
