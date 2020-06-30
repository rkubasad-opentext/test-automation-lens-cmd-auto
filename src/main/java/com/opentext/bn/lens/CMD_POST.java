package com.opentext.bn.lens;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

//import groovy.json.internal.ArrayUtils;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class CMD_POST {
	
	public static Response CMD_POST(String Baseurl) {
		
		
		//RestAssured.baseURI=BASEURI;
		RestAssured.baseURI="http://qtotcra.qa.gxsonline.net:8080/communitymasterdata/rest/v1/businessUnits";
		
		RequestSpecification CMDRequest=RestAssured.given();
		
		
		//*CMD POST headers
		CMDRequest.header("im_bu_id","GCIMCO235HE");
		CMDRequest.header("im_user_id","GCP0P4919B8I2");
		CMDRequest.header("im_service_instance_id","594101");
		CMDRequest.header("im_community_id","IM_COMM");
		CMDRequest.header("im_principal_type","USER_SESSION");
		CMDRequest.header("Content-Type","application/json");
		
		//*CMD Request BODY
		CMDRequest.body(
				"{"
							 
					 +"\"name\" :\"BUsystemnew1203\","
					 + "\"addressCounty\" :\"addressCounty\","
					 +"\"addressCounty\" :\"addressCounty\","
					 +"\"addressCity\" : \"addressCity\","
					 +"\"addressCountryCode\" : \"US\""
					 +

					 "}" );
		
		Response response=CMDRequest.request(Method.POST);
		
		
		
		return response;
		
		
		
		
	}
	
	//** Constructor with Map as parameter
	public static Response CMD_POST(Map<String, String> map_CMDBUCreate ) {
		
			
		map_CMDBUCreate.forEach((String k, String v)-> {
			System.out.println("Key : "+k+ " Value :"+v);
			
			
		});
		
		
		        RestAssured.baseURI=map_CMDBUCreate.get("BaseURI");
		        			
				RequestSpecification CMDRequest=RestAssured.given();
				
				
				//*CMD POST headers
				CMDRequest.header("im_bu_id", map_CMDBUCreate.get("Header_im_bu_id"));
				CMDRequest.header("im_user_id", map_CMDBUCreate.get("Header_im_user_id"));
				CMDRequest.header("im_service_instance_id", map_CMDBUCreate.get("Header_im_service_instance_id"));
				CMDRequest.header("im_community_id", map_CMDBUCreate.get("Header_im_community_id"));
				CMDRequest.header("im_principal_type", map_CMDBUCreate.get("Header_im_principal_type"));
				CMDRequest.header("Content-Type", map_CMDBUCreate.get("Header_ContentType"));
				
								
				HashMap<String, String> cmdRequestBody= new HashMap<String, String>();
				cmdRequestBody.put("name", map_CMDBUCreate.get("B_name"));
				cmdRequestBody.put("addressCounty", map_CMDBUCreate.get("B_addressCounty"));
				cmdRequestBody.put("addressCity", map_CMDBUCreate.get("B_addressCity"));
				cmdRequestBody.put("addressCountryCode", map_CMDBUCreate.get("B_addressCountryCode"));

				//** checking request body parameter is null 
				if(map_CMDBUCreate.get("B_status")==null || map_CMDBUCreate.get("B_status").trim().isEmpty()) {
					cmdRequestBody.put("status", null);
				}else {
					cmdRequestBody.put("status", map_CMDBUCreate.get("B_status"));
					}
				
				//**B_currentLocale
				if(map_CMDBUCreate.get("B_currentLocale")==null || map_CMDBUCreate.get("B_currentLocale").trim().isEmpty()) {
					cmdRequestBody.put("currentLocale", null);
				}else {
					cmdRequestBody.put("currentLocale", map_CMDBUCreate.get("B_currentLocale"));
					}
				
				//**B_homeCurrency
				if(map_CMDBUCreate.get("B_homeCurrency")==null || map_CMDBUCreate.get("B_homeCurrency").trim().isEmpty()) {
					System.out.println("B_homeCurrency is null and in if condition");
					cmdRequestBody.put("homeCurrency", null);
				}else {
					cmdRequestBody.put("homeCurrency", map_CMDBUCreate.get("B_homeCurrency"));
					System.out.println("B_homeCurrency is not not null and in else condition");
				}
				
				//**B_naicsCodes
				if(map_CMDBUCreate.get("B_naicsCodes")==null || map_CMDBUCreate.get("B_naicsCodes").trim().isEmpty()) {
					System.out.println("B_naicsCodes is null and in if condition");
					cmdRequestBody.put("naicsCodes", null);
				}else {
					cmdRequestBody.put("naicsCodes", map_CMDBUCreate.get("B_naicsCodes"));
					System.out.println("B_naicsCodes is not not null and in else condition");
				}
				
				//**B_unspscCodes
				if(map_CMDBUCreate.get("B_unspscCodes")==null || map_CMDBUCreate.get("B_unspscCodes").trim().isEmpty()) {
					cmdRequestBody.put("unspscCodes", null);
				}else {
					cmdRequestBody.put("unspscCodes", map_CMDBUCreate.get("B_unspscCodes"));
					
				}
				
				//**B_unspscCodes
				if(map_CMDBUCreate.get("B_altCompanyNames")==null || map_CMDBUCreate.get("B_altCompanyNames").trim().isEmpty()) {
					
					cmdRequestBody.put("altCompanyNames", null);
				}else {
					cmdRequestBody.put("altCompanyNames", map_CMDBUCreate.get("B_altCompanyNames"));
					
				}
				
						
							
				System.out.println("display body param " + cmdRequestBody );			
				
				CMDRequest.body(cmdRequestBody);
				
							
				Response response=CMDRequest.request(Method.POST);
		
		
		return response;
		
		
	}
	
	
	//** Constructor with Map  and other parameters 
							
			public static Response CMD_POST(Map<String, String> map_CMDBUCreate,  String BaseURI ,String im_bu_id, String im_user_id, String im_service_instance_id , String im_community_id , String im_principal_type ,String ContentType  ){
					
			RestAssured.baseURI=BaseURI;
			
			RequestSpecification CMDRequest=RestAssured.given();
			
						
			//** Passing headers to the request body
			CMDRequest.header("im_bu_id", im_bu_id);					
			CMDRequest.header("im_user_id", im_user_id);
			CMDRequest.header("im_service_instance_id", im_service_instance_id);
			CMDRequest.header("im_community_id", im_community_id);
			CMDRequest.header("im_principal_type", im_principal_type);
			CMDRequest.header("Content-Type", ContentType);
			
			JSONObject jsonB=new JSONObject();
			
			JSONObject jsonBChild1=new JSONObject();
			JSONObject jsonBChild2=new JSONObject();
			
						
			//** Passing request body  
			
						
			String[] childParam_postalAddress= {"typeName","typeId","addressType","addressBuId","addressPostalAddress","addressPostalAddress1","addressPhoneNumber","addressFaxNumber","addressCounty","addressCity","addressState","addressPostalCode","addressCountryCode","creationDate","modifiedDate","uniqueId","addressFederativeUnitCode","addressMunicipalityCode","entityType"};
						
			map_CMDBUCreate.forEach((String k, String v)-> {
				
				if(Arrays.asList(childParam_postalAddress).contains(k)) {
					
					
					if (map_CMDBUCreate.get(k)==null || map_CMDBUCreate.get(k).trim().isEmpty()) {
						
						jsonBChild1.put(k,jsonBChild1.NULL);
						
					}else {
						
						if(k.equals("addressPostalAddress")) {
							JSONArray jsona= new JSONArray();
							
							
							jsona.put(v);
							
							jsonBChild1.put(k,jsona);
						} else {
					
					
					int size = childParam_postalAddress.length;
					
														
					jsonBChild1.put(k,v);
					
					
						}
				
					      }
									
				
					}
				  			
				
				else if (map_CMDBUCreate.get(k)==null || map_CMDBUCreate.get(k).trim().isEmpty()) {
					
					jsonB.put(k, jsonB.NULL);
										
				      } else {
					
					
						if (map_CMDBUCreate.get(k).contains("TRUE") || map_CMDBUCreate.get(k).contains("FALSE")) {	
						
						
						if (map_CMDBUCreate.get(k).contains("TRUE")) {
													
							jsonB.put(k, true);
							
						}else if (map_CMDBUCreate.get(k).contains("FALSE")) {
							
							jsonB.put(k, false);
										
						}
						}else if(k.equals("altCompanyNames")) {	
					
					
						JSONArray jArry= new JSONArray();
						jArry.put(v);
						jsonB.put(k,jArry);
						
						
						}else if(k.equals("participationType")) {
						
						JSONArray jArry= new JSONArray();
						jArry.put(v);
						jsonB.put(k,jArry);
						
						
						}else if(k.equals("taxIDNumbers")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("naicsCodes")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("unspscCodes")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("altCompanyNames")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("yearAndUSSales")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("salesCountries")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("invoiceCurrencies")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("billingIDs")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("buSicCodes")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}else if(k.equals("govClassification")) {
							
							JSONArray jArry= new JSONArray();
							jArry.put(v);
							jsonB.put(k,jArry);
														
						}
												
						else {
				
						jsonB.put(k,v);
						
						}
						
						//**assigning the child json to parent json
						jsonB.put("postalAddress",jsonBChild1);
						
				}
			
			});
			
												
									
						
				System.out.println("display body param " + jsonB );			
					
					
			    CMDRequest.contentType("application/json").log().all().body(jsonB.toString());
			
			
												
				Response response=CMDRequest.request(Method.POST);
			
			
				return response;
			
					
			
		}
	

}
