package org.forwork.controller.project;

import java.security.Principal;
import java.util.List;

import org.forwork.domain.Project;
import org.forwork.service.project.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {
	
	private final ProjectService projectService;
	
	@GetMapping("list")
	public String loginSuccess(Model model, Principal principal){
		List<Project> Projects = projectService.getProjects(principal.getName());
		
		model.addAttribute("projects",Projects);
		return "project/list";
	}
	
	@PostMapping("/create")
	public String projectCreate(Project project){
		projectService.createProject(project);
		return "redirect:/project/list";
	}
	
	/*@PostMapping("/update")
	public String projectUpdate(Project project){
		projectService.projectUpdate(project);
		return "redirect:/project/list";
	}*/

}
