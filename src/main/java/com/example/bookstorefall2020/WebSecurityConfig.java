package com.example.bookstorefall2020;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.bookstorefall2020.web.UserDetailServiceImpl;

/* @Configuration Indicates that a class declares one or more @Bean methods and may be processed 
by the Spring container to generate bean definitions and service requests for those beans at runtime*/

/*@EnableGlobalMethodSecurity(prePostEnabled = true) 
 * Enables Spring Security global method security similar to the <global-method-security>xml support
 */

/*@EnableWebSecurity Add this annotation to an @Configuration class to have the Spring Security configuration 
 * defined in any WebSecurityConfigurer or more likely by extending the WebSecurityConfigurerAdapter base class 
 * and overriding individual methods
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/* @Autowired Marks a constructor, field, setter method, or config method as to be autowired bySpring's dependency 
	 *injection facilities. This is an alternative to the JSR-330 javax.inject.Inject annotation, adding 
	 *required-vs-optional semantics
	 */
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	//Indicates that a method declaration is intended to override amethod declaration in a supertype
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
				//Login is requested
				.and().authorizeRequests().anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/booklist")
				.permitAll().and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		//Opens crypted passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}