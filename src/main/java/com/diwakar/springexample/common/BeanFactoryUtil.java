/**
 * 
 */
package com.diwakar.springexample.common;

import org.springframework.context.ApplicationContext;

/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: BeanFactoryUtil.java
 */
public class BeanFactoryUtil {
	
	
	public static Object getBean(String beanName)
	{
		ApplicationContext ctx = new ApplicationContextProvider().getApplicationContext();
		
		if(ctx!=null)
		{
			return ctx.getBean(beanName);
		}
	
		return null;
		
	}

}
