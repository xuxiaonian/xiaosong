package com.refeng.config;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 登录配置 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {
   
  
    
    
    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/admin/login**");
        addInterceptor.excludePathPatterns("/admin/index**");
        addInterceptor.excludePathPatterns("/uploadFile/**");
        
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }
    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
        	Object user=request.getSession().getAttribute("admin");
            if (user!=null ){
            	return true;
            }
            // 跳转登录
             String url = "/admin/login";
            response.sendRedirect(url);
            return false;
        }
    }
    
}