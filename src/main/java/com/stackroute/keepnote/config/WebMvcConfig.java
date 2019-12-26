package com.stackroute.keepnote.config;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.stackroute.keepnote.model.Note;

/*This class will contain bean for viewresolver
 * Define the following annotations:
 * @Configuration - Annotating a class with the @Configuration indicates that the 
 *                  class can be used by the Spring IoC container as a source of 
 *                  bean definitions
 * @ComponentScan - this annotation is used to search for the Spring components amongst the application
 * @EnableWebMvc - Adding this annotation to an @Configuration class imports the Spring MVC 
 * 				   configuration from WebMvcConfigurationSupport 
 * */
@Configuration
@EnableWebMvc
@ComponentScan("com.stackroute.keepnote")
public class WebMvcConfig implements WebMvcConfigurer {

	/*
	 * Define the bean for view resolver so that it can be used to resolve the JSP
	 * files which are existing in /WEB-INF/views folder. A ViewResolver is capable
	 * of mapping logical view names to actual views, such as a JSP or a HTML page.
	 */
@Bean
public ViewResolver internalResourceViewResolver()
{
	
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setViewClass(JstlView.class);
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	return resolver;
}

/*@Bean("note")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public Note getNote() {
	return new Note();
}*/

@Override
public void addFormatters(FormatterRegistry registry) {
	// TODO Auto-generated method stub
	
}

@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	// TODO Auto-generated method stub
	
}

@Override
public Validator getValidator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	// TODO Auto-generated method stub
	
}

@Override
public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
	// TODO Auto-generated method stub
	
}

@Override
public void configurePathMatch(PathMatchConfigurer configurer) {
	// TODO Auto-generated method stub
	
}

@Override
public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	// TODO Auto-generated method stub
	
}

@Override
public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
	// TODO Auto-generated method stub
	
}

@Override
public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
	// TODO Auto-generated method stub
	
}

@Override
public void addInterceptors(InterceptorRegistry registry) {
	// TODO Auto-generated method stub
	
}

@Override
public MessageCodesResolver getMessageCodesResolver() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void addViewControllers(ViewControllerRegistry registry) {
	// TODO Auto-generated method stub
	
}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// TODO Auto-generated method stub
	
}

@Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	// TODO Auto-generated method stub
	
}
}
