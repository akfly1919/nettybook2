package org.fly.framework.proxy;

import org.fly.framework.decorator.Source;

public class Proxy implements Source {
	Source source;

	public Proxy() {
		try {
			source=Source.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sayHi() {
		source.sayHi();
	}
}
