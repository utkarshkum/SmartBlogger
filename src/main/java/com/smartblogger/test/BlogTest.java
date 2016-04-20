package com.smartblogger.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import com.smartblogger.server.Main;

public class BlogTest {
	
    private HttpServer server;
    private WebTarget target;

	@Before
	public void setUp() throws Exception {
        server = Main.startServer();
        
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
