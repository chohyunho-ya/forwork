package org.forwork.service.member;

import org.forwork.domain.Auth;
import org.forwork.domain.Member;
import org.forwork.mapper.MemberMapper;
import org.forwork.mapper.SprintMapper;
import org.forwork.service.ScrumBoard.SprintServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper mapper;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public void insertMember(Member member) {
		
		log.info("회원가입 ");
		member.setPw(passwordEncoder.encode(member.getPw()));
		member.setAuth("ROLE_USER");
		Auth auth = new Auth();
		auth.setEmail(member.getEmail());
		auth.setAuth(member.getAuth());

		mapper.signUp(member);
		mapper.insertAuth(auth);
	
	}
	
}