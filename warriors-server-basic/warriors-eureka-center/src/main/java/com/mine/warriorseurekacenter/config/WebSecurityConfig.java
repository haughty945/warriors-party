package com.mine.warriorseurekacenter.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @program: pluto-program
 * @description: 配置security的csrf检验为false
 *
 * */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    	//http.csrf().ignoringAntMatchers("/eureka/**");
        //super.configure(http);
    }
}
