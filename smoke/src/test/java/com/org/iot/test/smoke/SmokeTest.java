/*Description: Driver Class for the API Automation
Author : Meenak
Project : IoT*/


package com.org.iot.test.smoke;
import static com.jayway.restassured.RestAssured.*;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;



public class SmokeTest extends TcConstants{
	final static Logger logger = Logger.getLogger(SmokeTest.class);


	@Test
	public void getAE() throws IOException{
		//System.out.println("started GE");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Starting Get Application Entity Information Test Case");

		Config aeObj= new Config();
		logger.info("Getting Node Link Pattern from the Config");
		String nodelinkPattern= aeObj.getNodelink();	
		String URL = aeObj.getBaseUri()+aeObj.getPort()+aeObj.getBasepath()+aeObj.getAsset();
		logger.info("Node Link Pattern fetched"+nodelinkPattern);
		logger.info("Generating Headers and parameters");
		try{
			Response resp = given().log().all().
					params("rt",aeObj.getSyncrequest()).
					header("X-M2M-Origin", aeObj.getOrigin() ).
					header("Authorization", aeObj.getAuthorization()).
					header("X-M2M-RI",aeObj.randomRI()).
					header("Content-Type",aeObj.getContentype_AE()).
					header("Accept",aeObj.getAccept()).
					when().
					get(URL);
			logger.info("Status Code received from Server"+resp.statusCode());
			if(resp.statusCode()==SUCCESSOK){
				logger.info("****************DAV Hit and data fetched**********************");
				String actualResult = resp.
						then().
						contentType(ContentType.JSON).
						extract().body().asString();
				boolean nodelinkPresent=actualResult.contains(nodelinkPattern);
				logger.info("NodeLinkMatched:"+nodelinkPresent);
				logger.info("Response from the DAV:"+actualResult);
				logger.info("***************************Get Application Entity Information Test Case Passed and Ended************************");
				Assert.assertEquals(nodelinkPresent, true);
				
			}
			else if (resp.statusCode()==UNAUTHORIZED){
				logger.info("Testcase Failed And Ended:DAV not Reachable-Unauthorized due to: Status Code"+ UNAUTHORIZED);
				Assert.fail();
			}
			else if (resp.statusCode()==INTERNALSERVERERROR){
				logger.info("Test Case Failed and Ended:DAV  Reachable but Server not able to process due to: Status Code:"+ INTERNALSERVERERROR);
				Assert.fail();
			}
			else{
				logger.info("Test Case Failed and Ended:Check the Request and Script");
				Assert.fail();
			}

		}catch(ConnectException e){
			logger.error("Test Case Failed and Ended due to Error in Connection:" +e);
			Assert.fail();
		}

	}

	@Test
	public void createGroup()throws IOException, InvalidFormatException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Starting Create Group Test Case");
		Config cgOBJ = new Config();
		logger.info("Constructing Post URL");
		String URL = cgOBJ.getBaseUri()+cgOBJ.getPort()+cgOBJ.getBasepath();
		logger.info("Constructed URL for the Post Request :"+URL);
		//		baseURI = cgOBJ.getBaseUri();
		//		basePath = cgOBJ.getBasepath();
		TestData td = new TestData();
		//String body = td.getgroupBody();

		/*CreateGroupMain mainObj=new CreateGroupMain();
		//CreateGroupACPI acpOBJ = new CreateGroupACPI();
		mainObj.setAcpi(td.getACP());
		mainObj.setRn(td.getRN());
		mainObj.setCr(td.getCR());
		mainObj.setCnm(td.getCNM());
		//mainObj.setAcpi(new CreateGroupACPI[] {acpOBJ});
		mainObj.setCnm(td.getMNM());
		mainObj.setGn(td.getGN());*/
		logger.info("Generating headres and parameters");
		logger.info("Header and body params sent for the create request");
		try{
			Rand ranObj = new Rand();
			ranObj.setRandomGroup();;
			Response resp1=with().log().all().
					header("X-M2M-Origin", cgOBJ.getOrigin()).
					header("Authorization", cgOBJ.getAuthorization()).
					header("X-M2M-RI",cgOBJ.randomRI()).
					header("Content-Type",cgOBJ.getContentype_GRP()).
					given().
					body(td.getgroupcreateBody()).
					when().
					post(URL);


			logger.info("Response Code Received from the Server"+resp1.statusCode());


			if(resp1.statusCode()==CREATED){
				logger.info("****************DAV Hit and Group Posted**********************");
				logger.info("Success Code 201 Created: Test Case Passed and Ended");
				Assert.assertEquals(resp1.statusCode(), CREATED);
			}
			else if (resp1.statusCode()==UNAUTHORIZED){
				logger.error("Test Case Failed and Ended due to DAV not Reachable-Unauthorized");
				Assert.fail();
			}
			else if (resp1.statusCode()==INTERNALSERVERERROR){
				logger.error("Test Case Failed and Ended due to Internal Server Error-Check the Request ");
				Assert.fail();
			}
			else if (resp1.statusCode()==FORBIDDEN){
				logger.error("Test Case Failed and Ended due to Forbidden make sure ACP is correct ");
				Assert.fail();
			}
			else{
				logger.error("Test Case Failed and Ended due to Check the Request and Script");
				Assert.fail();
			}
		}catch(ConnectException e){
			logger.error("Test Case Failed and Ended due to Error in Connection"+e);
			Assert.fail();
		}
	}



	@Test
	public void createContainer()throws IOException, InvalidFormatException{
		PropertyConfigurator.configure("log4j.properties");

		logger.info("Starting Create Container Test Case");
		Config ccOBJ = new Config();
		logger.info("Constructing Post URL");
		String URL = ccOBJ.getBaseUri()+ccOBJ.getPort()+ccOBJ.getBasepath()+ccOBJ.getAsset();
		logger.info("Constructed URL for the Post Request :"+URL);
		TestData td = new TestData();
		logger.info("Generating headres and parameters");
		logger.info("Header and body params sent for the create request");
		try{
			Rand ranObj = new Rand();
			ranObj.setRandomContainer();
			Response resp1=with().log().all().
					header("X-M2M-Origin", ccOBJ.getOrigin()).
					header("Authorization", ccOBJ.getAuthorization()).
					header("X-M2M-RI",ccOBJ.randomRI()).
					header("Content-Type",ccOBJ.getContentype_CNT()).
					given().
					body(td.getcontainercreateBody()).
					when().
					post(URL);


			logger.info("Response Code Received from the Server"+resp1.statusCode());


			if(resp1.statusCode()==CREATED){
				logger.info("****************DAV Hit and Container Posted**********************");
				logger.info("Test Case Passed and Ended Due to Success Code 201 Created");
				Assert.assertEquals(resp1.statusCode(), CREATED);


			}

			else if (resp1.statusCode()==UNAUTHORIZED){
				logger.error("Test Case Failed and ended due to DAV not Reachable-Unauthorized");
				Assert.fail();
			}
			else if (resp1.statusCode()==INTERNALSERVERERROR){
				logger.error("Test Case Failed and ended due Internal Server Error-Check the Request ");
				Assert.fail();
			}
			else if (resp1.statusCode()==FORBIDDEN){
				logger.error("Test Case Failed and ended due Forbidden make sure ACP is correct ");
				Assert.fail();
			}
			else{
				logger.error("Test Case Failed and ended due Check the Request and Script");
				Assert.fail();
			}

		}catch(ConnectException e){
			logger.error("Test Case Failed and ended due Error inConnection:"+e);
			Assert.fail();
		}


	}

	@Test(dependsOnMethods  ={"createContainer"})
	public void getContainerData() throws IOException, InvalidFormatException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Starting Get Application Entity Conatiner data Test Case");

		Config cdObj= new Config();
		TestData tdOBJ = new TestData();
		logger.info("Constructing URL for the regquest");
		String URL = cdObj.getBaseUri()+cdObj.getPort()+cdObj.getBasepath()+cdObj.getAsset()+"/"+tdOBJ.getContainerName();
		logger.info("Constructed URL for the request:\t"+URL);
		logger.info("Generating Headers and parameters");
		try{
			Response resp = given().log().all().
					params("rt",cdObj.getSyncrequest()).
					header("X-M2M-Origin", cdObj.getOrigin() ).
					header("Authorization", cdObj.getAuthorization()).
					header("X-M2M-RI",cdObj.randomRI()).
					header("Content-Type",cdObj.getContentype_CNT()).
					header("Accept",cdObj.getAccept()).
					when().
					get(URL);

			logger.info("Status Code received from Server"+resp.statusCode());
			if(resp.statusCode()==SUCCESSOK){
				logger.info(" Success Code 201 Created");
				String actualResult = resp.
						then().
						contentType(ContentType.JSON).
						extract().body().asString();

				Assert.assertEquals(resp.statusCode(),SUCCESSOK);
				logger.info("Repsonse Received from DAV:\t"+actualResult);
				logger.info("Test Case Passed and Ended");

			}
			else if (resp.statusCode()==UNAUTHORIZED){
				logger.info("Test Case Failed and Ended due to DAV not Reachable-Unauthorized due to: Status Code"+ UNAUTHORIZED);
				Assert.fail();
			}
			else if (resp.statusCode()==INTERNALSERVERERROR){
				logger.info("Test Case Failed and Ended due to DAV  Reachable but Server not able to process due to: Status Code:"+ INTERNALSERVERERROR);
				Assert.fail();
			}
			else{
				logger.info("Test Case Failed and Ended due to Check the Request and Script");
				Assert.fail();
			}

		}catch(ConnectException e){
			logger.error("Test Case Failed and Ended due to Error in Connection:" +e);
			Assert.fail();
		}

	}

	@Test
	public void createSubscriptionGroup() throws IOException, InvalidFormatException, SQLException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Starting Create Subcription for a group  Test Case");
		Config csObj= new Config();
		TestData tdOBJ = new TestData();
		logger.info("Constructing URL for the request");
		String URL = csObj.getBaseUri()+csObj.getPort()+csObj.getBasepath()+"/"+tdOBJ.getGroupName();
		logger.info("Constructed URL for the request:\t"+URL);
		logger.info("Generating Headers and parameters");
		try{
			Rand ranObj = new Rand();
			ranObj.setRandomSubscription_GRP();
			Response resp1=with().log().all().
					header("X-M2M-Origin", csObj.getOrigin()).
					header("Authorization", csObj.getAuthorization()).
					header("X-M2M-RI",csObj.randomRI()).
					header("Content-Type",csObj.getContentype_SUBS()).
					given().
					body(tdOBJ.getsubscreateBody_GRP()).
					when().
					post(URL);

			logger.info("Status Code received from Server"+resp1.statusCode());
			if(resp1.statusCode()==CREATED){
				logger.info("****************DAV Hit Subscription created**********************");
				logger.info("Performing Database validation for the Subscription");
				Datasource ds = new Datasource(csObj.getdbLogin(),csObj.getdbpassword(),csObj.getdbName(),csObj.getdbHost(),csObj.getdbPort(),csObj.getconnectionURL()); 
				String creator= csObj.getOrigin();
				logger.info("Creator is the filter selection in the Database:\t"+creator);
				ResultSet res = ds.Query("Select * from\t" +SUBSCRIPTION+" where creator=\t"+"'"+creator+"'");
				String expectedSUB= tdOBJ.getSubscriptionName_GRP();
				logger.info("Subscription Name Expected in the DataBase:\t"+expectedSUB);
				while(res.next()){

					String actual=res.getString("resource_name");
					//logger.info(actual);

					if(actual.equals(expectedSUB)){
						logger.info("Subscription Name: \t" + actual + "Found in DAV");
						logger.info("Testcase Passed and Ended");
						Assert.assertEquals(actual,expectedSUB);
					}

					else{
						logger.info(actual);
					}
				}			
			}
			else if (resp1.statusCode()==UNAUTHORIZED){
				logger.info("Test Case Failed and Ended due to DAV not Reachable-Unauthorized due to: Status Code"+ UNAUTHORIZED);
				Assert.fail();
			}
			else if (resp1.statusCode()==INTERNALSERVERERROR){
				logger.info("Test Case Failed and Ended due to DAV  Reachable but Server not able to process due to: Status Code:"+ INTERNALSERVERERROR);
				Assert.fail();
			}
			else{
				logger.info("Test Case Failed and Ended due to Check the Request and Script");
				Assert.fail();
			}
		}catch(ConnectException e){
			logger.error("Test Case Failed and Ended due to Error in Connection:" +e);
			Assert.fail();
		}

	}
	
	
	@Test
	public void createSubscriptionAE() throws IOException, InvalidFormatException, SQLException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Starting Create Subcription for AE  Test Case");
		Config csObj= new Config();
		TestData tdOBJ = new TestData();
		logger.info("Constructing URL for the regquest");
		String URL = csObj.getBaseUri()+csObj.getPort()+csObj.getBasepath()+csObj.getAsset();
		logger.info("Constructed URL for the request:\t"+URL);
		logger.info("Generating Headers and parameters");
		try{
			Rand ranObj = new Rand();
			ranObj.setRandomSubscription_AE();
			Response resp1=with().log().all().
					header("X-M2M-Origin", csObj.getOrigin()).
					header("Authorization", csObj.getAuthorization()).
					header("X-M2M-RI",csObj.randomRI()).
					header("Content-Type",csObj.getContentype_SUBS()).
					given().
					body(tdOBJ.getsubscreateBody_AE()).
					when().
					post(URL);

			logger.info("Status Code received from Server"+resp1.statusCode());
			if(resp1.statusCode()==CREATED){
				logger.info("****************DAV Hit Subscription created**********************");
				logger.info("Performing Database validation for the Subscription");
				Datasource ds = new Datasource(csObj.getdbLogin(),csObj.getdbpassword(),csObj.getdbName(),csObj.getdbHost(),csObj.getdbPort(),csObj.getconnectionURL()); 
				String creator= csObj.getOrigin();
				logger.info("Creator is the filter selection in the Database:\t"+creator);
				ResultSet res = ds.Query("Select * from\t" +SUBSCRIPTION+" where creator=\t"+"'"+creator+"'");
				String expectedSUB= tdOBJ.getSubscriptionName_AE();
				logger.info("Subscription Name Expected in the DataBase:\t"+expectedSUB);
				while(res.next()){

					String actual=res.getString("resource_name");
					//logger.info(actual);

					if(actual.equals(expectedSUB)){
						logger.info("Subscription Name: \t" + actual + "\tFound in DAV");
						logger.info("Testcase Passed and Ended");
						Assert.assertEquals(actual,expectedSUB);
					}

					else{
						logger.info(actual);
					}
				}			
			}
			else if (resp1.statusCode()==UNAUTHORIZED){
				logger.info("Testcase Failed and ended due to DAV not Reachable-Unauthorized due to: Status Code"+ UNAUTHORIZED);
				Assert.fail();
			}
			else if (resp1.statusCode()==INTERNALSERVERERROR){
				logger.info("Testcase Failed and ended due to DAV  Reachable but Server not able to process due to: Status Code:"+ INTERNALSERVERERROR);
				Assert.fail();
			}
			else{
				logger.info("Testcase Failed and ended due to Check the Request and Script");
				Assert.fail();
			}
		}catch(ConnectException e){
			logger.error("Testcase Failed and ended due to Error in Connection:" +e);
			Assert.fail();
		}

	}
	
	
	@Test(dependsOnMethods  ={"createContainer"})
		public void createSubscriptionCNT() throws IOException, InvalidFormatException, SQLException{
			PropertyConfigurator.configure("log4j.properties");
			logger.info("Starting Create Subcription for AE's Conatiner  Test Case");
			Config csObj= new Config();
			TestData tdOBJ = new TestData();
			logger.info("Constructing URL for the regquest");
			String URL = csObj.getBaseUri()+csObj.getPort()+csObj.getBasepath()+csObj.getAsset()+"/"+tdOBJ.getContainerName();
			logger.info("Constructed URL for the request:\t"+URL);
			logger.info("Generating Headers and parameters");
			try{
				Rand ranObj = new Rand();
				ranObj.setRandomSubscription_CNT();
				Response resp1=with().log().all().
						header("X-M2M-Origin", csObj.getOrigin()).
						header("Authorization", csObj.getAuthorization()).
						header("X-M2M-RI",csObj.randomRI()).
						header("Content-Type",csObj.getContentype_SUBS()).
						given().
						body(tdOBJ.getsubscreateBody_CNT()).
						when().
						post(URL);

				logger.info("Status Code received from Server"+resp1.statusCode());
				if(resp1.statusCode()==CREATED){
					logger.info("****************DAV Hit Subscription created**********************");
					logger.info("Performing Database validation for the Subscription");
					Datasource ds = new Datasource(csObj.getdbLogin(),csObj.getdbpassword(),csObj.getdbName(),csObj.getdbHost(),csObj.getdbPort(),csObj.getconnectionURL()); 
					String creator= csObj.getOrigin();
					logger.info("Creator is the filter selection in the Database:\t"+creator);
					ResultSet res = ds.Query("Select * from\t" +SUBSCRIPTION+" where creator=\t"+"'"+creator+"'");
					String expectedSUB= tdOBJ.getSubscriptionName_CNT();
					logger.info("Subscription Name Expected in the DataBase:\t"+expectedSUB);
					while(res.next()){

						String actual=res.getString("resource_name");
						//logger.info(actual);

						if(actual.equals(expectedSUB)){
							logger.info("Subscription Name: \t" + actual + "\tFound in DAV");
							logger.info("Testcase Passed and Ended");
							Assert.assertEquals(actual,expectedSUB);
						}

						else{
							logger.info(actual);
						}
					}			
				}
				else if (resp1.statusCode()==UNAUTHORIZED){
					logger.info("TestCase failed and Ended due to DAV not Reachable-Unauthorized due to: Status Code"+ UNAUTHORIZED);
					Assert.fail();
				}
				else if (resp1.statusCode()==INTERNALSERVERERROR){
					logger.info("TestCase failed and Ended due DAV  Reachable but Server not able to process due to: Status Code:"+ INTERNALSERVERERROR);
					Assert.fail();
				}
				else{
					logger.info("TestCase failed and Ended due Check the Request and Script");
					Assert.fail();
				}
			}catch(ConnectException e){
				logger.error("TestCase failed and Ended due Error in Connection:" +e);
				Assert.fail();
			}

		}
}
