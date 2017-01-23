package org.fly.framework.apadter;

public class Apadter extends Target implements Source{

	@Override
	public void sayHi() {
		
	}
	
	@Override
	public void sayHello() {
		super.sayHello();
	}

}
