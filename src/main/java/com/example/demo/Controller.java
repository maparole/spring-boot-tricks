package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;


// mvn spring-boot:
@RestController
@RequestMapping("/hello")
public class Controller {
	
	@GetMapping("/whos/**")
	public String who(HttpServletRequest request) throws Exception {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String pattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		pattern.replaceFirst("\\*\\*", "");
		String response = path.substring(path.indexOf(pattern) + pattern.length() - 1);
		if (response.contains("list"))
			throw new IllegalAccessException("YOOOO");
		return response;
	}
}
