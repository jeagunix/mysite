package kr.co.itcen.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.itcen.mysite.security.Auth;

@Auth("ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("/board")
	public String guestbook() {
		return "admin/main";
	}
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	
}
