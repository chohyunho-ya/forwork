package org.forwork.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.forwork.config.RootConfig.class})
@Log4j
public class TaskLogMapperTest {
	@Setter(onMethod_=@Autowired)
	private TaskLogMapper mapper;
	
//	@Test
//	public void mapperTest(){
//		mapper.insertLog("1", "test log2", 1);
//	}
	@Test
	public void getTest(){
		log.info(mapper.getLog("23"));
	}
}
