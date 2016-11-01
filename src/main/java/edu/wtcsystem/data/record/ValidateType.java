package edu.wtcsystem.data.record;

/**
 * @author cwinebrenner
 * @since 2016-11-01
 */
public enum ValidateType {

    //TODO: Add validator to each enum value somehow, OR use enum values to somehow map which TypeValidator to use
    NUMERIC {
        @Override
        public String toString() {
            return "";
        }
    },
    ALPHA {
        @Override
        public String toString() {
            return "";
        }
    },
    ALPHA_NUMERIC {
        @Override
        public String toString() {
            return "";
        }
    }

}
