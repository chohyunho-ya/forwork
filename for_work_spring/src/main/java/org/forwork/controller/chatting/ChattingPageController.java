package org.forwork.controller.chatting;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/chatting/*", produces = MediaType.TEXT_HTML_VALUE)
public class ChattingPageController {
	
	@GetMapping("/detail/{chatroomId}")
	public String detail(@PathVariable String chatroomId, Model model) {
		model.addAttribute("chatroomId", chatroomId);
		return "/chatting/detail";
	}
	
	@GetMapping("/invite")
	public String search() {
		return "/chatting/invite";
	}
	
}
