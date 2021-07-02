package org.forwork.controller.attendance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attendance")
public class AttendancePageController {
	@GetMapping
	public String attendance(){
		return "attendance";
	}
}
