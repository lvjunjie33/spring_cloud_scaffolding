package com.springboot.services.producer.rest;

import com.springboot.cloud.common.core.entity.vo.Result;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

@RestController
@RefreshScope
public class HelloController {
//	@Value("${spring.aa}")
//	String port;

    @RequestMapping(method = RequestMethod.GET, value = "/hello/{name}")
    public String hello(@PathVariable String name) {
        return randomNumeric(2) + name;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public Result world(@RequestParam String name) {
    	return Result.success("name--->"+name);
//        return Result.success("name--->"+name+"port--->"+port);
    }
}