package com.student.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ThirdLesson extends TestBase{
    @DisplayName("Getting 1 student from the DB")
    @Test
    void getOneStudent(){

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("programme", "Computer Science");
        params.put("limit", "1");

        Response response =

        given()
//                .queryParam("programme", "Computer Science")
//                .queryParam("limit", "1")
                .queryParams(params)
                .when()
                .get("/list");

        response.prettyPrint();
    }

    @DisplayName("Params Path")
    @Test
    public void go(){
        Response response =
        given()
                .pathParam("id", "2")
                .when()
                .get("/{id}");

        response.prettyPrint();
    }


}
