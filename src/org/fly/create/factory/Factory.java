package org.fly.create.factory;

public class Factory {
	public Sender product(String name){
		if("SMS".equals(name)){
			return new SmsSender();
		}
		if("Mail".equals(name)){
			return new MailSender();
		}
		return null;
	}
}
