package org.forwork.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Portfolio {

	private String portfolio_id;
	private String member_id;
	private String portfolio_title;
	private Date portfolio_start_date; 
	private Date portfolio_end_date;
	private String portfolio_detail;
	private List<PortfolioLanguage> portfolioLanguage;
}
