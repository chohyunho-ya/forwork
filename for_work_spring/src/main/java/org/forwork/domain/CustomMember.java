package org.forwork.domain;

import java.util.Collection;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
@Getter
public class CustomMember extends User{
	private Member member;

	public CustomMember(String username, String password,
		Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomMember(Member member) {
		super(member.getMember_id(),member.getPw(),member.getAuthList().stream()
			.map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
			.collect(Collectors.toList()));
		this.member = member;
	}
}
