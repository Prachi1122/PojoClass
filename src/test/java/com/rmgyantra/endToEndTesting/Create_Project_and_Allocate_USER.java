package com.rmgyantra.endToEndTesting;

import org.testng.annotations.Test;

import com.PojoUtility.PojoEmployee;
import com.PojoUtility.PojoLibrary;
import com.rmgyanta.api.GenericUtilies.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Create_Project_and_Allocate_USER {
	@Test
	public void createProject_WithUSer() {
		String status = "Completed";
		String projectName = "SDET_22_"+JavaUtility.getRandomData();
		PojoLibrary pojoObj = new PojoLibrary("deepak", projectName, status, 10);		
		//execute API and get the data & verify
		
          Response resp = given()
        		             .contentType(ContentType.JSON)
        		             .body(pojoObj).when()
        		             .post("/addProject");
		           resp.then()
						    .assertThat().statusCode(201)
						    .log().all();
		          String apiResponseProjectName =  resp.jsonPath().get("projectName");
		          
		          
		  //create user for above project
		          PojoEmployee empPojoObj = new PojoEmployee("sdet", "12/12/1990", "deepak@gmail.com", "deepak_gowda", 15, "9886662262", apiResponseProjectName, "ROLE_ADMIN", "deepak_gowda");      
		                  given()
						     .contentType(ContentType.JSON)
						     .body(empPojoObj)
						    .when()
						     .post("/employees")
		           .then()
		               .assertThat().statusCode(201)
		               .log().all();
		          
		          
	}
}
