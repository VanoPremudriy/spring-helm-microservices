package ru.mirea.authorizationservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthentcationProvider authenticationProvider;

	public void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider);

	}

	@Override
	public void configure(WebSecurity security) throws Exception {
		security.ignoring().antMatchers("/user/create", "/actuator/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.requestMatchers().antMatchers("/login", "/oauth/authorize","/oauth/token").and().authorizeRequests().anyRequest()
				.authenticated().and().formLogin().permitAll().and().csrf().disable();

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
