package com.opentext.bn.lens.cmd;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opentext.bn.core.Datatable;
import com.opentext.bn.lens.CMD_POST;
import com.opentext.bn.lens.CMD_PUT;

import io.restassured.response.Response;

public class CMD_BUUpdate {
	
	

	
	static String BaseDir = "C:\\Eclipse_workspace\\cmd_auto\\Files\\";
	
	public static String ENV;
	public static String NODE;
	public static String BaseURI;
	public static String UserName;
	public static String Password;
	//public static String InputFile;
	
	public static String RUNNABLE;
	public static String TestCaseId;
	public static String Scenario;
	public static String Header_im_bu_id;
	public static String Header_im_user_id;
	public static String Header_im_service_instance_id;
	public static String Header_im_community_id;
	public static String Header_im_principal_type;
	public static String Header_ContentType;
	public static String B_name;
	public static String B_addressCounty;
	public static String B_addressCity;
	public static String B_addressCountryCode;
	public static String B_status;
	
	
				
	
	@Test
	public void CMD() throws ClassNotFoundException, InterruptedException, IOException  {
		
		
		
		Datatable dt= new Datatable(BaseDir+"CMDUpdate_TestData.xlsx", "Sheet1");
		
		List<Map<String, String>> TDMap =dt.getColumnAndRowsAsMap();
		
		
		{
			for (int i = 0 ; i < TDMap.size() ; i++) {
				Map<String, String> myMap = TDMap.get(i);         

				RUNNABLE = myMap.get("RUNNABLE").toString();
				TestCaseId = myMap.get("TestCaseId").toString();
				Scenario = myMap.get("Scenario").toString();
				BaseURI = myMap.get("BaseURI").toString();
				
				//**Modifying the baseURI for adding buid 
				//BaseURI=BaseURI+"/"+buid;
				BaseURI=BaseURI+"/"+"GC131053622407";

				//Passing the modified Baseruri
				BaseURI=myMap.put("BaseURI",BaseURI);
				
				Header_im_bu_id = myMap.get("Header_im_bu_id").toString();
				Header_im_user_id = myMap.get("Header_im_user_id").toString();
				Header_im_service_instance_id = myMap.get("Header_im_service_instance_id").toString();
				Header_im_community_id = myMap.get("Header_im_community_id").toString();
				Header_im_principal_type = myMap.get("Header_im_principal_type").toString();
				Header_ContentType = myMap.get("Header_ContentType").toString();
				B_name = myMap.get("B_name").toString();
				B_addressCounty = myMap.get("B_addressCounty").toString();
				B_addressCity = myMap.get("B_addressCity").toString();
				B_addressCountryCode = myMap.get("B_addressCountryCode").toString();
				B_status = myMap.get("B_status").toString();
				
				//System.out.println("reading from xls : "  + Header_ContentType );
				
				
				if (RUNNABLE.equalsIgnoreCase("YES")){
			
		
		
					Response abc= CMD_PUT.CMD_PUT(myMap);
					//String location=abc.getHeaders("Location");
					//String body=abc.body();
					//System.out.println(abc);
		
					int status_code=abc.getStatusCode();
					System.out.println("CMD POST response for BU CREATE " + status_code);
					
					Assert.assertEquals(200 , status_code);
					
						
					//String location= abc.getHeader("Location");
					
					//System.out.println("Location Header - " + location  );
					
					
									
					//ResponseBody body_userid=abc.body();
					//System.out.println("Response Body - " + body_userid  );
					
					String buid="GC131053622407";
					
					String lens_buid="TG16-DEV-"+buid;
					
					//**Querying Lens DB
					//String sqlQuery="select name from public.organization where orgid ='"+ lens_buid +"'";
					String sqlQuery="select name from public.organization where orgid = '"+ lens_buid+ "'";
					
					//sqlQuery=sqlQuery.trim();
					
					System.out.println("sqlquery is  "+sqlQuery);
					
					//String sqlQuery="select name from public.organization where orgid = 'TG16-DEV-GC131049064832'";
					
					 
					
					
					Postgres_Connection_lens Postgres_con=new Postgres_Connection_lens();
					List<String> queryresult = null;
					//List<String> queryresult1 = null;
					try {
						System.out.println("inside try block ");
						queryresult = Postgres_con.getDataFromDataBase(sqlQuery, "name");
						System.out.println("org name = "  + queryresult);
						System.out.println("end try block " );
						//queryresult1 = Postgres_con.getDataFromDataBase(sqlQuery1, "POLICY_TYPE");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//String s_status = queryresult.toString();
					System.out.println("org name  "+ queryresult);
					
					
					
					
					
					
					
					
	
	}
		
	}		



}
}
}
