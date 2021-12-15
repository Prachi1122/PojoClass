package com.rmgyanta.api.GenericUtilies;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ApiBaseClass {
public DataBaseUtility dlib= new DataBaseUtility();
public String URI="http://localhost:8084";
@BeforeSuite
public void configBeforeSuite() throws Throwable {
	dlib.ConnectionToDB();
	System.out.println("DB conection success");
}
@AfterSuite
public void configAfterSuite() throws Throwable {
	dlib.closeDB();
}
}