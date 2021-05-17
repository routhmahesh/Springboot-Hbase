package com.example.hbaseConnection;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;


public class HbaseConnection {
	
	static Connection con ;
	static Table table = null;

	public static  Configuration configuration = HBaseConfiguration.create();


	    public static Table getConnection(String tableName) throws Exception {
	     try {
	        configuration.set("hbase.zookeeper.quorum","localhost" );
	        configuration.set("hbase.property.clientPort","2181");
	     
	        Connection con = ConnectionFactory.createConnection(configuration);
	         table = con.getTable(TableName.valueOf(tableName));
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	    	 
	     }
	     
	        return table;
	    }

	}
    
   


