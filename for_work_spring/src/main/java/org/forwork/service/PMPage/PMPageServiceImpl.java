package org.forwork.service.PMPage;

import java.util.List;

import org.forwork.domain.Project;
import org.forwork.domain.ProjectLanguage;
import org.forwork.domain.TeamProgress;
import org.forwork.mapper.PMPageMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class PMPageServiceImpl implements PMPageService {
	
	private PMPageMapper mapper;

	@Override
	public TeamProgress getColumCount(int project_id) {

		log.info("GET COLUMN COUNT....!!!/ project_id: "+project_id);
		
		return mapper.getColumCount(project_id);
	}

	@Override
	public List<TeamProgress> getPersonalCount(int project_id) {
		
		log.info("GET PERSONAL COUNT / project_id: "+project_id);
		
		return mapper.getPersonalCount(project_id);
	}

	@Override
	public List<TeamProgress> getPersonalTasks(int project_id, int responsibility) {

		log.info("GET PERSONAL TASKS" +"project_id: "+project_id +"responsibility: " + responsibility);
		return mapper.getPersonalTasks(project_id, responsibility);
	}

	@Override
	public List<Project> getProjects(int member_id) {
		
		log.info("GET PROJECTS.........!!!");
		return mapper.getProjects(member_id);
	}

	@Override
	public int insertLang(ProjectLanguage prLang) {
		
		log.info("INSERT LANGUAGE.....!!!");
		
		return mapper.insertLang(prLang);
	}

	@Override
	public List<ProjectLanguage> getLang(int project_id) {
		
		log.info("GET PROJECT LANGUAGES....!!!");
		
		return mapper.getLang(project_id);
	}

	@Override
	public int deleteLang(int pr_lang_seq) {
		
		log.info("Delete Language......!!!");
				
		return mapper.deleteLang(pr_lang_seq);
	}

	@Override
	public int updateLang(ProjectLanguage prLang) {
		
		log.info("Update Language......!!!");
		
		return mapper.updateLang(prLang);
	}

	@Override
	public ProjectLanguage getSeq(int pr_lang_seq) {


		log.info("GET One Language......!!!");
		
		return mapper.getSeq(pr_lang_seq);
	}

	@Override
	public Project isPm(int project_id, int member_id) {

		log.info("GET IS PM......!!!!");
		
		return mapper.isPm(project_id, member_id);
	}
	
	

	
	



}
