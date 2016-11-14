package edu.wtcsystem.data.record;

import edu.wtcsystem.data.validator.type.ValidateType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nataliya.knudson on 11/14/2016.
 */
public class ValidatableRecordFieldDefinitionTest {
    ValidatableRecordFieldDefinition vrfd;
    @Before
    public void setup() {
        vrfd = new ValidatableRecordFieldDefinition("aa", 9,11, ValidateType.NUMERIC);

    }

    @Test
    public void getFieldValidateType() throws Exception {
     assertEquals("Field: ", vrfd.getFieldName(), "aa");

    }

   // @Test
   // public void toString() throws Exception {

   // }

}