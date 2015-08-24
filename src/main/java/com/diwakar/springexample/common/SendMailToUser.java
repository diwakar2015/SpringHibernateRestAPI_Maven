/**
 * 
 */
package com.diwakar.springexample.common;


/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: SendMailToUser.java
 */
public class SendMailToUser {


	public static void sendMailToUser(String userName, String userEmailID)
	{
		System.out.println("Inside sendMailToUser with "+ userEmailID + userName);
		try
		{
			MailSenderUtil mm = (MailSenderUtil) BeanFactoryUtil.getBean("mailSenderUtil");
			if(mm!=null)
			{
			mm.sendMail("diwakarchoudhary7@gmail.com",
					userEmailID,
					"Testing123", 
					"Testing only \n\n Hello Spring Email Sender");
			}
			else
			{
				System.out.println("bean is null, not expected!!");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in sendMailToUser "+ e);
		}

	}

}
