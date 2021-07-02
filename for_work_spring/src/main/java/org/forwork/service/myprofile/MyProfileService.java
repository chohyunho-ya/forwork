package org.forwork.service.myprofile;

import java.util.List;
import java.util.Map;

import org.forwork.domain.Portfolio;
import org.forwork.domain.PortfolioLanguage;
import org.forwork.domain.Member;

public interface MyProfileService {
	//transaction 필요한 서비스
	
	public Portfolio read(String portfolio_id);
	public int register(Portfolio portfolio, List<PortfolioLanguage> pfLangList);
	public int update(Portfolio portfolio, List<PortfolioLanguage> pfLangList);
	public int delete(String portfolio_id);
	
	public List<Portfolio> getList(String member_id);
	public List<Map<String, String>> countLang(String member_id);
	public Member getMemberInfo(String member_id);
	
	public int updateMStatus(Member member);
	
}
