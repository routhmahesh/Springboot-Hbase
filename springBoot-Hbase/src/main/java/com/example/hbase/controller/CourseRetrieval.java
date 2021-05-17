package com.example.hbase.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.example.user.EmpId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hbaseConnection.HbaseConnection;



@RestController
public class CourseRetrieval {
  
	
	
	
	
	@GetMapping("/employees")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ResponseEntity retrieveAll() throws Exception { 
		
				
		JSONArray json1 = new JSONArray() ;
	
	Table table = HbaseConnection.getConnection("employee");
	
	Scan scan = new Scan();
	
	ResultScanner scan1 = table.getScanner(scan);
	
	for(Result res:scan1 ) {
		
		JSONObject obj = new JSONObject();
		
		String empid = (Bytes.toString(res.getRow()));
		obj.put("empid",empid);
		String empname = (Bytes.toString(res.getValue("e".getBytes(),"name".getBytes())));
		obj.put("empname",empname);
		String place =(Bytes.toString(res.getValue(Bytes.toBytes("e"),Bytes.toBytes("place"))));
		obj.put("place",place);
		
		json1.put(obj);
		System.out.println(empid+empname+place);
	}
	
	
	System.out.println(json1.toString());
	
	return new ResponseEntity(json1.toString(),HttpStatus.CREATED);

	
	}
	

	
	@PostMapping("/employee")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ResponseEntity retrieve(@RequestBody EmpId emplId)throws Exception { 
		JSONObject obj = new JSONObject();
		
		String emplid = emplId.getEmpid();
		System.out.println(emplid);
		Table table = HbaseConnection.getConnection("employee");			
		
		Get g = new Get(Bytes.toBytes(emplid));
		Result res = table.get(g);
		System.out.println(res);
		
		String empid = (Bytes.toString(res.getRow()));
		obj.put("empid",empid);
		String empname = (Bytes.toString(res.getValue("e".getBytes(),"name".getBytes())));
		obj.put("empname",empname);
		String place =(Bytes.toString(res.getValue(Bytes.toBytes("e"),Bytes.toBytes("place"))));
		obj.put("place",place);
		
	
	System.out.println(obj);
	
	return new ResponseEntity(obj.toString(),HttpStatus.CREATED);

	
	}
	
}
