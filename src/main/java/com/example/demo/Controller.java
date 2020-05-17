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
	public String who(HttpServletRequest request) {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String pattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		pattern.replaceFirst("\\*\\*", "");
		return path.substring(path.indexOf(pattern) + pattern.length() - 1);
	}
}
