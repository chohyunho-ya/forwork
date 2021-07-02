package org.forwork.controller.myprofile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.forwork.domain.Member;
import org.forwork.domain.Portfolio;
import org.forwork.domain.PortfolioLanguage;
import org.forwork.service.myprofile.MyProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/myprofile/")
@RestController
@Log4j
@AllArgsConstructor
public class MyProfileController {

	private MyProfileService service;
	
	@PostMapping(value="/{member_id}/new",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@PathVariable("member_id") String member_id,
										@RequestBody Portfolio portfolio){
		log.info("------------Controller_start----------------");
	
		log.info("Portfolio-PfLang: "+portfolio);
		
		portfolio.setMember_id(member_id);

		List<PortfolioLanguage> pfLangList = portfolio.getPortfolioLanguage();
		
		int insertCount = service.register(portfolio, pfLangList);
		log.info("------------Controller_end----------------");	
		
		return insertCount==1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	@GetMapping(value = "/{member_id}/list",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Portfolio>> getList(@PathVariable("member_id") String member_id){
		log.info("-------------Controller_GetList------------");
		
		return new ResponseEntity<List<Portfolio>>(service.getList(member_id),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{member_id}/info",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Member> getInfo(@PathVariable("member_id") String member_id){
		Member member = service.getMemberInfo(member_id);
		String detail= member.getStatus_detail();
		if(detail==null){
			detail="상태없음";
			member.setStatus_detail(detail);
		}
		log.info("-------------Controller_GetList------------");
		return new ResponseEntity<Member>(member,HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/{portfolio_id}/portfolio",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Portfolio> get(@PathVariable("portfolio_id") String portfolio_id){
		log.info("-------------Controller_GET------------");
		log.info("Get: "+portfolio_id);
		
		return new ResponseEntity<Portfolio>(service.read(portfolio_id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{portfolio_id}",
			produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete(@PathVariable("portfolio_id")String portfolio_id){
		
		log.info("remove:" +portfolio_id);
		
		
		return service.delete(portfolio_id)==1
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH},
			value="/{portfolio_id}/update",
			consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody Portfolio portfolio,
										@PathVariable("portfolio_id") String portfolio_id){
		portfolio.setPortfolio_id(portfolio_id);
		List<PortfolioLanguage> list = portfolio.getPortfolioLanguage();
		List<PortfolioLanguage> list0 = new ArrayList<PortfolioLanguage>();
		for(PortfolioLanguage pfLang: list){
			pfLang.setPortfolio_id(portfolio_id);
			list0.add(pfLang);
		}
		
		portfolio.setPortfolioLanguage(list0);
		log.info("modify:"+portfolio_id);
		
		
		return service.update(portfolio,list0) ==1
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/{member_id}/chart",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Map<String,String>>> langChart(@PathVariable("member_id") String member_id){

		return new ResponseEntity<List<Map<String,String>>>(service.countLang(member_id),HttpStatus.OK);
	}
	
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH},
			value="/{member_id}/updateMemberStatus",
			consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateMStatus(@RequestBody Member member,
										@PathVariable("member_id") String member_id){
		return service.updateMStatus(member)==1
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
