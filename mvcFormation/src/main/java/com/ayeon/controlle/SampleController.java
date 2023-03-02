package com.ayeon.controlle;

import java.net.http.HttpHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayeon.domain.SampleDTO;
import com.ayeon.domain.SampleDTOList;
import com.ayeon.domain.TodoDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//
//	}

	@RequestMapping("")
	public void basic() {
		log.info("basic................");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
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

	// 리스트 처리
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

		log.info("ids: " + ids);

		return "ex02List";

	}

	@GetMapping("ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {

		log.info("ids: " + Arrays.toString(ids));

		return "ex02Array";
	}

	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos ------------------ " + list);

		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("dto-----------------" + todo);
		
		return "ex03";
		
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page ) {
		
		log.info("dto: --------- " + dto );
		log.info("page: " + page);
		
		return "/sample/ex04";
		
	}
	
	//Controller 메서드의 리턴타입 : void
	@GetMapping("/ex05")
	public void ex05() {
		log.info("..................ex05");
	}

	//객체타입
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06....................");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("namAyeon");
		return dto;
				
	}
	
	public ResponseEntity<String> ex07(){
		log.info("ex07..........................");
		
		String msg = "{\"name\": \"홍길동\"}";
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
			
	}
	
	
}
