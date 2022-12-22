package com.prac.restfulservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 fetPerson() {
		return new PersonV1("Bob");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 fetPersonv2() {
		return new PersonV2(new Name("Nirmal", "Ragavan"));
	}
	

	@GetMapping(path = "/person",params = "version=1")
	public PersonV1 fetPersonrequestparam() {
		return new PersonV1("Bob");
	}
	
	@GetMapping(path = "/person",params = "version=2")
	public PersonV2 fetPersonv2requestparam() {
		return new PersonV2(new Name("Nirmal", "Ragavan"));
	}
	
	@GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
	public PersonV1 fetPersonrequestheader() {
		return new PersonV1("Bob");
	}
	
	@GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
	public PersonV2 fetPersonv2requestheader() {
		return new PersonV2(new Name("Nirmal", "Ragavan"));
	}
	
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")
	public PersonV1 fetPersonrequestcompany() {
		return new PersonV1("Bob");
	}
	
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v2+json")
	public PersonV2 fetPersonv2requestcompany() {
		return new PersonV2(new Name("Nirmal", "Ragavan"));
	}
}
