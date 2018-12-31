package com.springboot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

/**
 * 自定义安全权限配置
 * Created by SYSTEM on 2018/7/15.
 */
// @Configuration加入此注解和@Bean注解之后就可以将UserDetailsService相当于在传统的spring-config.xml配置中配置service的bean
@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter implements PasswordEncoder {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    protected UserDetailsService userDetailsService(){
        return new MyUserDetailsServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        /*auth.inMemoryAuthentication().passwordEncoder(
                new BCryptPasswordEncoder()).withUser("JL001")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("admin");*/
    }

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        if (charSequence == null || StringUtils.isEmpty(s)) return false;
        return (charSequence.toString()).equalsIgnoreCase(s);
    }

}
