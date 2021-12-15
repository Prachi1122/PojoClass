package com.rmgyanta.api.GenericUtilies;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class JSONUtility {

public String getJsonData(Response response,String JsonXpath ) {
	
	String jsonData=response.jsonPath().get(JsonXpath);
	return jsonData;
}
}
