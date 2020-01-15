package com.in28minutes.rest.webservices.restfulwebservices.helloword;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class HelloWordController {
	
	@Autowired
	private MessageSource pesanSource; //messageSource: a programmatically registered singleton, so nama method di service adlh "messageSource"
	
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
	
	@GetMapping(path = "/helloWord-internalizationalized")
	public String helloWordInternalizationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return pesanSource.getMessage("good.morning.message",null, locale);
	}

}
