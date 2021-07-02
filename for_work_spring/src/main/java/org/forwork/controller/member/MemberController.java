package org.forwork.controller.member;

import java.security.Principal;

import org.forwork.domain.Member;
import org.forwork.service.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("login")
	public String login(){
		return "login/login";//login폴더안 login.jsp로 이동
	}
	
	@GetMapping("/loginSuccess")
	public String loginSuccess(){
		
		return "redirect:/project/list";
	}
	
	@GetMapping("signUp")
	public String signUpPage(){
		
		return "signUp/signUp";
	}
	
	@PostMapping("/signUp")
	public String signup(Member member){
		memberService.insertMember(member);
		return "redirect:/member/login";
	}
	/*@GetMapping("list")
	public void list(Principal principal){
		principal.getName();
		return "redirect:/project/list";
	}
*/
	
	
	

}
