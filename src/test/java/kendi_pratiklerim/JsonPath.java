package kendi_pratiklerim;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JsonPath extends DummyBaseUrl {

     /*
    http://dummy.restapiexample.com/api/v1/employees
    url ine bir istek gönderildiğinde,
    status kodun 200,
    gelen body de,
    5. çalışanın isminin "Airi Satou" olduğunu ,
    6. çalışanın maaşının "372000" olduğunu ,
    Toplam 24 tane çalışan olduğunu,
    "Rhona Davidson" ın employee lerden biri olduğunu
    "21", "23", "61" yaşlarında employeeler olduğunu test edin
    JSONPATH KULLARAK
*/

    @Test
    public void test01(){
        spec02.pathParams("first","api","second","v1","third","employees");

        Response response=given().spec(spec02).when().get("/{first}/{second}/{third}");

        response.prettyPrint();


    }


}
