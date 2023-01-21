package RestAssuredBDD;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DELETE_BDD {

    public static HashMap mapM = new HashMap();

    @BeforeMethod
    public void beforeDELETE(){

    }

    @Test
    public void deleteMethod(){
        //If there is no commands in given() key, u can remove it and start with when() with (.)
        //If  you need to validate the response. use response method

        Response response =
        given()
                .contentType("application/json")
           .when()
                .delete("http://dummy.restapiexample.com/api/v1/delete/5")

           .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        //Response validation
            String resJsonToString = response.asString();
        Assert.assertEquals(resJsonToString.contains("Successfully! Record has been deleted"),true);

    }
}
