package com.student.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.StudentPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateStudentPOJO extends TestBase{

    @DisplayName("Create a new Student an an Object")
    @Test
    void createStudent() {

        StudentPojo student = new StudentPojo();
        List<String> courses = new ArrayList<String>();
        Faker fake = new Faker();

        courses.add("JAVA");
        courses.add("C++");

        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }
}




