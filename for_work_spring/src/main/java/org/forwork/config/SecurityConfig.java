package org.forwork.config;

import org.forwork.controller.member.CustomAccessDeniedHandler;
import org.forwork.controller.member.CustomAuthFailureHandler;
import org.forwork.controller.member.CustomLoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*import CustomeAccessDeniedHandler.CustomeAccessFailerHandler;*/
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// 패스워드 인코딩을 사용하기 위한 빈
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
		web.httpFirewall(DefaultHttpFirewall());
	}
	
	@Bean
	public HttpFirewall DefaultHttpFirewall(){
		return new DefaultHttpFirewall();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/PMOpage/**").hasRole("ADMIN")
		.antMatchers("/**")
		.permitAll()
		.and() // 로그인  설정
		.formLogin()
		.loginProcessingUrl("/login")
		.usernameParameter("email")
		.passwordParameter("pw")
		.loginPage("/member/login")
		.successHandler(new CustomLoginSuccessHandler())
		.failureHandler(new CustomAuthFailureHandler())
		.permitAll()
		.and() // 로그아웃 설정
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/member/login")//로그아웃 하고 넘어갈 페이지
		.invalidateHttpSession(true);
	}
}
