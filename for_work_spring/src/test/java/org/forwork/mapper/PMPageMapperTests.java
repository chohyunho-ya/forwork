package org.forwork.mapper;

import org.forwork.domain.ProjectLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={org.forwork.config.RootConfig.class})
@Log4j
public class PMPageMapperTests {
	
	@Setter(onMethod_=@Autowired)
	public PMPageMapper mapper;

	/*
	@Test
	public void testGetTeamProgress(){
		
		log.info(mapper.getColumCount(1));
		}
	
	@Test
	public void testGetPersonalCount(){
		
		
		mapper.getPersonalCount(1).forEach(tp -> log.info(tp));
	}
	
	@Test
	public void testGetPersonalTasks(){
		
		mapper.getPersonalTasks(1,1).forEach(tasks -> log.info(tasks));
	}
	*/
	
	@Test
	public void testGetProjects(){
		
		
		mapper.getProjects(61).forEach(pr -> log.info(pr));
	}
	/*
	@Test
	public void testInsertLang(){
		
		ProjectLanguage lang = new ProjectLanguage();
		lang.setProject_id(1);
		lang.setProject_language("c++");
		
		mapper.insertLang(lang);
	}
	
	@Test
	public void testGetLang(){
		
		mapper.getLang(1).forEach(lang -> log.info(lang));
	}
	
	@Test
	public void testDeleteLang(){
		
		int count = mapper.deleteLang(1);
		log.info("DELETE COUNT: "+count);
	}
	
	@Test
	public void testUpdateLang(){
		
		ProjectLanguage lang = new ProjectLanguage();
		lang.setProject_language("������ ���");
		lang.setProject_language_seq(2);
		
		int count = mapper.updateLang(lang);
		log.info("Update Count: " + count);
	}
	
	@Test
	public void testGetSeq(){
		
		log.info(mapper.getSeq(4));
	}
	
	
	@Test
	public void testIsPm(){
		
		int project_id = 1;
		int member_id = 1;
		
		log.info(mapper.isPm(project_id, member_id));
		
	}
	*/
	}

