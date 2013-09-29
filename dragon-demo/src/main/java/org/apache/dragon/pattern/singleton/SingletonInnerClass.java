package org.apache.dragon.pattern.singleton;


/**
 * Singleton1: 单例模式要素－私有构造函数、静态自身字段、静态公开实例方法（）。该单例模式实现采用内部类初始化方式，确保初始化的安全。
 * 代码示例：
 * 		SingletonInnerClass s ＝ SingletonInnerClass.getInstance();
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Sep 29, 2013
 * @since 1.0
 */
public class SingletonInnerClass {

	//Local variables

	//Constructor
	/**
	 * Creates a new <code>Singleton1</code> instance. 私有构造函数禁止实例化
	 */
	private SingletonInnerClass(){
		
	}
	
	//Logic
	/**
	 * 返回单例对象本身
	 * 
	 * @return
	 */
	public static SingletonInnerClass getInstance(){
		return SingletonHelper.s;
	}
	
	//inner class
	/**
	 * SingletonHelper: 单例实例化辅助类，实例化单例对象
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Sep 29, 2013
	 * @since 1.0
	 */
	static class SingletonHelper {
		static SingletonInnerClass s = new SingletonInnerClass();
	}

}
