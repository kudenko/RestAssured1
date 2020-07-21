package com.student.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateStudent extends TestBase{

    @DisplayName("Create a new Student")
    @Test
    void createStudent() {
        RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body("{\"firstName\":\"test2\",\"lastName\":\"user\",\"email\":\"test3@gmail.com\",\"programme\":\"ComputerScience\",\"courses\":[\"C++\",\"JAVA\"]}")
                .post()
                .then()
                .statusCode(201);
    }
}




