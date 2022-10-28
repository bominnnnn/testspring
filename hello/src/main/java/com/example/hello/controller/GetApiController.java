package com.example.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.UserRequest;

@RestController
@RequestMapping("/api/get") // GET , http://localhost:8080/api/get/hello
public class GetApiController {

	// @GetMapping("/hello")
	@GetMapping(path = "/hello") // @RequestMapping(path="/api/get/hello", method=RequestMethod.GET)
	public String getHello() {
		return "<h1>Hello SpringBoot</h1>";
	}

	@RequestMapping(path = "/hi", method = RequestMethod.GET)
	public String hi() { // http://localhost:8080/api/get/hi
		return "<font color='red'>hi~~~</font>";
	}

	// http://localhost:8080/api/get/path-varable/kingsmile
	// @GetMapping("/pathVarable") //cf) //
	// http://localhost:8080/api/get/pathVarable/kingsmile , 주소줄에는 대문자 안쓴다.
	@GetMapping("/path-varable/{id}") // 매번 주소가 변화 되는 내용 받겠다면 { } 변경될 내용 기재
	// public String pathVariable(@PathVariable String id) {
	public String pathVariable(@PathVariable(name = "id") String pathId) {
		System.out.println("PathVariable : " + pathId);
		return pathId;
	}

	@GetMapping(path = "query-param") // http://localhost:8080/api/get/query-param?user=yuna&email=kingsmile@naver.com&age=22
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		StringBuilder sb = new StringBuilder();
		queryParam.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());

			sb.append(entry.getKey() + "=" + entry.getValue());
		});

		return sb.toString();
	}

	@GetMapping(path = "query-param02") // http://localhost:8080/api/get/query-param02?name=yuna&email=kingsmile@naver.com&age=22
	public String queryParam02(@RequestParam String name, @RequestParam String email, @RequestParam String age

	) {

		System.out.println(name);
		System.out.println(email);
		System.out.println(age);

		return name + email + age;
	}
	@GetMapping(path = "query-param03")
	public String queryParam02(UserRequest userRequest) { http://localhost:8080/api/get/query-param02?name=yuna&email=kingsmile@naver.com&age=22
		System.out.println(userRequest.getName());
		System.out.println(userRequest.getEmail());
		System.out.println(userRequest.getAge());
		
		return userRequest.toString();
	}
}
