package org.fly.create.singleton;

public class Singleton {
	private Singleton(){}
//懒汉模式
//	private static Singleton instance=new Singleton();
//	
//	public static Singleton getInstance(){
//		return instance;
//	}
//饱汉模式	
//	private static Singleton instance;
//	
//	public static Singleton getInstance(){
//		if(instance==null){
//			instance=new Singleton();
//		}
//		return instance;
//	}
//简单线程安全	
//	private static Singleton instance;
//	
//	public static synchronized Singleton getInstance(){
//		if(instance==null){
//			instance=new Singleton();
//		}
//		return instance;
//	}
//双重检测
//	private static Singleton instance;
//	
//	public static  Singleton getInstance(){
//		if(instance==null){
//			synchronized(Singleton.class){
//				if(instance==null){
//					instance=new Singleton();
//				}
//			}
//		}
//		return instance;
//	}
	
	public static class Singleton1{
		private static Singleton inSingleton=new Singleton();
	}
	public static  Singleton getInstance(){
		return Singleton1.inSingleton;
	}
}
