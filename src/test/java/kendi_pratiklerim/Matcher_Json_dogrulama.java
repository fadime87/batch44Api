package kendi_pratiklerim;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Matcher_Json_dogrulama extends DummyBaseUrl {
     /*
    http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
    1) Matcher CLASS ile
    2) JsonPath ile dogrulayin.
    */

    @Test
    public void test01(){

       spec02.pathParams("first","api","second","v1","third","employee","forth","12");

        Response response = given().spec(spec02).when().get("/{first}/{second}/{third}/{forth}");



        response.prettyPrint();


        //MATCHERS CLASS iLE
        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("data.employee_name", equalTo("Quinn Flynn"),
                        "data.employee_salary",equalTo(342000),
                        "data.employee_age",equalTo(22));

        //JSON PATH
        JsonPath jsonPath=response.jsonPath();

        System.out.println(jsonPath.getString("data.employee_name"));
        System.out.println(jsonPath.getInt("data.employee_age"));
        System.out.println(jsonPath.getInt("data.employee_salary"));


    assertEquals("Quinn Flynn",jsonPath.getString("data.employee_name"));
    assertEquals(342000,jsonPath.getInt("data.employee_salary"));
    assertEquals(22,jsonPath.getInt("data.employee_age"));







    }
}
