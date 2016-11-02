package edu.wtcsystem.data.validator.type;

/**
 * @author cwinebrenner
 * @since 2016-11-01
 */
public enum ValidateType {

    NUMERIC {
        @Override
        public String toString() {
            return "Numeric";
        }
    },
    ALPHA {
        @Override
        public String toString() {
            return "Alphabetic";
        }
    },
    ALPHA_NUMERIC {
        @Override
        public String toString() {
            return "Alphanumeric";
        }
    }

}
