package RestAssuredBDD;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PUT_BDD {

    public static HashMap map = new HashMap();

    @BeforeMethod
    public void beforePUT(){

        map.put("message","Successfully! Record has been fetched.");
        map.put("data.id",1);
        map.put("employee_name",Util_RandomGenerate.getUsernameName());
        map.put("employee_salary",320801);
        map.put("employee_age",61);
        map.put("profile_image","");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/update/1";

    }

    @Test
    public void putBDDMethod(){
        given()
                .contentType("application/json")
                .body(map)
           .when()
                .put()
            .then()
                .statusCode(200)
                .log().all();

    }
}
