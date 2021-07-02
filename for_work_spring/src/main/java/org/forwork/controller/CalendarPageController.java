package org.forwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calendar/*")
public class CalendarPageController {
	
	@GetMapping()
	public String calendar(){
		return "calendar";
	}

}
