package com.example.erp.Controller;

import com.example.erp.Bean.Organisation;
import com.example.erp.Bean.Organisation_HR;
import com.example.erp.DAO.DAOImplementation.Organisation_HRDAOImpl;
import com.example.erp.DAO.OrganisationDAO;
import com.example.erp.DAO.DAOImplementation.OrganisationDAOImpl;
import com.example.erp.DAO.Organisation_HRDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/organisation_HR")
public class Organisation_HRController {

    Organisation_HRDAO orgDAO = new Organisation_HRDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_organisation_hr(Organisation_HR org_hr){
        System.out.printf(String.valueOf(org_hr));
        if(orgDAO.addOrganisation_hr(org_hr)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding department").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_organisation(){
        List<Organisation_HR> orgs = orgDAO.getOrganisation_HRList();
        System.out.printf("Hello world");
        return Response.status(200).entity(orgs).build();
    }

    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Organisation_HR orghr_id) {
        if (orgDAO.deletehr(orghr_id.getOrganisationHRID())) {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while deleting from Organisation HR Table").build();
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update_organisation(Organisation_HR orghr){
        if(orgDAO.updateDetails(1,orghr)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while updating Organisation Address").build();
    }

//    @POST
//    @Path("/update/{hr_id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response update_organisation(@PathParam("hr_id") int pId, Organisation_HR orghr){
//        //System.out.println(pId + " " + oName);
//        if(orgDAO.updateDetails(pId, orghr)){
//            return Response.status(200).entity("Success").build();
//        }
//
//        return Response.status(404).entity("Failure while updating Organisation name").build();
//    }


}
