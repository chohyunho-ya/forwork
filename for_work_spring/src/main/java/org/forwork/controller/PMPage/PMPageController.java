package org.forwork.controller.PMPage;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/pmPage/*", produces=MediaType.TEXT_HTML_VALUE)
public class PMPageController {
	
	@GetMapping("/main/{project_id}")
	public String pmPage(){
		
		return "PMpage/pmMainPage";
	}
	
	@GetMapping("/select/*")
	public String prSelectPage(){
		
		return "PMpage/pmSelectPage";
	}
	

}
