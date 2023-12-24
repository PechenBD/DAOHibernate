package ru.netology.daohibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Anton")
                .password("password1")
                .authorities("read", "write")
                .and()
                .withUser("Dmitry")
                .password("password2")
                .authorities("write")
                .and()
                .withUser("Anna")
                .password("password3")
                .authorities("read");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/age-less-than").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/persons/by-name-and-surname").hasAuthority("write")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
