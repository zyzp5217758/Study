package com.zyzp.springboot.elasticsearch.config;

import com.zyzp.springboot.elasticsearch.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new MyPasswordEncoder());
        //auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1");
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/level2/**").hasAuthority("VIP2")
                .antMatchers("/level1/**").hasAuthority("VIP1");
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/userLogin");
        http.rememberMe().rememberMeParameter("rememberme");
        http.logout().logoutSuccessUrl("/");
    }
}
