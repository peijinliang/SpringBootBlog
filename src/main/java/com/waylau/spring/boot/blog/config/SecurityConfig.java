package com.waylau.spring.boot.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * ��ȫ������
 * Crete by Marlon
 * Create Date: {DATE}
 * Class Describe
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //���÷�������ļ�������
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String KEY = "marlon.com";

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //����BCrypt����
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder); //���ü��ܷ�ʽ
        return authenticationProvider;
    }

    /**
     * �Զ�������
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() //û���κ�����
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/admins/**").hasRole("ADMIN")  //��Ҫ��Ӧ��Ȩ�޲��ܷ���
                .and()
                .formLogin()  //����Form�ı���֤
                .loginPage("/login").failureUrl("/login-error") //�Զ����¼����
                .and().rememberMe().key(KEY) //����remmberMe
                .and().exceptionHandling().accessDeniedPage("/403"); //�����쳣���ܾ����ʾ��ض���403����
        http.csrf().ignoringAntMatchers("/h2-console/**");//����H2����̨��CSRF����
        http.headers().frameOptions().sameOrigin();   //��������ͬһ��Դ��H2����̨����
    }


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

}
