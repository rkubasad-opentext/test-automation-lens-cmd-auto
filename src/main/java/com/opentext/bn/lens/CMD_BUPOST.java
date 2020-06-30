package com.opentext.bn.lens;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CMD_BUPOST {
	

	
	public static Response CMD_BUPOST(String Baseurl) {
		
		
		//RestAssured.baseURI=BASEURI;
		RestAssured.baseURI="http://qtotcra.qa.gxsonline.net:8080/communitymasterdata/rest/v1/businessUnits";
		
		RequestSpecification CMDRequest=RestAssured.given();
		
		
		//*CMD POST headers
		//serviceRequest.header("im_bu_id",H_im_bu_id);
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
	public static Response CMD_BUPOST(Map<String, String> map_CMDBUCreate ) {
		
		/*
		for (String k: map_CMDBUCreate.keySet()) {
			String abc=map_CMDBUCreate.get(k);
			
			System.out.println("foreach string " + abc);
			if (map_CMDBUCreate.get(k)==null || map_CMDBUCreate.get(k).trim().isEmpty()) {
				//cmdRequestBody.put("currentLocale", null);	
				//map_CMDBUCreate.
			}
			
			
		}
		*/
		
		map_CMDBUCreate.forEach((String k, String v)-> {
			System.out.println("Key : "+k+ " Value :"+v);
			
			
		});
		
		
		//RestAssured.baseURI=BASEURI;
				//RestAssured.baseURI="http://qtotcra.qa.gxsonline.net:8080/communitymasterdata/rest/v1/businessUnits";
		        RestAssured.baseURI=map_CMDBUCreate.get("BaseURI");
		        //System.out.println(" Baseurl from xls is "+ RestAssured.baseURI);
				
				RequestSpecification CMDRequest=RestAssured.given();
				
				
				//*CMD POST headers
				//serviceRequest.header("im_bu_id",H_im_bu_id);
				CMDRequest.header("im_bu_id", map_CMDBUCreate.get("Header_im_bu_id"));
				CMDRequest.header("im_user_id", map_CMDBUCreate.get("Header_im_user_id"));
				CMDRequest.header("im_service_instance_id", map_CMDBUCreate.get("Header_im_service_instance_id"));
				CMDRequest.header("im_community_id", map_CMDBUCreate.get("Header_im_community_id"));
				CMDRequest.header("im_principal_type", map_CMDBUCreate.get("Header_im_principal_type"));
				CMDRequest.header("Content-Type", map_CMDBUCreate.get("Header_ContentType"));
				
				//System.out.println("reading from xls contenttype frop post  : "  + map_CMDBUCreate.get("Header_ContentType") );
				
				/*
				CMDRequest.header("im_bu_id","GCIMCO235HE");
				CMDRequest.header("im_user_id","GCP0P4919B8I2");
				CMDRequest.header("im_service_instance_id","594101");
				CMDRequest.header("im_community_id","IM_COMM");
				CMDRequest.header("im_principal_type","USER_SESSION");
				CMDRequest.header("Content-Type","application/json");
				*/
				
				//*CMD Request BODY
				
				HashMap<String, String> cmdRequestBody= new HashMap<String, String>();
				cmdRequestBody.put("name", map_CMDBUCreate.get("B_name"));
				cmdRequestBody.put("addressCounty", map_CMDBUCreate.get("B_addressCounty"));
				cmdRequestBody.put("addressCity", map_CMDBUCreate.get("B_addressCity"));
				cmdRequestBody.put("addressCountryCode", map_CMDBUCreate.get("B_addressCountryCode"));

				//** checking request body parameter is null 
				if(map_CMDBUCreate.get("B_status")==null || map_CMDBUCreate.get("B_status").trim().isEmpty()) {
					//System.out.println("B_status is null and in if condition");
					cmdRequestBody.put("status", null);
				}else {
					cmdRequestBody.put("status", map_CMDBUCreate.get("B_status"));
					//System.out.println("B_status is not not null and in else condition");
				}
				
				//**B_currentLocale
				if(map_CMDBUCreate.get("B_currentLocale")==null || map_CMDBUCreate.get("B_currentLocale").trim().isEmpty()) {
					//System.out.println("B_currentLocale is null and in if condition");
					cmdRequestBody.put("currentLocale", null);
				}else {
					cmdRequestBody.put("currentLocale", map_CMDBUCreate.get("B_currentLocale"));
					//System.out.println("B_currentLocale is not not null and in else condition");
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
					//System.out.println("B_unspscCodes is null and in if condition");
					cmdRequestBody.put("unspscCodes", null);
				}else {
					cmdRequestBody.put("unspscCodes", map_CMDBUCreate.get("B_unspscCodes"));
					//System.out.println("B_unspscCodes is not not null and in else condition");
				}
				
				//**B_unspscCodes
				if(map_CMDBUCreate.get("B_altCompanyNames")==null || map_CMDBUCreate.get("B_altCompanyNames").trim().isEmpty()) {
					//System.out.println("B_altCompanyNames is null and in if condition");
					cmdRequestBody.put("altCompanyNames", null);
				}else {
					cmdRequestBody.put("altCompanyNames", map_CMDBUCreate.get("B_altCompanyNames"));
					//System.out.println("B_altCompanyNames is not not null and in else condition");
				}
				
				
				
				
				//cmdRequestBody.put("status", map_CMDBUCreate.get("B_status"));
					
				System.out.println("display body param " + cmdRequestBody );			
				
				CMDRequest.body(cmdRequestBody);
				
							
				
				Response response=CMDRequest.request(Method.POST);
		
		
		return response;
		
		
	}
	
	
	//** Constructor with Map  and other parameters 
		public static Response CMD_BUPOST(Map<String, String> map_CMDBUCreate, String header ) {
			
			/*
			for (String k: map_CMDBUCreate.keySet()) {
				String abc=map_CMDBUCreate.get(k);
				
				System.out.println("foreach string " + abc);
				if (map_CMDBUCreate.get(k)==null || map_CMDBUCreate.get(k).trim().isEmpty()) {
					//cmdRequestBody.put("currentLocale", null);	
					//map_CMDBUCreate.
				}
				
				
			}
			*/
			
			map_CMDBUCreate.forEach((String k, String v)-> {
				System.out.println("Key : "+k+ " Value :"+v);
				
				
			});
			
			
			//RestAssured.baseURI=BASEURI;
					//RestAssured.baseURI="http://qtotcra.qa.gxsonline.net:8080/communitymasterdata/rest/v1/businessUnits";
			        RestAssured.baseURI=map_CMDBUCreate.get("BaseURI");
			        //System.out.println(" Baseurl from xls is "+ RestAssured.baseURI);
					
					RequestSpecification CMDRequest=RestAssured.given();
					
					
					//*CMD POST headers
					//serviceRequest.header("im_bu_id",H_im_bu_id);
					CMDRequest.header("im_bu_id", map_CMDBUCreate.get("Header_im_bu_id"));
					CMDRequest.header("im_user_id", map_CMDBUCreate.get("Header_im_user_id"));
					CMDRequest.header("im_service_instance_id", map_CMDBUCreate.get("Header_im_service_instance_id"));
					CMDRequest.header("im_community_id", map_CMDBUCreate.get("Header_im_community_id"));
					CMDRequest.header("im_principal_type", map_CMDBUCreate.get("Header_im_principal_type"));
					CMDRequest.header("Content-Type", map_CMDBUCreate.get("Header_ContentType"));
					
					//System.out.println("reading from xls contenttype frop post  : "  + map_CMDBUCreate.get("Header_ContentType") );
					
					/*
					CMDRequest.header("im_bu_id","GCIMCO235HE");
					CMDRequest.header("im_user_id","GCP0P4919B8I2");
					CMDRequest.header("im_service_instance_id","594101");
					CMDRequest.header("im_community_id","IM_COMM");
					CMDRequest.header("im_principal_type","USER_SESSION");
					CMDRequest.header("Content-Type","application/json");
					*/
					
					//*CMD Request BODY
					
					HashMap<String, String> cmdRequestBody= new HashMap<String, String>();
					cmdRequestBody.put("name", map_CMDBUCreate.get("B_name"));
					cmdRequestBody.put("addressCounty", map_CMDBUCreate.get("B_addressCounty"));
					cmdRequestBody.put("addressCity", map_CMDBUCreate.get("B_addressCity"));
					cmdRequestBody.put("addressCountryCode", map_CMDBUCreate.get("B_addressCountryCode"));

					//** checking request body parameter is null 
					if(map_CMDBUCreate.get("B_status")==null || map_CMDBUCreate.get("B_status").trim().isEmpty()) {
						//System.out.println("B_status is null and in if condition");
						cmdRequestBody.put("status", null);
					}else {
						cmdRequestBody.put("status", map_CMDBUCreate.get("B_status"));
						//System.out.println("B_status is not not null and in else condition");
					}
					
					//**B_currentLocale
					if(map_CMDBUCreate.get("B_currentLocale")==null || map_CMDBUCreate.get("B_currentLocale").trim().isEmpty()) {
						//System.out.println("B_currentLocale is null and in if condition");
						cmdRequestBody.put("currentLocale", null);
					}else {
						cmdRequestBody.put("currentLocale", map_CMDBUCreate.get("B_currentLocale"));
						//System.out.println("B_currentLocale is not not null and in else condition");
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
						//System.out.println("B_unspscCodes is null and in if condition");
						cmdRequestBody.put("unspscCodes", null);
					}else {
						cmdRequestBody.put("unspscCodes", map_CMDBUCreate.get("B_unspscCodes"));
						//System.out.println("B_unspscCodes is not not null and in else condition");
					}
					
					//**B_unspscCodes
					if(map_CMDBUCreate.get("B_altCompanyNames")==null || map_CMDBUCreate.get("B_altCompanyNames").trim().isEmpty()) {
						//System.out.println("B_altCompanyNames is null and in if condition");
						cmdRequestBody.put("altCompanyNames", null);
					}else {
						cmdRequestBody.put("altCompanyNames", map_CMDBUCreate.get("B_altCompanyNames"));
						//System.out.println("B_altCompanyNames is not not null and in else condition");
					}
					
					
					
					
					//cmdRequestBody.put("status", map_CMDBUCreate.get("B_status"));
						
					System.out.println("display body param " + cmdRequestBody );			
					
					CMDRequest.body(cmdRequestBody);
					
								
					
					Response response=CMDRequest.request(Method.POST);
			
			
			return response;
			
			
		}
	



}
