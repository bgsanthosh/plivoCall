package com.plivo.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.plivo.entity.CallRequest;
import com.plivo.entity.CallResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.plivo.config.Config;


import static com.jayway.restassured.RestAssured.given;

/**
 * Created by santhosh.b on 20/10/15.
 */
public class TestOutboundCall {

    public static final String basePath = "/v1/Account/";
    public static final String callPath = "/Call/";
    private static final Logger logger = LoggerFactory.getLogger(TestOutboundCall.class);


    public RequestSpecification getOutboundCallSpecs(String authId, String from , String to, String answer_url)  {

        String url = Config.getConfig("endPoint");
        String finalBasePath =  basePath + authId + callPath;
        RequestSpecBuilder requestSpecBuilder  = new RequestSpecBuilder();
       // requestSpecBuilder.addParam("from", from);
        //requestSpecBuilder.addParam("to", to);
        //requestSpecBuilder.addParam("answer_url", answer_url);
        requestSpecBuilder.addHeader("Authorization", "Basic TUFPR1VaTkpCSU1ERTBNV1UyTUo6T0RnNE1XUXdNVEEzWXpVMU0yRmpZVEV6WVdWaVpEQXlOV0UxTWpFMg==");
        requestSpecBuilder.setBasePath(finalBasePath);
        requestSpecBuilder.setBaseUri(url);
        requestSpecBuilder.setContentType("application/json");
        return requestSpecBuilder.build();

    }

    public RequestSpecification getAccount(String authId)  {
        String basePath = "v1/Account/" + authId;
        String url = Config.getConfig("endPoint");

        RequestSpecBuilder requestSpecBuilder  = new RequestSpecBuilder();
        requestSpecBuilder.setBasePath(basePath);
        requestSpecBuilder.setBaseUri(url);
        requestSpecBuilder.addHeader("Authorization", "Basic TUFPR1VaTkpCSU1ERTBNV1UyTUo6T0RnNE1XUXdNVEEzWXpVMU0yRmpZVEV6WVdWaVpEQXlOV0UxTWpFMg==");
        requestSpecBuilder.setContentType("application/json");
        return requestSpecBuilder.build();

    }

    @Test
    public void testOutboundCall() throws Exception {

        logger.info("Starting logger");
        String authId = "MAOGUZNJBIMDE0MWU2MJ";
        String from = "919901849792";
        String to = "919886749887";
        String userName = "MAOGUZNJBIMDE0MWU2MJ";
        String password = "ODg4MWQwMTA3YzU1M2FjYTEzYWViZDAyNWE1MjE2";
        String answer_url = "http://b212638a.ngrok.io/app/hello";

        CallRequest callRequest = new CallRequest();
        callRequest.setFrom(from);
        callRequest.setTo(to);
        callRequest.setAnswer_url(answer_url);
        ObjectMapper objectMapper  = new ObjectMapper();
        byte[] body = objectMapper.writeValueAsBytes(callRequest);

        Response response = given().log().all().spec(getOutboundCallSpecs(authId, from, to, answer_url)).body(body).post();
        logger.info(response.getBody().asString());
        CallResponse callResponse = objectMapper.readValue(response.getBody().asByteArray(), CallResponse.class);


    }



}
