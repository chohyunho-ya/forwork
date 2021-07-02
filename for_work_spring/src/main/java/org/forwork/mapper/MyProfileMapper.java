package org.forwork.mapper;

import java.util.List;
import java.util.Map;

import org.forwork.domain.PortfolioLanguage;
import org.forwork.domain.Member;
import org.forwork.domain.Portfolio;

public interface MyProfileMapper {

	public int insert(Portfolio vo);
	public Portfolio read(String portfolio_id);
	
	public int delete(String portfolio_id);
	public int update(Portfolio vo);
	
	public List<Portfolio> listPortfolio(String member_id);
	public List<PortfolioLanguage> readPfLangList(String portfolio_id);
	
	public int insertPfLang(PortfolioLanguage vo);
	public int updatePfLang(PortfolioLanguage vo);
	public int deletePfLang(String portfolio_id);
	
	public List<Map<String,Object>> rollupLanguage(String member_id);
	public Member memberInfo(String member_id);
	
	public int updateMStatus(Member member);
}
