package edu.wtcsystem.data.validator.type;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * TypeValidatorBase is the abstract base class for all regular expression-based type validators;
 * it is declared abstract simply it *generically* implements regex checking of a String against
 * a pattern, while also compiling the regex so that it is not repeatedly re-created every time
 * a String needs to be validated with the associated regex.
 *
 * Because empty String values are also permitted, checks for pure whitespace in addition to the regex.
 *
 * Likewise, the Matcher is only created once, and then re-used each time a new String is provided
 * for validation by calling reset() and passing the new String to be validated.
 * Specific types that need to be validated should extend this class and call the superclass
 * constructor with an appropriate regular expression.
 *
 * @author cwinebrenner
 * @since 2016-10-31
 */
abstract class TypeValidatorBase implements TypeValidator {

    private final String TYPE_REGEX;
    private final Pattern TYPE_PATTERN;
    private final Matcher TYPE_MATCHER;

    private final String WHITESPACE_STRING = "^\\s+$";
    private final Pattern WHITESPACE_PATTERN;
    private final Matcher WHITESPACE_MATCHER;

    /**
     * Initializes/compiles the regular expression Pattern from the provided String,
     * then gets a Matcher for that regular expression from the Pattern.
     * The acquired Matcher is used in the implementation of the TypeValidator interface
     * to check whether or not the provided String is a valid representation of the type.
     *
     * Secondly, initializes a whitespace pattern and matcher for checking empty Strings.
     * @param typeRegex Regular expression representative of the type to be validated.
     */
    TypeValidatorBase(String typeRegex) {
        TYPE_REGEX = typeRegex;
        TYPE_PATTERN = Pattern.compile(TYPE_REGEX);
        TYPE_MATCHER = TYPE_PATTERN.matcher("");

        WHITESPACE_PATTERN = Pattern.compile(WHITESPACE_STRING);
        WHITESPACE_MATCHER = WHITESPACE_PATTERN.matcher("");
    }

    /**
     * Uses a java.util.regex.Matcher, declared as a final instance variable
     * of the class so that it is not re-created for every call, to check whether
     * the supplied String matches the regex.
     *
     * @param typedStringToValidate A String that needs validated against the TypeValidator's regex
     * @return <code>true</code> if the Matcher determines that the String matches the TypeValidator's
     * regex and is therefore represents a valid instance of the type of data we want, or if the
     * provided String is white space; <code>false</code> otherwise.
     */
    public boolean isValid(String typedStringToValidate) {
        return (TYPE_MATCHER.reset(typedStringToValidate).matches() || WHITESPACE_MATCHER.reset(typedStringToValidate).matches());
    }

}
