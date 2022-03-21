package com.example.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Configuration:表示此类为配置类，加载到spring容器中
 * @EnableWebSecurity:表示开启自定义用户
 * @EnableGlobalMethodSecurity:表示启用方法级别的认证
 *          prePostEnabled:表示启动，默认为false
 *          true:表示可以使用@PreAuthorize注解 和 @PostAuthorize
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityApplicationConfig extends WebSecurityConfigurerAdapter {
    /**
     * springsecurity 5.0之后设置的密码必须是加密的，否则报错
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("zhangsan")
                .password(passwordEncoder().encode("123456"))
                //角色信息的指定
                .roles("normal");
        auth.inMemoryAuthentication().withUser("lisi")
                .password(passwordEncoder().encode("123456"))
                .roles("normal");
        auth.inMemoryAuthentication().withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("admin","nolmal");
    }

    /**
     * 创建密码加密类
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
