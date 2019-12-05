package com.springboot.services.producer.jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	    
		@RequestMapping("/get-userinfo")
		public String home(@RequestParam long id) {
			System.out.println(id);
			return "get-userinfo---userid--->"+id;
		}
		
		@RequestMapping("/test-two")
		public String hometwo(@RequestParam String name) {
//			System.out.println(port);
			return "test-two "+name;
		}	
}
