package org.fly.create.abstractfactory;

import org.fly.create.factory.Sender;
import org.fly.create.factory.SmsSender;

public class SmsFactory implements Provider {

	@Override
	public Sender product() {
		return new SmsSender();
	}

}
