package org.forwork.controller.ScrumBoard;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/task/*", produces=MediaType.TEXT_HTML_VALUE)
public class TaskPageController {
	
	@GetMapping("/taskPage/*")
	public String taskPage(){
		
		return "/ScrumBoard/scrumBoard";
	}
	
	@GetMapping("/logs/*")
	public String logsPage(){
		return "/ScrumBoard/logs";
	}

}
