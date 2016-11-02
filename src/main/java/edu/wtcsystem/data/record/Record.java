package edu.wtcsystem.data.record;

/**
 * @author cwinebrenner
 * @since 2016-10-31
 */
abstract class Record {

    final String RECORD_LINE_TEXT;

    Record(String recordLineText) {
        this.RECORD_LINE_TEXT = recordLineText;
    }

}
