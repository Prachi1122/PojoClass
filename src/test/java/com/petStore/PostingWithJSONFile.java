package com.petStore;

import java.io.File;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostingWithJSONFile {
	@Test
	public void post() {
		File file = new File("./src/main/resources/petfile.json");
		Response ref = given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("https://petstore.swagger.io/v2/pet");
		ref.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		when()
		.get("https://petstore.swagger.io/v2/pet/1234")
		.then().assertThat().contentType(ContentType.JSON)
		.log().all()
		;
		
	}

}
