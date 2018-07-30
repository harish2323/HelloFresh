package StepDefinition;

/**
 * Created by Harish19 on 30/07/2018.
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.sun.corba.se.spi.orb.ParserData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import static junit.framework.TestCase.assertTrue;


public class HelloFreshAPISteps extends BaseTestAPI {

    public HelloFreshAPISteps() throws Exception
    {
        super();
    }


    @Given("^I send the country request$")
    public void I_send_the_country_request() throws Throwable
    {
        obj = new URL(endpoint+"get/all");
        Getcon = (HttpURLConnection) obj.openConnection();
        Getcon.setRequestMethod("GET");
        int responseCode = Getcon.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(Getcon.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = (JSONObject) parser.parse(response.toString());

            in.close();


        } else {           System.out.println("GET request failed");
        }
    }

    @Given("^I send get country request (.*?)$")
    public void I_send_country_request(String country) throws Throwable
    {
        obj = new URL(endpoint+"get/iso2code/"+country);
        Getcon = (HttpURLConnection) obj.openConnection();
        Getcon.setRequestMethod("GET");
        int responseCode = Getcon.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(Getcon.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = (JSONObject) parser.parse(response.toString());

            in.close();


        } else {           System.out.println("GET request failed");
        }
    }


    @Given("^I send add country (.*?)$")
    public void I_send_add_country_post(String postrequest) throws Throwable {


         httpClient = HttpClientBuilder.create().build();
         System.out.println("URLLLLLLLLLLLLLLLLLLLLLLLLL :"+endpoint+"/post/add");
         request = new HttpPost(endpoint + "/post/add");
        StringEntity params = new StringEntity(postrequest);
        request.addHeader("content-type", "application/json");
        request.setEntity(params);
        httpClient.execute(request);
        response = httpClient.execute(request);

        System.out.println("Response :" +response.toString());
       // int responseCode = Getcon.getResponseCode();
    }

    @And("^I verify US in the response$")
    public void I_verify_US_in_response() throws Throwable
    {
        assertTrue(json.toJSONString().contains("\"alpha2_code\":\"US\""));
    }

    @And("^I verify (.*?) exists$")
    public void I_verify_response(String response) throws Throwable
    {
        assertTrue(json.toJSONString().contains(response));
    }


    @And("^I verify DE in the response$")
    public void I_verify_DE_in_response() throws Throwable
    {
        assertTrue(json.toJSONString().contains("\"alpha2_code\":\"DE\""));
    }
    @And("^I verify GB in the response$")
    public void I_verify_GB_in_response() throws Throwable
    {
        assertTrue(json.toJSONString().contains("\"alpha2_code\":\"GB\""));
    }

    @Then("^I verify response code is success")
    public void I_verify_response_code() throws Throwable
    {
        int responseCode = Getcon.getResponseCode();
        assertTrue(responseCode == HttpURLConnection.HTTP_OK);
    }

    @Then("^I verify bad response$")
    public void I_verify_bad_response() throws Throwable
    {
        System.out.println("ASSERTION : "+response);
        assertTrue(response.toString().contains("400 Bad Request"));
    }

}
