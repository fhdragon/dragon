package org.apache.dragon.pattern.singleton;


/**
 * Singleton1: 单例模式要素－私有构造函数、静态自身字段、静态公开实例方法（可选）。该单例模式实现采用急切实例化，缺点是可能在没有真正使用对象时会导致进行实
 * 例化，如果实例化本身需要操作其他资源时会引起不必要的开销。
 * 代码示例：
 * 		SingletonEager s ＝ SingletonEager.s;
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Sep 29, 2013
 * @since 1.0
 */
public class SingletonEager {

	//Local variables
	/**
	 * self
	 */
	public static SingletonEager s = new SingletonEager();
	

	//Constructor
	/**
	 * Creates a new <code>Singleton1</code> instance. 私有构造函数禁止实例化
	 */
	private SingletonEager(){
		
	}

}
