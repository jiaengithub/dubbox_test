package com.bf;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class EntityNotFoundMapper
implements ExceptionMapper<EntityNotFoundException> {
    
      public Response toResponse(EntityNotFoundException e) {
           return Response.status(Response.Status.BAD_GATEWAY).entity(new User()).type(MediaType.APPLICATION_JSON).build();
      }

}