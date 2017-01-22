package org.fly.create.prototype;

public class Prototype implements Cloneable{

	protected Prototype clone() throws CloneNotSupportedException {
		return (Prototype)super.clone();
	}
}
