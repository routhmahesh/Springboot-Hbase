package com.example.hbase.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.example.user.Employee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hbaseConnection.HbaseConnection;

@RestController
public class CourseDeletion {
	@SuppressWarnings("deprecation")
	@DeleteMapping("/delete")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void register(@RequestBody Employee empl) throws Exception { 
		
				
		//JSONArray json1 = new JSONArray() ;
	
	Table table = HbaseConnection.getConnection("employee");
	byte[] row1 = Bytes.toBytes(empl.getEmpid());
	
	Delete delete = new Delete(row1);
	delete.addColumn(Bytes.toBytes("e"), Bytes.toBytes("name"));
	delete.addColumn(Bytes.toBytes("e"), Bytes.toBytes("place"));
	table.delete(delete);

	
		System.out.println("row2 branch 02"+row1);
}}
