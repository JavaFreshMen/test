package com.njusoft.its;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author David Ji
 * 创建方式参考一下
 * 1.创建拦截器
	public class TestWebInterceptor implements HandlerInterceptor{
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			System.out.println("test web interceptor");
			HttpSession session = request.getSession();
			System.out.println("session id: "+session.getId());
			return true;
		}
	}
	
	2.在该类的addInterceptors中添加拦截器

 */
@Configuration
public class SpringBootWebAppConfigure extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		registry.addInterceptor(new TestWebInterceptor()); 			//拦截所有
//		registry.addInterceptor(new TestWebInterceptor()).addPathPatterns("/hello");
	}
	
}
