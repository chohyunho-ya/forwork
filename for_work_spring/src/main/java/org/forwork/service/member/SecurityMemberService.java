package org.forwork.service.member;

import lombok.AllArgsConstructor;
import org.forwork.domain.CustomMember;
import org.forwork.domain.Member;
import org.forwork.mapper.MemberMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SecurityMemberService implements UserDetailsService {

	private final MemberMapper memberMapper;

	// /login 요청이 오면 자동으로 UserDetailsService 타입으로 ioc되어 있는 loadUserByUsername 함수가 실행
	// 시큐리티 session(내부 Authentication(내부 UserDetails))
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberMapper.read(username);
		return member == null ? null : new CustomMember(member);
	}
}