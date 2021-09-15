package com.zys.config;


/**
 * @author cy
 * @create 2021-02-04-11:23 上午
 * @Description SpringSecurity 配置类
 */
//@Configuration
//@EnableWebSecurity//开启WebSecurity模式
//添加@EnableGlobalMethodSecurity注解开启Spring方法级安全
//prePostEnabled属性决定Spring Security的前注解是否可用@PreAuthorize,@PostAuthorize等注解,设置为true
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {

//该配置方法只适用于本地测试时使用，以遗弃
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //super.configure(auth);
//        /*
//         * 在内存中配置两个用户 admin和user
//         */
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("12345"))
//                .roles("admin");
//
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("user");
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        // 开启自动配置的登录功能
//        // /login 请求来到登录页
//        // /login?error 重定向到这里表示登录失败
//        //http.formLogin();
//
//        //开启自动配置的注销的功能
//        // /logout 注销请求
//      //  http.logout();
//
//
//        // .logoutSuccessUrl("/"); 注销成功来到首页
//        //http.logout().logoutSuccessUrl("/");
//
//        //记住我
//       // http.rememberMe();
//
//        //http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
//
//    }
//


//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return  new BCryptPasswordEncoder();
//    }
//
//
//}
