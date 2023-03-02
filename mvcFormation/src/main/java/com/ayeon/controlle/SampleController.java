package com.ayeon.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ayeon.domain.SampleDTO;

import lombok.extern.slf4j.Slf4j;
@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic................");
	}
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		
		log.info("basic......get.......");
	}
	
	@GetMapping("basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get......");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info("ex01-------dto : " + dto);
		
		return "ex01";
	}
	
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("------- name: " + name);
		log.info("------- age: " + age);
		return "ex02";

	}
}
