package com.example.demo.auth;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.example.demo.auth.ExService;
import lombok.RequiredArgsConstructor;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final ExService exService;
	/**
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/userAccess").hasRole("USER")
				.antMatchers("/signUp").anonymous()
				.antMatchers("/homepage").hasRole("USER")
				.antMatchers("/blog").hasRole("USER")
				.antMatchers("/about").hasRole("USER")
				.antMatchers("/contact").hasRole("USER")
				.antMatchers("/product").hasRole("USER")
				.antMatchers("/singlepost").hasRole("USER")
				.and()
				.formLogin().and().cors().and().csrf().disable();		
		
        http.sessionManagement()
        .maximumSessions(1)
        .maxSessionsPreventsLogin(false)
        //.expiredUrl("/duplicatedlogin")
        .expiredUrl("/index")
        .sessionRegistry(sessionRegistry());
        
        http.logout()
        .logoutUrl("/logout") // 로그아웃 처리 URL
        .logoutSuccessUrl("/index")
        
        ;
        

	}
	
	@Bean
	public SessionRegistry sessionRegistry() {
	    return new SessionRegistryImpl();
	}

    @Bean
    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }


	/**
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(exService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
