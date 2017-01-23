package org.fly.framework.decorator;

public class Decorator implements Source{
	Source source;
	public Decorator(Source s){
		this.source=s;
	}
	@Override
	public void sayHi() {
		source.sayHi();
	}
}
