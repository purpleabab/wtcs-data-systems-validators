package edu.wtcsystem.data.validator.type;

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
public final class AlphaTypeValidator extends TypeValidatorBase implements TypeValidator {

    private final static String ALPHA_TYPE_REGEX = "^[A-Za-z]+$";

    public AlphaTypeValidator() {
        super(ALPHA_TYPE_REGEX);
    }

    @Override
    public String toString() {
        return "ALPHA: A through Z, upper or lower case.";
    }

}
