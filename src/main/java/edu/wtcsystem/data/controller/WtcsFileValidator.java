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
public class WtcsFileValidator {

    private static final String FORM_FILE_INPUT_NAME = "wtcsFile";

    private final Logger log = Logger.getLogger(WtcsFileValidator.class.getSimpleName());

    private FileValidatorEngine fve;

    @POST
    @Path("/validate/{system}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    //@Produces(MediaType.APPLICATION_JSON)
    public Response validateFile(@PathParam("system") String dataSystem, MultipartFormDataInput mfdi) {
        boolean isValid = false;
        // TODO: Validate the endpoint "system" param from our systems before going ahead and passing it along as the "dataSystem"

        log.debug("Entering " + this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());

        // Get FormDataMap, then the InputParts from the form field defined by FORM_FILE_INPUT_NAME
        Map<String, List<InputPart>> fdm = mfdi.getFormDataMap();
        List<InputPart> fdmInputParts = fdm.get(FORM_FILE_INPUT_NAME);

        log.info("FORM_FILE_INPUT_NAME; " + fdmInputParts);

        for (InputPart ip : fdmInputParts) {

            MultivaluedMap<String, String> ipHeader = ip.getHeaders();

            // Debugging output of form/multipart headers
            if (log.isDebugEnabled()) {
                for (String k : ipHeader.keySet()) {
                    log.debug("InputPart headers: " + k + " = " + ipHeader.get(k));
                }
            }

            try {
                // TODO: Understand what this getBody() call does
                InputStream wtcsFileStream = ip.getBody(InputStream.class, null);
                BufferedReader wtcsFileReader = new BufferedReader(new InputStreamReader(wtcsFileStream));

                log.info("inside the try, about to call engine");

                FileValidatorEngine fve = new FileValidatorEngine(dataSystem, wtcsFileReader);
                isValid = fve.validateFile();
                //fve.isValid() returns whether or not the file passed validation
            } catch (IOException ioe) {
                log.error("Error while reading uploaded file data!", ioe);
            } catch (Exception e) {
                //TODO kr better error handling
                log.error("some kind of exception was thrown!" + e.getMessage());

            }
        }
        String responseMessage;
        if (isValid) {
            responseMessage = "file is valid";
        } else {
            responseMessage = "file is not valid";
        }
        return Response.status(Status.OK).entity(responseMessage).build();
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
