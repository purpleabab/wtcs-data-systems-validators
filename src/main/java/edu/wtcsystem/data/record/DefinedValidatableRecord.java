package edu.wtcsystem.data.record;

import java.util.Map;

/**
 * @author cwinebrenner
 * @since 2016-11-02
 */
public interface DefinedValidatableRecord {

    public ValidatableRecordDefinition getRecordDefinition();
    public Map<String, String> getRecordValues();

}
