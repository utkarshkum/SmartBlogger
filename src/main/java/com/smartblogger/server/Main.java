package com.smartblogger.server;
import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

//import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;  

public class Main {
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).build();
    }
 
    public static final URI BASE_URI = getBaseURI();
 
    public static HttpServer startServer() throws IOException {
        System.out.println("Starting grizzly...");
        ResourceConfig rc = new PackagesResourceConfig(
                "com.bharat.examples.rest");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }
 
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = startServer();
        System.out
                .println(String
                        .format(
                                "Jersey app started with WADL available at "
                                        + "%sapplication.wadl\nTry out %shello/bharat\nHit enter to stop it...",
                                BASE_URI, BASE_URI));
        System.in.read();
        httpServer.stop();
    }
}
