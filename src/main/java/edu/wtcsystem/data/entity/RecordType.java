package edu.wtcsystem.data.entity;

/**
 * Created by cwinebrenner on 11/5/16.
 */
public enum RecordType {

    CLIENT_S9_RECORD("client.S9Record");

    private final String BASE_ENTITY_PACKAGE = "edu.wtcsystem.data.entity";
    private String systemAndRecordClass;

    private RecordType(String systemAndRecordClass) {
        this.systemAndRecordClass = systemAndRecordClass;
    }

}
