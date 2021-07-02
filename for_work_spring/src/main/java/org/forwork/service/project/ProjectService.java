package org.forwork.service.project;

import java.util.List;

import org.forwork.domain.Project;

public interface ProjectService {

	void projectCreate(Project project);
	
	List<Project> getProjects (String member_id);
	
	/*void projectUpdate(Project project);*/
	
	void createProject(Project project);

}
