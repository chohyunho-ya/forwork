package org.forwork.controller.myprofile;

import java.security.Principal;

//import org.forwork.domain.Portfolio;
//import org.forwork.domain.PortfolioLanguage;
//import org.forwork.service.BoardService;
//import org.forwork.service.PortfolioService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value="/myprofile/*", 
produces=MediaType.TEXT_HTML_VALUE)
public class MyProfilePageController {

	@GetMapping("/main")
	public void main(Principal principal, String portfolio_id, Model model){
		int member_id = Integer.parseInt(principal.getName());
		
		model.addAttribute("member_id", member_id);
		model.addAttribute("portfolio_id",portfolio_id);
	}
	
	@GetMapping("/add")
	public void add(String member_id, Model model){
		model.addAttribute("member_id", member_id);
	}
	
	@GetMapping("/update")
	public void update(String portfolio_id, Model model){
		model.addAttribute("portfolio_id",portfolio_id);
	}
	
}
