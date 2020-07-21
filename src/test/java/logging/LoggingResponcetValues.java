package logging;

import com.student.tests.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoggingResponcetValues extends TestBase {



    @Test
    public void test1(){
        System.out.println("---------Response Headers-------");
        given()
                .param("programme", "Computer Science")
                .param("limit","1")
                .when()
                .get("/list")
                .then()
                .log().headers()
                .statusCode(200);
    }

    @Test
    public void test2(){
        System.out.println("---------Response Status Line-------");
        given()
                .param("programme", "Computer Science")
                .param("limit","1")
                .when()
                .get("/list")
                .then()
                .log().status()
                .statusCode(200);
    }

    @Test
    public void test3(){
        System.out.println("---------Response Body-------");
        given()
                .param("programme", "Computer Science")
                .param("limit","1")
                .when()
                .get("/list")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void test4(){
        System.out.println("---------Response Body-------");
        given()
                .param("programme", "Computer Science")
                .param("limit","1")
                .when()
                .get("/list")
                .then()
                .log().ifError()
                .statusCode(200);
    }



}
