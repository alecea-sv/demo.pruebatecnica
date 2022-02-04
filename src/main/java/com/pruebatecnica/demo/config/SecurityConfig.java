package com.pruebatecnica.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
//        http
//         .csrf().disable()
//         .authorizeRequests().anyRequest().authenticated()
//         .and()
//         .httpBasic();
        
//        http.authorizeRequests().anyRequest().fullyAuthenticated();
//        http.httpBasic();
//        http.csrf().disable();
    	
    	http.authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
    	
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	
        auth.inMemoryAuthentication()
//        .passwordEncoder(new BCryptPasswordEncoder())
//        .withUser("user1").password("{noop}secret").roles("USER")
//        .withUser("user1").password("$2y$10$CUOfzBzcHGLerwL4VXQu1eV4kX9Wk/Twap.KNqpB1JmiRSG3yfBcq").roles("USER")
      .withUser("user1").password(encoder.encode("secret")).roles("USER")
        .and()
//        .withUser("user2").password("$2y$10$6u7WdDDHmjAeCIwbZpq5eO2B1YC4z.4qqV6Q1qRIYIeUTiReelVvy").roles("ADMIN");
      .withUser("user2").password(encoder.encode("secret")).roles("ADMIN");
        
    }
    
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }

}