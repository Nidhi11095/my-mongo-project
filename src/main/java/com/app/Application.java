package com.app;

import com.cache.CacheMain;
import com.db.DbMain;

import redis.clients.jedis.exceptions.JedisConnectionException;


public class Application {
	
	public static void main(String[] args) {
		
		try {
			
			DbMain.getDbClient();
			
		} catch(Exception e) {
			
			System.out.println("db client not created : " + e.getMessage());
			
			return;
		}
		
		try {
			CacheMain.getCacheClient();
			
		} catch(Exception e) {
			
			System.out.println("redis client not created : " + e.getMessage());
			
			return;
		}
		
		
		
		
	}

}
