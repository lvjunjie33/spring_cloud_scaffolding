package com.springboot.services.producer.hystrix;

import org.springframework.stereotype.Component;

import com.springboot.services.producer.service.IFooService;

@Component
public class FooHystrix implements IFooService{

	@Override
	public String get(long id) {
		// TODO Auto-generated method stub
		return "sorry "+id;
	}

}
