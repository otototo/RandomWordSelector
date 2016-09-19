package com.pjinc;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjinc.resources.V1WordList;
import com.pjinc.resources.WordSelectorResource;

public class WordSelectorResourceTest {

    private static final int PORT = 8083;
    private static final String HOST = "http://0.0.0.0";
    private static final String BASE_URL = HOST + ":" + PORT;
    private HttpServer server;

    @Before
    public void setUpServer() throws IOException {
        ResourceConfig resourceConfig = new ResourceConfig()
                .packages("com.pjinc.resources");
        URI uri = URI.create(BASE_URL);
        server = GrizzlyHttpServerFactory.createHttpServer(uri, resourceConfig, true);
    }

    @After
    public void shutdownServer() {
        server.shutdown();
    }

    @Test
    public void whenGET_returns200AndPayloadWith25Elements() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL);
        Response request = target.path(WordSelectorResource.VERSION_V1)
        		.path(WordSelectorResource.PATH_WORDS)
        		.request(MediaType.APPLICATION_JSON_TYPE)
        		.get();

        Assert.assertEquals(200, request.getStatus());
        String json = request.readEntity(String.class);
        Assert.assertNotNull(json);
        
        ObjectMapper mapper = new ObjectMapper();
        V1WordList wordList = mapper.readValue(json, V1WordList.class);
        Assert.assertEquals(25, wordList.names.size());
        System.out.println(wordList.toString());
    }

}
