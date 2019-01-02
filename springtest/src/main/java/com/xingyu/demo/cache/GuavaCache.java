package com.xingyu.demo.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

public class GuavaCache {
	
//	@Autowired
//	static UserCacheLoader userCacheLoader;

//	public static LoadingCache<Object, Object> getLoadingCache() {
//		LoadingCache<Object, Object> cache = CacheBuilder.newBuilder()
//				.maximumSize(100)
//				.expireAfterAccess(30, TimeUnit.DAYS)
//				.recordStats()
//				.build(userCacheLoader);
//		
//		return cache;
//	}
	
}
