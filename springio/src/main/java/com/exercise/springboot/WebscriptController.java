package com.exercise.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebscriptController {

	@Autowired
	private webscriptClass webscript;
	
	@RequestMapping("/web")
	public webscriptClass web() {
		return webscript;
	}
}
