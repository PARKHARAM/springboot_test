package com.example.demo.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;



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
				.and()
				.formLogin().and().cors().and().csrf().disable();		
		
        http.sessionManagement()
        .maximumSessions(1)
        .maxSessionsPreventsLogin(false)
        .expiredUrl("/duplicated-login")
        .sessionRegistry(sessionRegistry());

	}
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
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
