package edu.wtcsystem.data.validator.engine;

import edu.wtcsystem.data.entity.client.FileErrorObject;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by karen.rahmeier on 11/8/2016.
 */
public class FileValidatorEngineTest {
    private final static Logger log = Logger.getLogger(FileValidatorEngineTest.class.getSimpleName());

    final private static String VALID_S9_RECORD = "S9102017123456789504999      12";
    final private static String NOT_VALID_S9_RECORD = "S9AA20171234B67CD504999      W2";
    final private static String CLIENT_DATA_SYSTEM = "client";
    //TODO: tests are brittle and depend upon test file existing in a specific location on the machine running the tests
    private final static String TEST_INPUT_FILE_PATH_INVALID_RECORD = "C:/GitProjects/wtcs-data-systems-validators/document/SampleS9RecordsFail.txt";
    private final static String TEST_INPUT_FILE_PATH_VALID_RECORD = "C:/GitProjects/wtcs-data-systems-validators/document/SampleS9Records.txt";



    //InputStream wtcsFileStream = ip.getBody(InputStream.class, null);
    //BufferedReader wtcsFileReader = new BufferedReader(new InputStreamReader(wtcsFileStream));

    private FileValidatorEngine fileValidatorEngine;
    private FileErrorObject fileErrorObject;

    @Before
    public void setup() throws FileNotFoundException {
    }


    @Test
    public void testValidateFileInvalidFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(TEST_INPUT_FILE_PATH_INVALID_RECORD));
        fileValidatorEngine = new FileValidatorEngine(CLIENT_DATA_SYSTEM, bufferedReader);
        fileErrorObject = new FileErrorObject();
        assertNotNull(fileValidatorEngine);
        fileErrorObject = fileValidatorEngine.validateFile();
        log.info("inside testValidateFileInvalidFile fileErrorObject.getDisplayOfAllErrors(): " +fileErrorObject.getDisplayOfAllErrors());
        log.info("size of record error list is " + fileErrorObject.getListRecordErrors().size());
        assertTrue("List of record errors has size zero for an invalid file! ", fileErrorObject.getListRecordErrors().size()>0);
    }


    @Test
    public void testValidateFileValidFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(TEST_INPUT_FILE_PATH_VALID_RECORD));
        assertNull(new FileValidatorEngine(CLIENT_DATA_SYSTEM, bufferedReader).validateFile());
    }

}