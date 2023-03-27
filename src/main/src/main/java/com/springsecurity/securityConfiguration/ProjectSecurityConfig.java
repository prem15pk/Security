package com.springsecurity.securityConfiguration;

import com.springsecurity.Filter.CsrfCookieFilter;
import org.aspectj.lang.annotation.Before;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    SecurityFilterChain defaultsecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler attributeHandler = new CsrfTokenRequestAttributeHandler();
        attributeHandler.setCsrfRequestAttributeName("_csrf");


        http.securityContext().requireExplicitSave(false)
                .and()
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .csrf((csrf)->csrf.csrfTokenRequestHandler(attributeHandler)
                        .ignoringRequestMatchers("/saveCustomer","/uplode","/downlode")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests().
                requestMatchers("/getbalance","/getAccount").authenticated()
                .requestMatchers("/saveCustomer","/uplode","/downlode").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        return http.build();

    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
