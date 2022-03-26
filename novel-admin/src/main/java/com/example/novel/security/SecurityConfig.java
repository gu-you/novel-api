//package com.example.common.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//@Configuration
//@EnableWebSecurity // 开启Spring Security的功能
////prePostEnabled = true表明开启 @PreAuthorize(方法之前验证授权),@PostAuthorize(授权方法之后被执行),@PostFilter(在方法执行之后执行，用于过滤集合),@PreFilter(在方法执行之前执行，用于过滤集合)；功能强大，所以其使用需要借助spring的EL表达式；
////securedEnabled = true,表明使用 @Secured 注解 开启权限
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    @Qualifier("myUserDetailService")
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private UnauthorizedEntryPoint unauthorizedEntryPoint;
//    @Autowired
//    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//
//    //放行名单
//    private final static String[] WHITE_URL_LIST = {
//            "/swagger-ui.html/**",
//            "/api/**",
//            "/resources/**",
//            "/auth/**",
//            "/doc.html*",
//            "/v2/api-docs",
//            "/swagger-resources/**",
//            "/static/**",
//            "/**/*.js",
//            "/**/*.html",
//            "/**/*.css",
//            "/*.txt",
//            "/login/**",
//            "/auth/**",
//
//    };
//
//
//    /**
//     * 核心配置
//     *
//     * @param httpBasic
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        System.out.println("我进来了");
//
//        http.csrf().disable().cors()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //session创建策略，永不
//                .and()
//                .httpBasic()
//                // 未经过认证的用户访问受保护的资源
//                .authenticationEntryPoint(unauthorizedEntryPoint)
//                .and()
//                .authorizeRequests()
//                .antMatchers(WHITE_URL_LIST).permitAll() //auth服务放行名单
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().disable()
//                .logout().logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) ->
//                ResponseUtils.responseReturn(httpServletResponse, Result.ok("注销成功")))
//                .permitAll();
//        //异常处理
//        http.exceptionHandling()
//                // 已经认证的用户访问自己没有权限的资源处理
//                .accessDeniedHandler((httpServletRequest, httpServletResponse, e) ->
//                        ResponseUtils.responseReturn(httpServletResponse, Result.error(ResultEnum.FORBIDDEN.getCode(),ResultEnum.FORBIDDEN.getMsg())))
//                .and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry
//                = http.authorizeRequests();
//
//    }
//
//
//    /**
//     * 认证管理器配置
//     */
//
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    /**
//     * 密码处理
//     *
//     * @param auth
//     * @throws Exception
//     */
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//
//    /**
//     * 装载BCrypt密码编码器,官方推荐的，
//     *  是基于 Hash 算法实现的单向加密。可以通过 strength 控制加密强度，默认 10.
//     *
//     * @return
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//}
