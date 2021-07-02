package org.forwork.service;

import org.forwork.service.PMOPage.PMOPageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(classes={ org.forwork.config.RootConfig.class, org.forwork.config.SecurityConfig.class})
@WebAppConfiguration
public class PMOPageServiceTests {

	@Setter(onMethod_={@Autowired})
	private PMOPageService service;
	
//	@Test
//	public void testgetList(){
//		String project_status_id="2";
//		log.info(service.getList(project_status_id));
//		
//	}
	
//	@Test
//	public void testGetMList(){
//		String project_id = "1";
//		log.info(service.getMemberList(project_id));
//	}
	
	@Test
	public void testCount(){
		log.info(service.countProject());
	}
}
