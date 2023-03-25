package com.example.erp.Controller;

import com.example.erp.Bean.Organisation;
import com.example.erp.DAO.DAOImplementation.OrganisationDAOImpl;
import com.example.erp.DAO.OrganisationDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.example.erp.Util.HibernateSessionUtil;
import java.util.List;

@Path("/organisation")
public class OrganisationController {

    OrganisationDAO orgDAO = new OrganisationDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_organisation(Organisation org){
//        System.out.printf(String.valueOf(org));
        if(orgDAO.addOrganisation(org)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while Adding Organisation Details").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_organisation(){
        List<Organisation> orgs = orgDAO.getOrganisationList();
        System.out.printf("Hello world");
        return Response.status(200).entity(orgs).build();
    }

    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Organisation organisation) {
        if (orgDAO.deleteOrganisation(organisation.getOrganisationID())) {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while deleting from Organisation Table").build();
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update_organisation(Organisation org){
        if(orgDAO.updateDetailsorg(org)){
            return Response.status(200).entity(org).build();
        }

        return Response.status(404).entity("Failure while updating Organisation Address").build();
    }

}