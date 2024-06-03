package com.shiavnski.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shiavnski.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
    private JwtAuthFilter authFilter;
	
	@Bean
    //authentication
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("Jituu")
//                .password(encoder.encode("Pwd1"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("Ro")
//                .password(encoder.encode("Pwd2"))
//                .roles("USER","ADMIN","HR")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new EmployeeUserDetailsService();
    }
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.authorizeHttpRequests(customizer->{
//			customizer.requestMatchers("/departments/**","/authenticate").permitAll();
//			customizer.requestMatchers("/employees").authenticated();
//		    customizer.requestMatchers("/employees/{employeeId}").authenticated();
//		})
//		.sessionManagement(sessionManagement -> 
//         sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        .authenticationProvider(authenticationProvider())
//        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//
//		httpSecurity.csrf(customizer->customizer.disable());
//		
//		return httpSecurity.build();
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth->{
					auth.requestMatchers("/departments/**","/authenticate").permitAll()
					.requestMatchers("/employees").authenticated();
				})
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	@Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
}
