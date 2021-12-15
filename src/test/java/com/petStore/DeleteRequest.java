package com.petStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteRequest {
	@Test
	public void delet()
	{
	
	when()
	.delete("https://petstore.swagger.io/v2/pet/12")
	.then()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON)
	.assertThat().log().all();

		
		
	}
	
	

}
