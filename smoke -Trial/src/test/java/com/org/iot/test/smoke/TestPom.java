/*Description: Driver Class for the API Automation
Author : Meenak
Project : IoT*/


package com.org.iot.test.smoke;
import static com.jayway.restassured.RestAssured.*;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;



public class TestPom extends TcConstants{
	final static Logger logger = Logger.getLogger(TestPom.class);
	
	@BeforeClass
	
	public void setupAutomation() throws IOException{
	
		PropertyConfigurator.configure("./log4j.properties");
		Config csObj = new Config();
		logger.info("Automation Started- Preparing Environment in the DAV table");
		Datasource ds = new Datasource(csObj.getdbLogin(),csObj.getdbpassword(),csObj.getdbName(),csObj.getdbHost(),csObj.getdbPort(),csObj.getconnectionURL());
		logger.info("Cleaning Up Groups");
		ds.Change("delete from\t" +GROUP+" where creator=\t"+"'"+csObj.getOrigin()+"'");
		logger.info("Cleaning Up Containers");
		ds.Change("delete from\t" +CONTAINER+" where creator=\t"+"'"+csObj.getOrigin()+"'");
		logger.info("Cleaning Up Subscriptions");
		ds.Change("delete from\t" +SUBSCRIPTION+" where creator=\t"+"'"+csObj.getOrigin()+"'");
		
		System.out.println("Before");
		
		
		
	}


	@Test(priority=1, description="Validate whether the application is able to access AE information")
	public void getAE() throws IOException{
		
		System.out.println("Test");
	}
}
