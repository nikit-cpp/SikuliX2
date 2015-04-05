package com.sikulix.remoteserver.service;

import com.sikulix.remoteserver.utils.CommandLineUtility;
import com.sikulix.restcore.entities.Command;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Author: Sergey Kuts
 */
@Path("/cmd")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommandLineService {

    @POST
    @Path("/execute")
    public Response execute(final Command command) {
        return Response.status(CommandLineUtility.executeCommandLine(command) != -1 ?
                Response.Status.OK : Response.Status.INTERNAL_SERVER_ERROR)
                .build();
    }
}
