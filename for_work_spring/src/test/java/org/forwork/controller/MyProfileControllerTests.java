package org.forwork.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;

import org.forwork.config.ServletConfig;
import org.forwork.domain.Portfolio;
import org.forwork.domain.PortfolioLanguage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={
		org.forwork.config.RootConfig.class, org.forwork.config.SecurityConfig.class,
		org.forwork.config.ServletConfig.class})
@Log4j
public class MyProfileControllerTests {
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void testStatList() throws Exception{
//		log.info("--------------controllerTests---------------");
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/myprofile/1/list"))
//				.andExpect(status().isOk()));
//	}
	
//	@Test
//	public void testGet() throws Exception{
//		log.info("--------------controllerTests---------------");
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/myprofile/3/76"))
//				.andExpect(status().isOk()));
//	}
	
	@Test
	public void testDelete() throws Exception{
		log.info("---------controllerTests--------------");
		log.info(mockMvc.perform(MockMvcRequestBuilders.delete("/myprofile/266"))
				.andExpect(status().isOk()));
		
		log.info("----------controllerTests end---------------");
	}
	
//	@Test
//	public void testLangChart() throws Exception{
//		log.info("-------controllerTests---------");
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/myprofile/1/chart"))
//		.andExpect(status().isOk()));
//		
//	}
	


}
