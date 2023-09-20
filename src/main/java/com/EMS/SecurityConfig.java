package com.EMS;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf(csrf_request-> csrf_request.disable());
		//http.authorizeHttpRequests(http_request->http_request.anyRequest().permitAll());
		
		http.authorizeHttpRequests(http_request-> http_request
				.requestMatchers(HttpMethod.POST,"/Project").hasAnyRole("TL","ADMIN")
				.anyRequest()
				.authenticated())
				.httpBasic(Customizer.withDefaults());
	
		return http.build();
	}
	
	@Bean
	public UserDetailsService userdetailsService()
	{
		UserDetails user1=User.builder().username("vipul").password(PasswordEncoder().encode("vipul@123")).roles("TL").build();
		UserDetails user2=User.builder().username("aniket").password(PasswordEncoder().encode("aniket@123")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	public BCryptPasswordEncoder PasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	

}
