package jsonPathJsonExample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

public class JsonClassJsonSlurperExample {

    static ValidatableResponse validatableResponse;

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        validatableResponse = RestAssured
                .given()
                .when()
                .get("/stores")
                .then();
    }

    @BeforeEach
    void printToConsole(){
        System.out.println("------------Starting method----------");
        System.out.println("   ");
    }

    @AfterEach
    void printToConsoleAfrter(){
        System.out.println("------------Ending the method-----------");
        System.out.println("       ");
    }

    @DisplayName("Print the 'total' value from the cases")
    @Test
    public void printTheTotalValueFromTheResponse(){
        int total = validatableResponse.extract().path("total");
        System.out.println("TOTAL = " + total );
    }

    @DisplayName("Get Firs Store Name")
    @Test
    public void getFirstStoredName(){
        String  name = validatableResponse.extract().path("data[0].name");
        System.out.println("name = " + name );
    }

    @DisplayName("Get Firs Service Name")
    @Test
    public void getFirstServiceName(){
        String sName = validatableResponse.extract().path("data[0].services[0].name");
        System.out.println("sName = " + sName );
    }

    @DisplayName("Get all the info    ")
    @Test
    public void getFirstServiceName2(){
        String sName = validatableResponse.extract().path("data[0].services[0].name");
        System.out.println("sName = " + sName );
    }

}
