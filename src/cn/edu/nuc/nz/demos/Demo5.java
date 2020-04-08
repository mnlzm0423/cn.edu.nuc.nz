/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * static修饰成员方法（静态成员方法）：
 * 		1.静态成员方法的格式：
 * 			public static returnType methodName (parameters) {}
 * 		2.静态成员方法的调用
 * 			和静态成员变量相同，不推荐使用对象调用，应该使用类名调用
 * 		3.静态成员方法的内部
 * 			静态成员方法中不可以使用非静态的成员变量
 * 			静态成员方法中不能使用非静态的成员方法
 * 			静态成员方法中不能使用this关键字（没有对象，是单身狗）
 * 			静态成员方法	中可以new对象
 * 		静态方法也是随类加载的 那时候还没有对象
 * 		静态方法中可以new对象  单身狗没有对象但是可以找对象	
 *  @author lizhimin
 *  @version 1.0
 */
class TestStaticMethod {
	//静态成员变量
	public static String nameString = "单身狗";
	//非静态成员变量
	public int num = 10;
	/**
	 * 
	 */
	public TestStaticMethod() {
		super();
	}
	
	//静态方法
	public static void testStaticMethod() {
		//静态方法中用静态的成员变量（可以）
		nameString = "单身汪";
		
		//静态方法中用静态成员方法(可以)
		
		//静态方法中用非静态的成员变量(错误)
		//Cannot make a static reference to the non-static field num
		//不能弄一个静态引用给非静态的成员变量
		//非静态成员变量是随对象的，加载静态方法的时候还没有对象------静态方法常被称为单身狗因为没有对象
		//num = 110;
		
		//静态方法中用非静态的方法
		//Cannot make a static reference to the non-static method test() from the type TestStaticMethod
		//不能弄一个静态引用给一个非静态的成员方法
		//非静态方法也是随对象调用，静态方法加载的时候还没有对象
		//test();
		
		//静态方法中可以new对象  单身狗没有对象但是可以找对象
		
		//非静态方法并不是说有几个对象就有多少个非静态方法（实际上静态方法也是加载好的，有对象是才调用）
		//类变量和类方法就是静态成员变量和静态成员方法
		System.out.println("静态成员方法");
	}
	//非静态成员方法
	public void test() {
		System.out.println("非静态成员方法");
	}
}
public class Demo5 {
	public static void main(String[] args) {
		//静态成员方法的调用
				//对象调用（不推荐有警告）
				TestStaticMethod testStaticMethod = new TestStaticMethod();
				testStaticMethod.testStaticMethod();
				//对象调用静态成员方法 会有黄色警告
				//The static method testStaticMethod() from the type TestStaticMethod should be accessed in a static way
				//静态成员方法应该以一种静态的方式去调用
				//类名调用静态方法（推荐）
				TestStaticMethod.testStaticMethod();//非常正常
	}
	
}
