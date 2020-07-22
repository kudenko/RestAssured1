package jsonclass.examples;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchJsonPathExample {

    static final String API_KEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";
    }

    @Test
    public void test1(){
     int numItems =    RestAssured
                .given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", API_KEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("numItems");
        System.out.println(numItems);

    }


    @Test
    public void test2(){
        String query =    RestAssured
                .given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", API_KEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("query ");
        System.out.println(query);

    }


}