package edu.wtcsystem.data.validator.type;

/**
 * TypeValidator is the interface which all regular expression-based type validators
 * must implement to allow the validator to indicate whether or not a String is a
 * valid representation of the type being checked.
 *
 * @author cwinebrenner
 */
interface TypeValidator {

    /**
     * Checks to see if the provided String is a valid instance of the type being checked.
     *
     * @param typedStringToValidate the String to check
     * @return <code>true</code> if the String represents a valid representation of the type
     * being checked; <code>false</code> otherwise.
     */
    boolean isValid(String typedStringToValidate);

}
