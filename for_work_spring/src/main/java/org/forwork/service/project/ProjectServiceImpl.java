package org.forwork.service.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.forwork.domain.Project;
import org.forwork.mapper.ProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ProjectServiceImpl<project> implements ProjectService{
	
	private final ProjectMapper mapper;
	
	@Override
	public void projectCreate(Project project){
		log.info("프로젝트 생성");
		project.setProject_status_id("1");

		mapper.projectCreate(project);
	}
	
	@Override
	public List<Project> getProjects(String member_id) {
		return mapper.getProjectList(Integer.parseInt(member_id));
	}

	@Override
	public void createProject(Project project) {
				
		project.setProject_status_id("1");
		mapper.createProject(project);
		mapper.createMemberProjectRelationPm(project);
		for (String pa : project.getPa_id()){
			project.setPa_email(pa);
			mapper.createMemberProjectRelationPa(project);
		}
	}
}


