package org.fly.create.abstractfactory;

import org.fly.create.factory.MailSender;
import org.fly.create.factory.Sender;

public class MailFactory implements Provider {

	@Override
	public Sender product() {
		return new MailSender();
	}

}
