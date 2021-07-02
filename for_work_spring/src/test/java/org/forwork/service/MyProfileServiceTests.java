package org.forwork.service;

import java.util.ArrayList;
import java.util.List;

import org.forwork.domain.Portfolio;
import org.forwork.domain.PortfolioLanguage;
import org.forwork.service.myprofile.MyProfileService;
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
public class MyProfileServiceTests {

	@Setter(onMethod_={@Autowired})
	private MyProfileService service;
	
	@Test
	public void testService(){
		log.info(service);
	}
	
//	@Test
//	public void testRegister(){
//	Portfolio portfolio = new Portfolio();
//	PortfolioLanguage pfLang = new PortfolioLanguage();
//	portfolio.setMember_id("1");
//	portfolio.setPortfolio_title("서비스 테스트_register_Portfolio 210512");
//	portfolio.setPortfolio_detail("서비스 테스트_register_Detail 210512");
//	
//	pfLang.setPortfolio_language("서비스 테스트_register_language 210512");
//	
//	service.register(portfolio, pfLang);
//	
//	}
	
//	@Test
//	public void testUpdate(){
//		Portfolio portfolio = new Portfolio();
//		portfolio.setPortfolio_detail("서비스테스트_update_Detail 210512");
//		portfolio.setPortfolio_title("서비스테스트_update_Portfolio 210512");
//		portfolio.setPortfolio_id("184");
//		log.info("----in testUpdate-----");
//		log.info(portfolio);
//		
//		List<PortfolioLanguage> pfLangList = new ArrayList<PortfolioLanguage>();
//		PortfolioLanguage pfLang = new PortfolioLanguage();
//		String portfolio_id=portfolio.getPortfolio_id();
//		pfLang.setPortfolio_id(portfolio_id);
//
//			pfLang.setPortfolio_language("서비스테스트_update_language1");
//			pfLangList.add(pfLang);
//			pfLang.setPortfolio_language("서비스테스트_update_language2");
//			pfLangList.add(pfLang);
//			pfLang.setPortfolio_language("서비스테스트_update_language3");
//			pfLangList.add(pfLang);
//
//
//		service.update(portfolio, pfLangList);
//	}
	
//	@Test
//	public void testDelete(){
//		log.info("---------in testDelete---------");
//		String portfolio_id ="265";
//		service.delete(portfolio_id);
//	}
	
//	@Test
//	public void testRead(){
//		String portfolio_id = "37";
//		log.info(service.read(portfolio_id));
//	}
	
//	@Test
//	public void testCountLang(){
//		String member_id="1";
//		log.info(service.countLang(member_id));
//	}
	
//	@Test
//	public void testMemberInfo(){
//		String member_id="1";
//		log.info(service.getMemberInfo(member_id));
//	}
	
}
