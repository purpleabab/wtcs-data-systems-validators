package edu.wtcsystem.data.controller;

import org.apache.log4j.Logger;

import edu.wtcsystem.data.validator.engine.FileValidatorEngine;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

/**
 * Deals with reading multipart/form-data MIME type data POSTed from a web form
 * http://docs.jboss.org/resteasy/docs/3.0.19.Final/userguide/html/Multipart.html#MultipartFormData
 * http://docs.jboss.org/resteasy/docs/3.0.19.Final/userguide/html/Multipart.html#MultipartInput
 * https://www.mkyong.com/webservices/jax-rs/file-upload-example-in-resteasy/
 *
 * @author cwinebrenner
 * @since 2016-11-04
 */

@Path("/file")
public class WtcsFile {

    private static final String FORM_FILE_INPUT_NAME = "wtcsFile";

    private final Logger log = Logger.getLogger(WtcsFile.class.getSimpleName());

    private FileValidatorEngine fve;

    @POST
    @Path("/validate")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    //@Produces(MediaType.APPLICATION_JSON)
    public Response validateFile(MultipartFormDataInput mfdi) {

        log.debug("Entering " + this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());

        // Get FormDataMap, then the InputParts from the form field defined by FORM_FILE_INPUT_NAME
        Map<String, List<InputPart>> fdm = mfdi.getFormDataMap();
        List<InputPart> fdmInputParts = fdm.get(FORM_FILE_INPUT_NAME);

        for (InputPart ip : fdmInputParts) {

            MultivaluedMap<String, String> ipHeader = ip.getHeaders();
            if (log.isDebugEnabled()) {
                for (String k : ipHeader.keySet()) {
                    log.debug("INFO_LOG_STATEMENT: InputPart headers: " + k + " = " + ipHeader.get(k));
                }
            }

            try {
                // TODO: Understand what this getBody() call does
                InputStream wtcsFileStream = ip.getBody(InputStream.class, null);
                BufferedReader wtcsFileReader = new BufferedReader(new InputStreamReader(wtcsFileStream));

                FileValidatorEngine fve = new FileValidatorEngine(wtcsFileReader);
                // TODO: implement isValid in FileValidatorEngine
                //fve.isValid();
            }
            catch (IOException ioe) {
                log.error("Error while reading uploaded file data!", ioe);
            }



        }

        return Response.status(Status.OK).entity("validate claims to have gotten the file").build();
    }

    /**
     * Utility method for extracting a filename from uploaded multipart/form-data
     * https://www.mkyong.com/webservices/jax-rs/file-upload-example-in-resteasy/
     *
     * @author mykong
     **/
    private String getFileNameFromHeader(MultivaluedMap<String, String> ipHeader) {

        String[] contentDisposition = ipHeader.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }

}
