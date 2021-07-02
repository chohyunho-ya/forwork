package org.forwork.mapper;

import org.forwork.domain.Auth;
import org.forwork.domain.Member;

public interface MemberMapper {
	int signUp(Member member);
	
	public Member read(String username);
	
	int insertAuth(Auth auth);
}
