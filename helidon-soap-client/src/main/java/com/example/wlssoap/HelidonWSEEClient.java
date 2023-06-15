package com.example.wlssoap;

import io.helidon.microprofile.server.Server;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.xml.ws.BindingProvider;
import java.util.Collections;

@Path("/helidonclient")
@ApplicationScoped
public class HelidonWSEEClient {

    public static void main(String[] args) {
        Server.builder().port(8080).build().start();
    }

    private JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    @GET
    @Path("/getWLSWebserviceResult/subtract/{y}/from/{x}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject invokeWLSWebservice(@PathParam("x") int x, @PathParam("y") int y) {

//        String wsdlLocation = System.getProperty("remote.wsdl.location");
        String wsdlLocation = "http://localhost:7001/wls-soap-server-1.0-SNAPSHOT/DynamicWSImplService?WSDL";
        DynamicWSImplService testService = new DynamicWSImplService();
        DynamicWSImpl testPort = testService.getDynamicWSImplPort();
        ((BindingProvider) testPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsdlLocation);

        int response = testPort.subtract(x,y);

        return JSON.createObjectBuilder().add("wsresponse", response).build();
    }
}