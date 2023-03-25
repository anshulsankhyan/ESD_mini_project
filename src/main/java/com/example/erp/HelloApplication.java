package com.example.erp;

import com.example.erp.Util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;



@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication(){
        register(CORSFilter.class);

        packages("com.example.erp");
    }
}




