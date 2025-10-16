package com.db;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

public final class DbMain {
	
	private static volatile MongoClient mongoClient;
	
	private DbMain() {
		
	}

	public static MongoClient getDbClient() {
		
		if(mongoClient == null) {
			
			synchronized(DbMain.class) {
				
				if(mongoClient == null) {
					mongoClient = MongoClients.create(Utils.uri);
				}
			}
		}
		
		return mongoClient;
	}
	
	

}
