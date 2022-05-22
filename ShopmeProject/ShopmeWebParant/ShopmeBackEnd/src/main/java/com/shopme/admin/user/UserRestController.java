package com.shopme.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@Autowired
	private UserService service;
	
	@PostMapping("/user/user_email")
public String isEmailUnique(@Param("email") String email) {
		System.out.println(email+"   "+service.emailUnique(email));
		return service.emailUnique(email) ? "ok" :"duplicated";
}
}
