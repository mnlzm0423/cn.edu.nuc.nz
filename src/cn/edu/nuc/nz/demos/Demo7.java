/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	2.静态代码块
 *  i.初始化类，当类文件（字节码文件）被加载的时候，静态代码块的所有内容就被执行了 
 *  ii.静态代码块的书写格式： 
 *  static {
 *		 静态代码块中的内容
 * }
 *  iii.静态代码块的执行是随类文件的加载而执行的那么什么时候进行类文件的加载？ 
 *  	情况1 强制加载Dog类（通过反射）会调用静态代码块
 *  		 Class.forName("cn.edu.nuc.nz.demos.Dog1");
 *  	 情况2 利用构造方法创建该类的对象的时候会用到这个类 对应的.class文件会被加载，静态代码块执行 
 *  		new Dog1();
 *  	 情况3 类名调用静态方法的时候类文件也会被加载
 *   Dog1.test();
 *   iiii.逼逼赖赖这么多 静态代码有什么用？加载一些资源文件 程序执行一次的过程就只会加载一次，节省的内存开销
 * 
 * @author lizhimin
 * @version 1.0
 */
class Dog1 {
	private String nameString;

	// 静态代码块
	static {
		System.out.println("正在执行静态代码块");
	}

	/**
	 * 
	 */
	public Dog1() {
		super();
		System.out.println("正在执行无参构造方法");
	}

	/**
	 * @param nameString
	 */
	public Dog1(String nameString) {
		super();
		this.nameString = nameString;
		System.out.println("正在执行有参构造方法");
	}

	public static void test() {
		System.out.println("Dog1类名执行的静态成员方法");
	}

}

public class Demo7 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 现在会执行Dog类的静态方法吗？
		// System.out.println("嘻嘻嘻");
		// Dog类的静态代码块没有被执行，当初不是说的静态代码块随类的加载而执行吗？
		// 现在咋Dog类的静态代码块咋不执行？
		// 1.首先明确一个问题，就是静态代码块随 类文件 加载而运行 这里的类文件指的是.class文件
		// 2.虽然Dog类和Demo7类实在一个文件中，但是这个文件在编译的时候会将Dog类和Demo7类分别
		// 编译成俩个.class(即不管你的.java文件里面放几个类，编译的时候都会将这几个类分开编译成
		// 不同的字节码文件)
		// 3.在执行的时候，用到某一个类，才会将这个类的字节码文件加载到内存（这时静态代码块才会执行）

		// 什么叫用到这个类，才会被加载？什么时候用到？

		// 情况1 强制加载Dog类（通过反射）会调用静态代码块
		// Class.forName("cn.edu.nuc.nz.demos.Dog1");
		// 情况2 利用构造方法创建该类的对象的时候会用到这个类 对应的.class文件会被加载，静态代码块执行
		// new Dog1();
		// 情况3 类名调用静态方法的时候 类文件也会被加载
		//Dog1.test();
		
		//快捷键：ctrl+shift+f 多行注释解开以后，用这个快捷键将代码恢复格式
		
		//在程序的一执行过程中，类文件加载几次？世运道一次加载一次吗？（静态代码块也是随类执行多次吗？）
		 Class.forName("cn.edu.nuc.nz.demos.Dog1");
		 new Dog1();
		Dog1.test();
		//结果说明：在程序一次执行的过程中，不管用到某一个类几次，这个类的字节码文件只会被加载一次（静态代码块也随之只执行一次）
		//用静态代码块  加载一些资源文件  根据它在程序的一次运行中只会执行一次的特性，不香吗？
		
	}
}
