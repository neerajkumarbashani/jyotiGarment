package com.shopme.admin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MianController {
	@GetMapping("")
	public String viewHomepage() {
		
		
		return "index";
	}
	@GetMapping("/login")
	public String viewLoginpage() {
		
		
		return "login";
	}
}
