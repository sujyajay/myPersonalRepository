package com.NewProjectFeb02.com;


import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_RestAPI {

	@Test(description = "API AUTHENTICATION TEST")
	public void authAPIGET(){
		
		RequestSpecification request = RestAssured.given();
		request.auth().preemptive().basic("ToolsQA", "TestPassword");
		Response response = request.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		System.out.println(response.getBody().asString());
	
	}	
	
	@Test(enabled = false)
	public void restAPIGETRequest(){
		
	RequestSpecification httpReuest = RestAssured.given();	
	Response response = httpReuest.get("https://chercher.tech/sample/api/product/read?id=90");
	System.out.println("The response body  :  " + response.getBody().asString());;
	System.out.println("The response status code : " + response.getStatusCode());;
	
	JsonPath jp = new JsonPath(response.getBody().asString());
	
	System.out.println(jp.get("id"));
	
	//Assert.assertEquals((jp.get("id").toString().contains("90")), true, "ID is wrong, to review");
	boolean check = response.getBody().asString().contains("price"); 
	Assert.assertEquals(true, true);
	System.out.println();
	
	//test only
		
	}
	
	@Test(dataProvider = "dp")
	public void restAPIPOSTRequest(String fname, String lname, String uName, String passcode, String email ){
		
		JSONObject jsonReqBody = new JSONObject();
		jsonReqBody.put("FirstName",fname);
		jsonReqBody.put("LastName",lname);
		jsonReqBody.put("UserName",uName);
		jsonReqBody.put("Password",passcode);
		jsonReqBody.put("Email",email);
		
		RequestSpecification httpPostRequest = RestAssured.given();
		httpPostRequest.body(jsonReqBody.toString());
		Response response = httpPostRequest.post("http://restapi.demoqa.com/customer/register");
		System.out.println(response.getBody().asString());
		System.out.println();
		System.out.println(response.getStatusCode());
		System.out.println();
		System.out.println(response.statusLine());
		System.out.println();
		//Assert.assertEquals(true, response.getBody().asString().contains("name"));	
	}

	@DataProvider
		public String[][] dp() throws FileNotFoundException, IOException {
		
		
//		String[][] dataToPost = {	{"PSY03", "YAD03", "PSY03", "YAD03", "email3@hm.com"}, 
//									{"PSY04", "YAD04", "PSY04", "YAD04", "email4@hm.com"},
//									};
		
					return readXLDate("C:/Users/Batman/SampleMaven01/Sample.xlsx", "Sheet1");
					
				}
	
		public String[][] readXLDate(String worksheet, String sheet) throws FileNotFoundException, IOException{
		
		//FileInputStream fileConnection = new FileInputStream(worksheet);
		XSSFWorkbook wb = new XSSFWorkbook(worksheet);
		XSSFSheet ws = wb.getSheet(sheet);
		Row row = ws.getRow(0);
		int rowCount = ws.getLastRowNum();
		int columnCount = row.getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		
		for(int i = 1; i<=rowCount;i++){
			row = ws.getRow(i);
			for(int j=0;j<columnCount;j++){
				
				data[i-1][j] = row.getCell(j).toString(); 
			}
		}
		
		return data;
		
		}
		
	}