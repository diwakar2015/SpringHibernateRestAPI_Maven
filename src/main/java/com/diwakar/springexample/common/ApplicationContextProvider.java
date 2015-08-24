
package com.diwakar.springexample.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: ApplicationContextProvider.java
 */

public class ApplicationContextProvider implements ApplicationContextAware{

	private static ApplicationContext context;

	public ApplicationContext getApplicationContext() {
		return context;
	}

	@Override
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		context = ac;
	}
}

