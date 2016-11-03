package edu.wtcsystem.data.validator.type;

/**
 * @author cwinebrenner
 * @since 2016-11-01
 */
public enum ValidateType {

    NUMERIC(NumericTypeValidator.class) {
        @Override
        public String toString() {
            return "Numeric";
        }
    },
    ALPHA(AlphaTypeValidator.class) {
        @Override
        public String toString() {
            return "Alphabetic";
        }
    },
    ALPHA_NUMERIC(AlphaNumericTypeValidator.class) {
        @Override
        public String toString() {
            return "Alphanumeric";
        }
    };

    private Class<? extends TypeValidatorBase> validateTypeImplementor;

    private ValidateType(Class<? extends TypeValidatorBase> validateTypeImplementor) {
        this.validateTypeImplementor = validateTypeImplementor;
    }

    public Class<? extends TypeValidatorBase> getImplementorClass() {
        return validateTypeImplementor;
    }

}
