package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.entities.User;

@Controller
public class UserController {

	@RequestMapping(value = "/addUser",method = RequestMethod.GET)
	public String doGetAddUser(@ModelAttribute(value = "user") User user) {
		return "addUser";
	}
	
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	public String doPostAddUser(@ModelAttribute(value = "user") @Validated User user) {
		return "view-user";
	}
}
