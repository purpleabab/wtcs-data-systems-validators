package edu.wtcsystem.data.validator.type;

//TODO: Add a description of what this type is
//TODO: Add yourself as another @author field if you worked on this class

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
public final class AlphaTypeValidator extends TypeValidatorBase implements TypeValidator {

    //TODO: Write a regular expression for this type and put in the constant String
    private final static String ALPHA_TYPE_REGEX = "^[A-Za-z]+$";

    public AlphaTypeValidator() {
        super(ALPHA_TYPE_REGEX);
    }

    @Override
    public String toString() {
        return "ALPHA: A through Z, upper or lower case.";
    }

}
