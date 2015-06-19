package ru.insoft.archive.app.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value = "/login", method = GET)
	public Principal login(Principal user) {
		return user;
	}
}
