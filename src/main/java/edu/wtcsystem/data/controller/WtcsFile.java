package edu.wtcsystem.data.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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

    private static final Logger log = Logger.getLogger(WtcsFile.class.getSimpleName());
    private static final String FORM_FILE_INPUT_NAME = "wtcsFile";

    @POST
    @Path("/validate")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response validateFile(MultipartFormDataInput mfdi) {

        log.info("INFO_LOG_STATEMENT: entering " + this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
        Map<String, List<InputPart>> fdm = mfdi.getFormDataMap();
        List<InputPart> fdmInputParts = fdm.get(FORM_FILE_INPUT_NAME);

        for (InputPart ip : fdmInputParts) {

            MultivaluedMap<String, String> ipHeader = ip.getHeaders();
            for (String k : ipHeader.keySet()) {
                log.info("INFO_LOG_STATEMENT: InputPart headers: " + k + " --> " + ipHeader.get(k));
            }

        }

        return Response.status(Status.OK).entity("validate claims to have gotten the file").build();
    }



}
