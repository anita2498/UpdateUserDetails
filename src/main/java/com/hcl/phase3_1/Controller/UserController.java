package com.hcl.phase3_1.Controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.phase3_1.Repo.UserEntity;
import com.hcl.phase3_1.Services.Services;


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	Services services;
	@Autowired
	Optional<UserEntity> user;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@GetMapping(path = "/")
	String hello() {
		logger.info("Mapping to index");
		return "user/index";
	}
	
	@PostMapping (path="/find")
	String find(@RequestParam (name="userid") String userid , Model model) {
		logger.info("post mapping /find");
		user = services.findById(userid);
		if(user.isPresent()) {
			System.out.println("here"+ user.toString());
			model.addAttribute("id", user.get().getId());
			model.addAttribute("firstName", user.get().getFirstName());
			model.addAttribute("lastName", user.get().getLastName());
			model.addAttribute("userid", user.get().getUserid());
			model.addAttribute("email", user.get().getEmail());
			return "user/welcome";
		}else {
			model.addAttribute("msg", "User not Found");
			return "user/index";

		}
	}
	
	
	@PostMapping(path = "/update")
	String update(@ModelAttribute("user") UserEntity user, ModelMap model) {
		logger.info("in /update");
		System.out.println("here update" + user.toString());
		services.update(user);
		model.addAttribute("msg", "<div style=\"border:1px dotted red;padding:2%;\">" +"User Information Updated");

		return "user/index";

	}
	

}
