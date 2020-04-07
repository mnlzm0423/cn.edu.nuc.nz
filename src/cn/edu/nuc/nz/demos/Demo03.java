/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;



/**
 * final关键字的使用:
 * 		1.final修饰成员变量
 * 			The blank final field name may not have been initialized
 * 			final修饰的成员变量没有被初始化
 * 			总结：final修饰的成员变量定义时必须被初始化
 * 		2.final修饰成员方法
 * 			Cannot override the final method from A
 * 			不能重写A类的被final修饰的成员方法
 * 			final修饰成员方法子类不能去重写，这个方法是最终的实现，定死了
 * 		3.final修饰局部变量
 *  		final修饰的局部变量，只接受一次赋值操作，第二次以后赋值就开始报错
 * 		4.final修饰类（但不修饰抽象类）
 * 				被final修饰的类不能被继承
 *  @author lizhimin
 *  @version 1.0
 */
//十一.final class A
 class A {
	//一.The blank final field name may not have been initialized
	//二.final修饰的成员变量没有被初始化
	//三.总结：final修饰的成员变量定义时必须被初始化
	public final String name = "李智民";
	//四.被final修饰成员方法testA
	public  void testA() {
		System.out.println("A类的成员方法");
	}
}
//十三.The type B cannot subclass the final class A
//十四.B不能是final类A的子类
//十五.即被final修饰的类不能被继承
//十二.class B extends A
class B extends A {
	//五.Cannot override the final method from A
	//六.不能重写A类的被final修饰的成员方法
	
	@Override
	public void testA() {
		System.out.println("b类继承A类的testA方法");
	}
}
public class Demo03 {
	public static void main(String[] args) {
		
		//十.final修饰的局部变量，只接受一次赋值操作，第二次以后赋值就开始报错
		final int  num = 110;
		//八.The final local variable num cannot be assigned. It must be blank and not using a compound assignment（针对下面的语句）
		//九.局部变量num不能被赋值。它必须是空的不能复合赋值
		//七.num = 120;
		B b = new B();
		
		
	}
}