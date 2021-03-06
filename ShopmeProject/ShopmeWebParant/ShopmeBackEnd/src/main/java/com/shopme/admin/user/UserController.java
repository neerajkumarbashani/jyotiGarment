package com.shopme.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.webjars.NotFoundException;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserService service;

//	@Autowired
//	UserCsvExporter exporter;
//	
	@GetMapping("/users")
	public String getList(Model model) {

		List<User> list = service.getData();
		model.addAttribute("userlist", list);
		return "users";
	}

	@GetMapping("users/new")
	public String newUser(Model model) {

		List<Role> role = service.getRole();
		User user = new User();
		user.setEnabled(true);
		model.addAttribute("user", user);
		model.addAttribute("role", role);

		return "users_form";
	}

	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes redirectrar) {
		System.out.print(user);

		service.saveData(user);
		redirectrar.addFlashAttribute("meg", "user has been saved successfully");
		return "redirect:/users";
	}

	@GetMapping("/users/export/csv")
	public void exportCsv(HttpServletResponse response) throws IOException {

		List<User> list = service.getData();

		UserCsvExporter csvexpoerter = new UserCsvExporter();

		csvexpoerter.export(list, response);
	}

	@GetMapping("/user/delete/{id}")
	public String deletebyid(@PathVariable("id") Integer id, RedirectAttributes redirectrar, Model model) {

		try {

			service.deleteUserbyid(id);
			redirectrar.addFlashAttribute("msg", "");
		} catch (NotFoundException e) {
			redirectrar.addFlashAttribute("msg", "");

		}

		return "redirect:/users";
	}

	@GetMapping("/user/edit/{id}")
	public String editbyid(@PathVariable("id") Integer id, RedirectAttributes redirectrar, Model model) {

		try {
User user=service.getUser(id);

model.addAttribute(user);
return "users_form";
		} catch (NotFoundException e) {
			redirectrar.addFlashAttribute("msg", "");
			return "redirect:/users";

		}

	}

}
