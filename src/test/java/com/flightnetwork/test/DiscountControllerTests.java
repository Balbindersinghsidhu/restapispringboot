/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flightnetwork.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Balbinder Singh
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DiscountControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
   
   
    private static final String RESOURCE_LOCATION_PATTERN = "http://localhost:8080/discount?userType=Standard&amount=1300";

     TestRestTemplate restTemplate = new TestRestTemplate();
     
     HttpHeaders headers = new HttpHeaders();
    @Before
    public void initTests() {       
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }



   
    @Test
    public void testRetrieveDiscountData() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<>(null,headers);
                
           //     ResponseEntity<String> response= restTemplate.exchange(RESOURCE_LOCATION_PATTERN, HttpMethod.GET, entity,String.class);
                
		ResponseEntity<String> response = restTemplate.exchange(
				RESOURCE_LOCATION_PATTERN,
				HttpMethod.GET, entity, String.class);              
		JSONAssert.assertEquals("1270.0", response.getBody(), false);
	}

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
}

