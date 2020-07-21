package com.student.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.StudentPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeletePatchStudentPOJO extends TestBase{

    @DisplayName("Update an existing Student with an Object")
    @Test
    void updateStudent() {

        StudentPojo student = new StudentPojo();

        RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .delete("/101")
                .then()
                .statusCode(204);
    }
}




