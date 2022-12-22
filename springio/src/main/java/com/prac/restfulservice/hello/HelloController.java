package com.prac.restfulservice.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(method = RequestMethod.GET,path = "/hello")
	public String HelloWorld() {
		return "welcome to java";
	}
	
	@GetMapping(path = "/hello-bean/{name}")
	public HellobeanController Hello(@PathVariable String name) {
		return new HellobeanController (String.format("Hello world,%s",name));
	}
}
