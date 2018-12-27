package com.xingyu.demo.dao.strategy;

import com.google.code.shardbatis.strategy.ShardStrategy;

public class UserShardStrategyImpl implements ShardStrategy{

	public final static int tableCount = 5;
	
	public String getTargetTableName(String baseTableName, Object params, String mapperId) {
		
		return "user_01";
	}

}
