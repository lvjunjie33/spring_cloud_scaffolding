package com.springboot.services.producer.rest;

import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.services.producer.service.IFooService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

@RestController
public class FooController {
	@Autowired
	IFooService fooService;
	
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public Result findById(@PathVariable long id) {
    	 System.out.println(id);
         return Result.success(fooService.get(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public String deleteById(@PathVariable long id) {
        return randomNumeric(2) + id;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public String update(@PathVariable long id) {
        return randomNumeric(2) + id;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/{id}")
    public String add(@PathVariable long id) {
        return randomNumeric(2) + id;
    }
}