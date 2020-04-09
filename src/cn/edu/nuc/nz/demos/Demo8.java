/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	面试题  静态代码块  构造代码块  静态成员变量的混合面试题
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class Dog2 {
	static Dog2 dog1 = new Dog2();
	static Dog2 dog2 = new Dog2();
	
	{
		System.out.println("构造代码块执行");
	}
	static {
		System.out.println("静态代码块执行");
	}
	public Dog2() {
		System.out.println("无参构造方法");
	}
}
public class Demo8 {
	public static void main(String[] args) {
		Dog2 dog2 = new Dog2();
		//预测执行结果
		/*
		 * 用到Dog2这个类了，会加载Dog2这个类的字节码文件 按理说 静态代码块执行 "静态代码块执行" 但是由于程序时从上到下执行的
		 * 在构造代码块之前有静态成员变量 所以会首先调用 俩个构造器 调用构造器会引发构造代码块的执行
		 */
		//所以执行结果是：
		//1.构造代码块执行
		//2.无参构造方法
		//3.构造代码块执行
		//4.无参构造方法
		//5.静态代码块执行
		//6.构造代码块执行
		//7.无参构造方法
		
		//假如将Dog2类的那俩个静态成员变量的static解决掉（也就是变成普通的成员变量）
		//所以执行结果是：
		//1.静态代码块执行
		//2.构造代码块执行 无参构造方法
	    //在这里你会发现  构造代码块中有俩个成员变量 都是调用构造方法的 而一调用构造方法
		//就有会调用无参构造器  又回去创建这俩个无参构造器  完了，死循环了。jj了
	}
	
}
