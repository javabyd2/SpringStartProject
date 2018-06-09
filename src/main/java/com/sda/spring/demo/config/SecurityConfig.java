package com.sda.spring.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.query.users-query")
    private String userQuery;

    @Value("${spring.query.roles-query")
    private String roleQuert;


    @Override
    protected  void configure(AuthenticationManagerBuilder authenticationManager) throws Exception{
        authenticationManager.jdbcAuthentication()
                .usersByUsernameQuery(userQuery)
                .groupAuthoritiesByUsername(roleQuert)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/registration").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/web/roleform").hasAuthority("ADMIN")
            .antMatchers().authenticated().and().formLogin().loginPage("/login")
            .failureUrl("/login?error=true")
            .defaultSuccessUrl("/web/registration")
            .usernameParameter("email")
            .passwordParameter("password");
    }
}
