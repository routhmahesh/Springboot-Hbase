package com.example.hbase.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.example.user.Employee;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hbaseConnection.HbaseConnection;

@RestController
public class CourseRegistration {
	
	@SuppressWarnings("deprecation")
	@PostMapping("/register")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void register(@RequestBody Employee empl) throws Exception { 
		
				
		//JSONArray json1 = new JSONArray() ;
	
	Table table = HbaseConnection.getConnection("employee");
	byte[] row1 = Bytes.toBytes(empl.getEmpid());
			Put p = new Put(row1);
			p.addImmutable(Bytes.toBytes("e"), Bytes.toBytes("name"), Bytes.toBytes(empl.getEmpname()));
			p.addImmutable(Bytes.toBytes("e"), Bytes.toBytes("place"), Bytes.toBytes(empl.getPlace()));
			table.put(p);
	
		System.out.println(p);
	}
	
	
	}

