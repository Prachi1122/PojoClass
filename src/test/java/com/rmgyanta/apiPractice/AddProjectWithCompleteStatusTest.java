package com.rmgyanta.apiPractice;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.PojoUtility.PojoLibrary;
import com.rmgyanta.api.GenericUtilies.ApiBaseClass;
import com.rmgyanta.api.GenericUtilies.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class AddProjectWithCompleteStatusTest  extends ApiBaseClass{
	@Test
	public void addProjectWithCompletedstatus() throws Throwable {
		String status="Completed";
		String projectName= "SDET-22"+JavaUtility.getRandomData();
		PojoLibrary pojo = new PojoLibrary("raki", projectName, status, 50);
		Response resp =given()
			.contentType(ContentType.JSON)
			.body(pojo)
			
		     .when()
			 .post("http://localhost:8084/addProject");
		resp.then().assertThat().statusCode(201).log().all();
		  
		String apiRespProjectName = resp.jsonPath().get("projectName");
		System.out.println(apiRespProjectName);
		
		//connect to db & get the data
		String dbProjName=dlib.getDataFromDBAndVerify("select * from project", 4, projectName);
		String dbStatus=dlib.getDataFromDBAndVerify("select * from project", 5, status);
		Assert.assertEquals(dbProjName, apiRespProjectName);
		
	}
}
