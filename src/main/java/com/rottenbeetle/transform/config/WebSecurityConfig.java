package com.rottenbeetle.transform.config;

import com.rottenbeetle.transform.exception_handling.RestAuthenticationEntryPoint;
import com.rottenbeetle.transform.service.UserServiceImpl;
import com.rottenbeetle.transform.session.SessionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserServiceImpl userServiceImpl;
    private final SessionFilter sessionFilter;
    private final RestAuthenticationEntryPoint authenticationEntryPoint;
    public WebSecurityConfig(UserServiceImpl userServiceImpl, SessionFilter sessionFilter, RestAuthenticationEntryPoint authenticationEntryPoint) {
        this.userServiceImpl = userServiceImpl;
        this.sessionFilter = sessionFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();

        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        http.authorizeRequests()
                .antMatchers("/api/auth/login").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(sessionFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}