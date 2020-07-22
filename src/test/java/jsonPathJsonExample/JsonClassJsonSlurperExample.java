package jsonPathJsonExample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

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

    @DisplayName("Get all the info  of store with ZIP ")
    @Test
    public void findStoreWithZip(){
        Map<String, ?> info =  validatableResponse.extract().path("data.find{it.zip=='55901'}");
        System.out.println("info = " + info);
    }

    @DisplayName("Get address of store with ZIP 55901")
    @Test
    public void getAddressFromZipId(){
        String  info =  validatableResponse.extract().path("data.find{it.zip=='55901'}.address");
        System.out.println("info = " + info);
    }

    @DisplayName("Get info from max and min id")
    @Test
    public void getAllInfoWithMaxAndMinId(){
        Map<String, ?> info1 =  validatableResponse.extract().path("data.min{it.id}");
        Map<String, ?> info =  validatableResponse.extract().path("data.max{it.id}");

        System.out.println("info = " + info);
        System.out.println("info1 = " + info1);

    }
    @DisplayName("Get info from max and min id or others")
    @Test
    public void getAllInfoWitRangeId(){
        List<String> info =  validatableResponse.extract().path("data.findAll{it.id<10}.zip");

        System.out.println("info = " + info);

    }

    @DisplayName("Get service name for all the stores")
    @Test
    public void getServiceName(){
        List<String> info =  validatableResponse.extract().path("data.services.findAll{it.name}.name");

        System.out.println("info = " + info);

    }

    @DisplayName("Get service name for the stores with id < 5")
    @Test
    public void getServiceNameWithLowerFiveId(){
        List<List<String>> info =  validatableResponse.extract().path("data.services.findAll{it.name}.name");

        System.out.println("info = " + info);

    }

}
