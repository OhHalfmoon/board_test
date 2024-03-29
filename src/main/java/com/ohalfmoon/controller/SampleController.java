package com.ohalfmoon.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ohalfmoon.domain.SampleDTO;
import com.ohalfmoon.domain.SampleDTOList;
import com.ohalfmoon.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {	
		
		@RequestMapping("")
		public void baisic() {
			log.info("basic.......................");
		}
		
		// RequestMapping의 변화
		@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
		public void basicGet() {
			log.info("baisc get..................");
		}
		
		// RequestMapping 대신 GetMapping 사용
		@GetMapping("/basicOnlyGet")
		public void basicGet2() {
			log.info("basic get only get.......................");
		}
		
		// Controller 파라미터 수집
		@GetMapping("/ex01")
		public String ex01(SampleDTO dto) {
			log.info("" + dto);
			return "ex01";
		}
		
		//파라미터의 수집과 반환
		@GetMapping("/ex02")
		public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
			log.info("name" + name);
			log.info("age" + age);
			return "ex02";
		}
		
		// 리스트 처리
		@GetMapping("/ex02List")
		public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
			log.info("ids: " + ids);
			return "ex02List";
		}
		
		// 배열처리
		@GetMapping("/ex02Array")
		public String ex02Array(@RequestParam("ids") String[] ids) {
			log.info("array ids: " + Arrays.toString(ids));
			return "ex02Array";
		}
		
		// 객체 리스트
		@GetMapping("/ex02Bean")
		public String ex02Bean(SampleDTOList list) {
			log.info("list dtos: " + list);
			return "ex02Bean";
		}
		
		
		//InitBinder (파라미터의 수집/바인딩)
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
		}
		
		@GetMapping("/ex03")
		public String ex03(TodoDTO todo) {
			log.info("todo: " + todo);
			return "ex03";
		}
		
		// @ModelAttribute 실습
		@GetMapping("/ex04")
		public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
			log.info("dto: " + dto);
			log.info("page: " + page);
			return "/sample/ex04";
		}
		
		// Controller의 리턴타입
		//void : 일반적인 경우에는 해당 URL의 경로를 그대로 JSP 파일의 이름으로 사용
		@GetMapping("/ex05")
		public void ex05() {
			log.info("/ex05...........");
		}
		
		//객체타입 -> 스프링MVC는 자동으로 브라우저에 JSON 타입으로 객체를 변환해서 전달
		@GetMapping("/ex06")
		public @ResponseBody SampleDTO ex06() {
			log.info("/ex06...........");
			SampleDTO dto = new SampleDTO();
			dto.setAge(10);
			dto.setName("홍길동");
			
			return dto;
		}		
		
		//ResponseEntity 타입
		@GetMapping("/ex07")
		public ResponseEntity<String> ex07() {
			log.info("/ex07...........");
			
			//{"name": 홍길동}
			String msg = "{\"name\": \"홍길동\"}";
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "application/json;charset=UTF-8");
						
			return new ResponseEntity<>(msg, header, HttpStatus.OK);
		}
		
		//FileUpload테스트
		@GetMapping("/exUpload")
		public void exUpload() {
			log.info("/exUpload...............");
		}
		
		@PostMapping("/exUploadPost")
		public void exUploadPost(ArrayList<MultipartFile> files) {
			
			files.forEach(file -> {
				log.info("---------------------------");
				log.info("name: " + file.getOriginalFilename());
				log.info("size: " + file.getSize());
			});
		}
		
/*		@GetMapping("/all")
		public void doAll() {
			log.info(" all can access ");
		}
		
		@GetMapping("/member")
		public void doMember() {
			log.info("logined member");
		}
		
		@GetMapping("/admin")
		public void doAdmin() {
			log.info("admin only");
		}*/
}
