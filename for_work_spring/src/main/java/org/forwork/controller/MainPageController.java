package org.forwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import org.forwork.service.board.PostService;
import org.forwork.service.todolist.TodolistService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/*")
@AllArgsConstructor
public class MainPageController {
	
	private PostService postService;
	private TodolistService todolistService;

	@GetMapping("/main/{project_id}")
	public String main(@PathVariable(name = "project_id") int project_id, Principal principal, Model model) {
		log.info("forwork main page");
		int member_id = Integer.parseInt(principal.getName());
		
		model.addAttribute("member_id", member_id);
		model.addAttribute("project_id", project_id);
		
		model.addAttribute("notice", postService.getNotice(project_id));
		model.addAttribute("doing", todolistService.doingList(member_id)); 
		model.addAttribute("done", todolistService.doneList(member_id));
		
		return "main";
	}
}
