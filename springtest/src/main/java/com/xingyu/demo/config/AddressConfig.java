package com.xingyu.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xingyu.demo.pojo.Address;

//@Configuration
public class AddressConfig {

//	@Bean(name="address")
	public Address address() {
		return new Address();
	}
}
