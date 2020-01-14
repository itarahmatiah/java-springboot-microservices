package com.in28minutes.rest.webservices.restfulwebservices.helloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWordController {
	
	//method: "Hello Word"
	//GET
	//URI: /helloWord
	@GetMapping(path = "/helloWord")
	public String helloWord() {
		return "Hellowwff Word";
	}
	
	//URI: helloWord-bean
	@GetMapping(path = "/helloWord-bean")
	public HelloWordBean helloWordBean() {
		return new HelloWordBean("Hello Word");
	}
	
	// URI: /helloWord-path/in28minutes
	@GetMapping(path = "/helloWord-path/{name}")
	public HelloWordBean helloWordPath(@PathVariable String name) {
		return new HelloWordBean(String.format("Hello Word, %s", name));
	}

}
