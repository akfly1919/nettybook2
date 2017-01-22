package org.fly.create.builder;

import java.util.ArrayList;
import java.util.List;

import org.fly.create.factory.MailSender;
import org.fly.create.factory.Sender;
import org.fly.create.factory.SmsSender;

public class Builder {
	
	List<Sender> list=new ArrayList<Sender>();
	public void build(int count,String name){
		for(int i=0;i<count;i++){
			if("sms".equals(name)){
				list.add(new SmsSender());
			}else{
				list.add(new MailSender());
			}
		}
	}

}
