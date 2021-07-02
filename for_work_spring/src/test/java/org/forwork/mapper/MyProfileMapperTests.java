package org.forwork.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.forwork.domain.PortfolioLanguage;
import org.forwork.domain.Portfolio;
import org.forwork.mapper.MyProfileMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ org.forwork.config.RootConfig.class, org.forwork.config.SecurityConfig.class})
@Log4j
public class MyProfileMapperTests {

	private String[] memArr={"1","2","3","4"};
	
	@Setter(onMethod_= @Autowired)
	private MyProfileMapper mapper;
	
//	@Test
//	public void testMapper(){
//		log.info(mapper);
//	}
	
//	@Test
//	public void testCreate(){
//		IntStream.rangeClosed(1,100).forEach(i->{
//			PortfolioVO vo = new PortfolioVO();
//			
//			vo.setMember_id(memArr[i%4]);
//			vo.setPortfolio_title("Portfolio create TEST title"+i);
//			vo.setPortfolio_detail("Portfolio create TEST detail"+i);
//			
//			mapper.insert(vo);
//		});
//	}
	
//	@Test
//	public void testRead(){
//		String targetPId = "42";
//		Portfolio vo = mapper.read(targetPId);
//		log.info(vo);
//	}
	
//	@Test
//	public void testUpdate(){
//		String targetPId="98";
//		Portfolio vo = mapper.read(targetPId);
//		vo.setPortfolio_title("Portfolio update TEST title");
//		vo.setPortfolio_detail("Portfolio update TEST detail");
//		mapper.update(vo);
//		
//	}
	
//	@Test
//	public void testDelete(){
//		String targePID="264";
//		mapper.delete(targePID);
//	}

//	@Test
//	public void testDeletePfLang(){
//		String targePID="264";
//		mapper.deletePfLang(targePID);
//	}
	
//	@Test
//	public void testInsertPfLang(){
//		PortfolioLanguage vo= new PortfolioLanguage();
//		String language="A";
//		vo.setPortfolio_language(language);
//		mapper.insertPfLang(vo);
//	}
	
//	@Test
//	public void testCntMemLang(){
//		String mID="1";
//		log.info(mapper.rollupLanguage(mID));
//	}

//	@Test
//	public void testReadPfLang(){
//		String portfolio_id = "37";
//		List<PortfolioLanguage> pfLangList = mapper.readPfLang(portfolio_id);
//		log.info(pfLangList);
//		
//	}
	@Test
	public void testMemberInfo(){
		String member_id = "1";
		log.info(mapper.memberInfo(member_id));
	}

}