package StepDefinition;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Harish19 on 30/07/2018.
 */
public class BaseTestAPI {
    public static String endpoint;
    public static URL obj;
    public static HttpURLConnection Getcon;
    JSONParser parser = new JSONParser();
    JSONObject json;

    CloseableHttpClient httpClient ;
    HttpPost request;
    HttpResponse response;

    public BaseTestAPI() throws Exception {
        endpoint= (System.getProperty("base.endpoint"));

    }
}
