package com.njusoft.its.core.global;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class GlobalApplicationContext implements ApplicationContextAware,InitializingBean{
	
	public static ApplicationContext applicationContext;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		GlobalApplicationContext.applicationContext = applicationContext;
	}

}
