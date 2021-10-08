package com.marondalgram.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.marondalgram.interceptor.PermissionInterceptor;

@Component
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private PermissionInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
		.addPathPatterns("/**")		//어떤 주소로 들어왔을 때 inspector를 태울 것인지
		.excludePathPatterns("/user/sign_out");
	}
	

	
	@Override	//이미지를 url로 쳤을 때 볼 수 있도록 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///C:\\Users\\arock\\Desktop\\web\\5. spring_project\\quiz\\marondal_workspace\\images/"); //실제파일 저장치
	}
}
