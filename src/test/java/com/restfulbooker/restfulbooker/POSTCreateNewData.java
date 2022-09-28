package com.restfulbooker.restfulbooker;

import com.restfulbooker.model.BookingPojo;
import com.restfulbooker.testbase.TestBase;
import com.sun.org.apache.regexp.internal.RE;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class POSTCreateNewData extends TestBase {

    static ValidatableResponse response;
    @Test
    public void CreateData()
    {
        HashMap<String,String> bookingdates = new HashMap<>();
        bookingdates.put("checkin","2021-09-10");
        bookingdates.put("checkout","2021-10-20");



        BookingPojo bookingPojo =new BookingPojo();
        bookingPojo.setFirstname("Divyaa");
        bookingPojo.setLastname("Patela");
        bookingPojo.setTotalprice(560);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalNeeds("Bat Dish");

        Response response = given()
                .header("Content-Type","application/json")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
