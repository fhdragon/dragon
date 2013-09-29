package org.apache.dragon.pattern.singleton;


/**
 * Singleton1: 单例模式要素－私有构造函数、静态自身字段、静态公开实例方法（）。该单例模式实现采用Double－check方式，通过在同步前后添加判断提高并发，
 * 且通过变量_s防止一个线程将未初始化完成的s对象发布。
 * 代码示例：
 * 		SingletonDoubleCheck s ＝ SingletonDoubleCheck.getInstance();
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Sep 29, 2013
 * @since 1.0
 */
public class SingletonDoubleCheck {

	//Local variables
	/**
	 * self
	 */
	public static SingletonDoubleCheck s = null;
	

	//Constructor
	/**
	 * Creates a new <code>Singleton1</code> instance. 私有构造函数禁止实例化
	 */
	private SingletonDoubleCheck(){
		
	}
	
	//Logic
	/**
	 * getInstance
	 * 
	 * @return
	 */
	public static SingletonDoubleCheck getInstance(){
		if(s == null){
			synchronized (SingletonDoubleCheck.class) {
				if(s == null){//避免时多个线程进行初始化
					//临时变量防止线程在初始化未完成时发布对象
					SingletonDoubleCheck _s = new SingletonDoubleCheck();
					s = _s;
				}
			}
		}
		return s;
	}

}
