package JsonClassTest;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JsonPathTest  {

    static String jsonResponse;

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        jsonResponse = RestAssured.given()
                .when()
                .get("/products").asString();
    }

    @DisplayName("Get root element")
    @Test
    public void getRoot(){
        Map<String, ?> rootElem = JsonPath.read(jsonResponse, "$");
        System.out.println(rootElem.toString());
    }

    @DisplayName("Get total value from the response")
    @Test
    public void getTotalFromResponse(){
        int totalValue = JsonPath.read(jsonResponse, "$.total");
        System.out.println(totalValue);
    }

    @DisplayName("Get all the data elements")
    @Test
    public void getAllDataElements(){
        List<HashMap<String, Object>> dataElems = JsonPath.read(jsonResponse, "$.data");
        dataElems.stream().forEach(System.out::println);
    }

    @DisplayName("Get First the data elements")
    @Test
    public void getFirstDataElements(){
        HashMap<String, Object> dataElems = JsonPath.read(jsonResponse, "$.data[0]");
        System.out.printf(dataElems.toString());
    }

    @DisplayName("Get Last  the data elements")
    @Test
    public void getLastDataElements(){
        HashMap<String, Object> dataElems = JsonPath.read(jsonResponse, "$.data[-1]");
        System.out.printf(dataElems.toString());
    }

    @DisplayName("Get All ids ")
    @Test
    public void getAllIds(){
        List<String> dataElems = JsonPath.read(jsonResponse, "$.data[*].id");
        System.out.printf(dataElems.toString());
    }

    @DisplayName("Get All ids2 ")
    @Test
    public void getAllIds2(){
        List<String> dataElems = JsonPath.read(jsonResponse, "$..[*].id");
        System.out.printf(dataElems.toString());
    }

    @DisplayName("Get All elems with price < 5")
    @Test
    public void getElemsWithPriceLowerFive(){
        List<String> names = JsonPath.read(jsonResponse, "$.data[?(@.price < 5)].name");
        System.out.printf(names.toString());
    }

    @Test
    public void trainStreams(){

        List<Integer> aaa = new LinkedList<>();
        aaa.add(2);
        aaa.add(3);
        aaa.add(4);
        aaa.add(2);
        aaa.add(2);



        System.out.println("ssasdasd " + aaa.get(2));


        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);

        integers.add(2);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        HashMap<String, String > h = new HashMap<>();
        h.put(null, "1");
        h.put(null, "12");
        List<Integer> integers1 = new ArrayList<>();


        integers.stream().forEach(
                a->{
                    if(a%2 == 0){
                        integers1.add(a*2);
                    }else
                    if(a%3 == 0){
                        integers1.add(a*3);
                    }
                    else {
                        integers1.add(a);
                    }
                }
        );
        System.out.println(integers1);
    }


}
