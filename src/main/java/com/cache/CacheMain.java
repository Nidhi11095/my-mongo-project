package com.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public final class CacheMain {
	
	private static volatile JedisPool pool;
	
	
	private CacheMain() {
		
	}
	
	public static Jedis getCacheClient() {
		
		if(pool == null) {
			
			synchronized(CacheMain.class) {
				if(pool == null) {
					pool = new JedisPool(Utils.uri, Utils.port);
				}
			}
			
		}

		try {
            return pool.getResource();
            
        } catch (Exception e) {
        	
            System.err.println("Failed to get Redis client: " + e.getMessage());
            
            return null;
        }
		
	}
	
	
	

}
