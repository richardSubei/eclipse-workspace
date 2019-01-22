package com.xingyu.demo.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheTest {

	public static void main(String[] args) throws ExecutionException {
		LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
				.maximumSize(100)
				.expireAfterAccess(100, TimeUnit.SECONDS)
				.build(new CacheLoader<Integer, String>() {

					@Override
					public String load(Integer key) throws Exception {
						System.out.println("第一次获取先加载");
						return "1";
						
					}
					
				});
		
		cache.get(1);
		
		cache.get(1);
		
		cache.get(1);
		
		System.out.println(cache.asMap());
		
	}
	
}
