package com.springboot.services.producer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.services.producer.hystrix.FooHystrix;

@FeignClient(value = "producer-jpa",fallback = FooHystrix.class)
public interface IFooService {
    /**
     * 获取用户
     *
     * @param id
     * @return
     */
	@RequestMapping(value = "/get-userinfo",method = RequestMethod.GET)
    String get(@RequestParam(value = "id") long id);
}
