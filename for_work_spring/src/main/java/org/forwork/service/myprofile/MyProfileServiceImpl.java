package org.forwork.service.myprofile;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.forwork.domain.Member;
import org.forwork.domain.Portfolio;
import org.forwork.domain.PortfolioLanguage;
import org.forwork.mapper.MyProfileMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
//import lombok.Setter;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class MyProfileServiceImpl implements MyProfileService {
	
	private MyProfileMapper mapper;
	
	@Transactional
	@Override
	public Portfolio read(String portfolio_id) {
		
		Portfolio portfolio= new Portfolio();
		portfolio=mapper.read(portfolio_id);
		portfolio.setPortfolioLanguage(mapper.readPfLangList(portfolio_id));
		
		return portfolio;
	}
	
	@Transactional
	@Override
	public int register(Portfolio portfolio, List<PortfolioLanguage> pfLangList) {
		
		log.info("--------RegisterService-----------");
		int returnInteger = mapper.insert(portfolio);
		log.info("--------RegisterService_insert_Portfolio-----------");
		List<PortfolioLanguage> list = pfLangList;
		for(PortfolioLanguage pfLang : pfLangList){
			mapper.insertPfLang(pfLang);
			log.info("--------RegisterService_insert_Pflang"+pfLang+"-----------");
		}
		return returnInteger;
	}
	
	@Transactional
	@Override
	public int update(Portfolio portfolio, List<PortfolioLanguage> pfLangList) {
		//PortfolioLanguage가 삭제-삽입 되는 로직 추후에 변경필요
		log.info("-------------UpdateService------------");
		int returnInteger = mapper.update(portfolio);
		log.info("-------------UpdateService_update_portfolio----------");
		mapper.deletePfLang(portfolio.getPortfolio_id());
		for(PortfolioLanguage pfLang : pfLangList){
			pfLang.setPortfolio_id(portfolio.getPortfolio_id());
			mapper.updatePfLang(pfLang);
		}
		return returnInteger;
	}
	
	@Transactional
	@Override
	public int delete(String portfolio_id) {
		log.info("-------------DeleteService-------------");
		mapper.deletePfLang(portfolio_id);
		int returnInteger = mapper.delete(portfolio_id);
		return returnInteger;
	}

	@Transactional
	@Override
	public List<Portfolio> getList(String member_id) {
	 
		List<Portfolio> list = mapper.listPortfolio(member_id);
		List<Portfolio> list0 = new ArrayList<Portfolio>();
		for(Portfolio portfolio : list){
			String pfId = portfolio.getPortfolio_id();
			portfolio.setPortfolioLanguage(mapper.readPfLangList(pfId));
			list0.add(portfolio);
		}
		return list0;
	}

	@Override
	public List<Map<String, String>> countLang(String member_id) {
		log.info("------------countLangService---------------");
		//google api 사용을 위한 형변환
		List<Map<String,Object>> list0 = mapper.rollupLanguage(member_id);
		List<Map<String,String>> statLangList = new ArrayList<>();
		
		for(Map<String,Object> map: list0) {
			Map<String,String> newMap = new HashMap();
			for(Entry<String,Object> entry : map.entrySet()) {
				newMap.put(entry.getKey(), entry.getValue().toString());
			}
			statLangList.add(newMap);
		}
		
		return statLangList;
	}



	@Override
	public Member getMemberInfo(String member_id) {

		return mapper.memberInfo(member_id);
	}

	@Override
	public int updateMStatus(Member member) {
		
		return mapper.updateMStatus(member);
	}


	
	
	
}
