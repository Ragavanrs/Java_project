package com.example.TEST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class Webapp {

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
}
