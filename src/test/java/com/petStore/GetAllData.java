package com.petStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllData {
@Test
public void getData() {
	when()
	.get("https://petstore.swagger.io/v2/store/inventory")
	.then()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
