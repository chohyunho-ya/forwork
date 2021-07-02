package org.forwork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={org.forwork.config.RootConfig.class})
@Log4j
public class AttendanceServiceTest {
	@Setter(onMethod_=@Autowired)
	private AttendanceService service;
	
	@Test
	public void serviceTest(){
		log.info(service.getWeekWork("35", "2"));
		Gson gson = new Gson();
		System.out.println(gson.toJson(service.getWeekWork("35", "2")).toString());
	}
}
