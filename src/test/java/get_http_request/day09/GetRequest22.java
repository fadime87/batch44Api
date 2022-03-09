package get_http_request.day09;

import base_url.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest22 extends HerOkuAppBaseUrl {
    /*
https://restful-booker.herokuapp.com/booking/47
       {
           "firstname": "Ali",
           "lastname": "Can",
           "totalprice": 500,
           "depositpaid": true,
           "bookingdates": {
               "checkin": "2022-02-01",
               "checkout": "2022-02-11"
          }
       }
1) JsonPhat
2) De-Serialization
*/

    @Test
    public void test22(){
        //1)URL olustur
        spec05.pathParams("first","booking","second",4);

        //2) expected data olustur
        HerOkuAppTestData expectedObje=new HerOkuAppTestData();
        HashMap<String,Object> expectedTestDataMap = expectedObje.setUpTestData();

        System.out.println("Test Data Icindeki ExpectedData : " + expectedTestDataMap);
        //{firstname=Ali, bookingdates={checkin=2022-02-01, checkout=2022-02-11}, totalprice=500, depositpaid=true, lastname=Can}

         //Request ve response
        Response response=given().spec(spec05).when().get("/{first}/{second}");
        response.prettyPrint();

        //4)Dogrulama
        //1. yol De-Serilazation

        HashMap<String,Object>actualData=response.as(HashMap.class);
        //Json formatindaki datay i hashMap a donusturur.
        System.out.println("Actual Data :" + actualData);

        Assert.assertEquals(expectedTestDataMap.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedTestDataMap.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedTestDataMap.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedTestDataMap.get("depositpaid"),actualData.get("depositpaid"));

       Assert.assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkin"),
               ((Map)actualData.get("bookingdates")).get("checkin"));

       Assert.assertEquals(((Map) expectedTestDataMap.get("bookingdates")).get("checkout"),
               ((Map<?, ?>) actualData.get("bookingdates")).get("checkout"));

       //2. yol Json Path

        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedTestDataMap.get("firstname"),json.getString("firstname"));
        Assert.assertEquals(expectedTestDataMap.get("lastname"),json.getString("lastname"));
        Assert.assertEquals(expectedTestDataMap.get("totalprice"),json.getString("totalprice"));
        Assert.assertEquals(expectedTestDataMap.get("depositpaid"),json.getString("depositpaid"));


        Assert.assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkin"),
               json.getString("bookingdates,checkin"));
        Assert.assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkout"),
                json.getString("bookingdates,checkout"));
    }

}
