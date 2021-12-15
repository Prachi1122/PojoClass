package com.petStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequest {
@Test
public void post()
{
	JSONObject jobj = new JSONObject();
	jobj.put("id", 10);
	jobj.put("name", "Dog");
	jobj.put("status", "Available");
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.post("https://petstore.swagger.io/v2/pet")
	.then()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON)
	.assertThat().log().all();
}
}