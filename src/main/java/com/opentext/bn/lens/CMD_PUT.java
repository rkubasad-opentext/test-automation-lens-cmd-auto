package com.opentext.bn.lens;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CMD_PUT {
	
	

		public static Response CMD_PUT(Map<String, String> map_CMDBUCreate ) {
		
				
		//RestAssured.baseURI=BASEURI;
				//RestAssured.baseURI="http://qtotcra.qa.gxsonline.net:8080/communitymasterdata/rest/v1/businessUnits";
		        RestAssured.baseURI=map_CMDBUCreate.get("BaseURI");
		        System.out.println(" Baseurl from xls is "+ RestAssured.baseURI);
				
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
				cmdRequestBody.put("status", map_CMDBUCreate.get("B_status"));
				
				/*
				
				cmdRequestBody.put("addressCounty", map_CMDBUCreate.get("B_addressCounty"));
				cmdRequestBody.put("addressCity", map_CMDBUCreate.get("B_addressCity"));
				cmdRequestBody.put("addressCountryCode", map_CMDBUCreate.get("B_addressCountryCode"));
				
				*/
					
				System.out.println("display body param " + cmdRequestBody );			
				
				CMDRequest.body(cmdRequestBody);
				
							
				
				Response response=CMDRequest.request(Method.PUT);
				
				System.out.println("CMD put request is success ");
		
		
		return response;
		
		
	}
	



}
