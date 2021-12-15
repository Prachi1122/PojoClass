package com.petStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutRequest {
	@Test
public void put() {
		JSONObject jobj = new JSONObject();
		jobj.put("id", 12);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("https://petstore.swagger.io/v2/pet")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
		
	
}
}
