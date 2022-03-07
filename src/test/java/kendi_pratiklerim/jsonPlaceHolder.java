package kendi_pratiklerim;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class jsonPlaceHolder extends JsonPlaceHolderBaseUrl {

      /*
   https://jsonplaceholder.typicode.com/todos/7

   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */

    @Test
    public void test01(){

        spec04.pathParams("first","todos","second",7);

        Map<String,Object> expecteddata =new HashMap<>();
        expecteddata.put("userId",1);
        expecteddata.put("id", 7);
        expecteddata.put("title","illo expedita consequatur quia in");
        expecteddata.put("completed", false);

        System.out.println("expectedData : " + expecteddata);


        Response response=given().spec(spec04).when().get("/{first}/{second}");

        response.prettyPrint();

        Map<String,Object> actualData =response.as(HashMap.class);

        System.out.println("ActualData : " + actualData);
    }
}
