package com.ticketprovider;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        TicketProviderServiceApplication.class,
        SingleServiceTestConfiguration.class},
     properties = {"application.name=ticketprovider-service"},
      webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractSingleServiceTest {

	    @Autowired
	    private String baseUrl;
	    
	    @Before
	    public void setUp() {
	    	RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri(baseUrl);
	    	RestAssured.requestSpecification = requestSpecBuilder.build();
	    }
}
