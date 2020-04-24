package edu.stas.cursach.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(encoder.encode("qazwsxedc"))
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password(encoder.encode("qazwsxedc"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/web/**/create").hasRole("ADMIN")
                .antMatchers("/web/**/delete/**").hasRole("ADMIN")
                .antMatchers("/web/**/edit/**").hasRole("ADMIN")
                .antMatchers("/web/**/list").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .defaultSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }
}

