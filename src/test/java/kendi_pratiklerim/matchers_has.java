package kendi_pratiklerim;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.given;

public class matchers_has {
     /*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Bradley Greer","Doris Wilder"
ve gelen yaslar icinde 21, 24, ve 19 degerlerinden birinin oldugunu test edin.
 */

@Test
    public void test03(){
    String url="http://dummy.restapiexample.com/api/v1/employees";
    Response response=given().when().get(url);
    response.prettyPrint();

    response.then().assertThat().contentType("application/json").statusCode(200);

    response.then().assertThat().body("data.employee.age", Matchers.hasItems(21, 24, 19)
                                ,"data.employee_name" ,Matchers.hasItems("Bradley Greer,Doris Wilder"));
}
}
