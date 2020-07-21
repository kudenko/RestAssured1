package logging;

import com.github.javafaker.Faker;
import com.student.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.StudentPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class LoggingRequestValues extends TestBase {

    @Test
    public void test1(){
        System.out.println("--------Request Headers---------");
        given()
                .log().headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void test2(){
        System.out.println("---------Request Parameters-------");
        given()
                .param("programme", "Computer Science")
                .param("limit","1")
                .log().parameters()
                .log().uri()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

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
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }

    @DisplayName("Create a new Student an an Object")
    @Test
    void createStudent23() {

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
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }
    @DisplayName("Create a new Student an an Object")
    @Test
    void createStudent24() {

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
                .log().ifValidationFails()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }
}
