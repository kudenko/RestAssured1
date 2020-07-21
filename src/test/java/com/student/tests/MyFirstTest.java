package com.student.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class MyFirstTest {

    private void goFirst(){
        given()
        .queryParam("", "")
         .when()
         .get("https://www.google.com")
         .then();

        given()
        .expect()
        .when();

    }

    @DisplayName("Getting all the students from the DB")
    @Test
    void getAllStudents(){
        RequestSpecification requestSpecification = RestAssured
                .given();

        Response r = requestSpecification.get("http://localhost:8085/student/list");

        //r.prettyPrint();

        ValidatableResponse validatableResponse = r.then();

        System.out.printf("======================== ");

        validatableResponse.statusCode(200);


                given()
                .when()
                .get("http://localhost:8085/student/list")
                .then()
                .statusCode(200);


                expect()
                .statusCode(200)
                .when()
                .get("http://localhost:8085/student/list");

    }


}
