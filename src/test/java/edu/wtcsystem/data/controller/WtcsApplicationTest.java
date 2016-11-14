package edu.wtcsystem.data.controller;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;


import static org.junit.Assert.*;

/**
 * Created by nataliya.knudson on 11/14/2016.
 */
public class WtcsApplicationTest {
    @Test
    public void getClasses() throws Exception {

        assertNotNull (new WtcsApplication().getClasses());

    }

}