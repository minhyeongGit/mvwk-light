package com.mvwk.api.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/img/**", "/css/**", "/js/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
	         .antMatchers("/", "/join", "/login", "/resources/**").permitAll()
	         .antMatchers("/admin/**").hasRole("ADMIN")
	         .antMatchers("/member/**").hasRole("MEMBER")
	         .anyRequest().authenticated()
	     .and()
	         .formLogin()
	             .loginPage("/login")
	             .defaultSuccessUrl("/loginSuccess")
	             .failureUrl("/loginFail")
	         .permitAll()
	     .and()
	         .logout()	// 로그아웃 설정
	             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	             .logoutSuccessUrl("/")
	             .invalidateHttpSession(true)
	     .and()
	         .exceptionHandling()
	             .accessDeniedPage("/denied");
	}
}
