package com.tim.pet.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableAutoConfiguration
@Controller
@CrossOrigin(origins = "*")
public class AuthController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@RequestMapping(path="/user", method=RequestMethod.GET)
	@ResponseBody
	public Principal user(Principal user) {
		LOGGER.info("Requesting principal {}", user);
		return user;
	}
	
	@RequestMapping(path="/signout", method=RequestMethod.POST)
	@ResponseBody
	public void signout() {
		LOGGER.info("Signing out");
		SecurityContextHolder.clearContext();
	}


}
