package org.forwork.mapper;

import java.util.Date;

import org.forwork.domain.Calendar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ org.forwork.config.RootConfig.class,org.forwork.config.SecurityConfig.class})
@Log4j
public class CalendarMapperTests {
	@Setter(onMethod_=@Autowired)
	private CalendarMapper mapper;
	
	@Test
	public void mapperTest(){
		log.info(mapper);
	}
	
//	@Test
//	public void inserTest(){
//		Calendar cal = new Calendar();
//		cal.setCalendar_content("test");
//		cal.setCalendar_start_date(new Date());
//		cal.setCalendar_end_date(new Date());
//		cal.setProject_id("1");
//		log.info(mapper.insertCalendar(cal));
//	}
//	@Test
//	public void deleteTest(){
//		mapper.deleteCalendar("1");
//	}
	@Test
	public void updateTest(){
		Calendar cal = mapper.getCalendar("2");
		cal.setCalendar_content("modify");
		mapper.updateCalendar(cal);
	}
	
	@Test
	public void getListTest(){
		
		mapper.getCalendarList("1").forEach(cal->log.info(cal));
	}

}
