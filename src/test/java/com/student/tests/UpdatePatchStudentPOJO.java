package com.student.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.StudentPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UpdatePatchStudentPOJO extends TestBase{

    @DisplayName("Update an existing Student with an Object")
    @Test
    void updateStudent() {

        StudentPojo student = new StudentPojo();
        Faker fake = new Faker();

        student.setEmail(fake.internet().emailAddress());

        RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("101")
                .then()
                .statusCode(200);
    }
}




