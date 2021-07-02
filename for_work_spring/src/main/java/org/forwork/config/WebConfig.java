package org.forwork.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {RootConfig.class,SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
	//404에러를 처리하기 위한 메서드
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration){
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

		MultipartConfigElement multipartConfig = new MultipartConfigElement("C:\\upload\\temp", 20971520, 41943040, 20971520);
		registration.setMultipartConfig(multipartConfig);		
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter, 
					new DelegatingFilterProxy("springSecurityFilterChain")};
		
	}
	
}