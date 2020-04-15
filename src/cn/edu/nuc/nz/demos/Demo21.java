/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	匿名内部类：
 * 		针对那种及要遵循规范有要实现多样化实现的方法（抽象方法）需要用一个接口作为载体，同时仅仅为了实现一个方法
 * 		而定义了一堆实现类的情况
 * 			i.匿名类的初级演示
 * 			ii.匿名类的中极演示
 * 			iii.匿名类的高级演示
 * 			iiii.匿名类的终极演示
 * 
 *  @author lizhimin
 *  @version 1.0
 */
interface  A001 {
		void test();
}
class A0001 implements A001 {

		@Override
		public void test() {
			// TODO Auto-generated method stub
			System.out.println("ppp");
		}
	
}
public class Demo21 {
		public static void main(String[] args) {
				//然后创建对象 调用自己实现的这个方法
				//A001 a0001 = new A0001();
				//a0001.test();
				//就为实现这么一个抽象方法消耗了大量的人力物力财力，不值得，人间不值得
				//匿名类我来了   想想当初为什么说接口不能有对象，因为接口 中的方法是抽象方法，我们即使定义了对象也不能
				//有可用的实例方法，所以不能  匿名类的存在是一个什么鬼  就是没有类名，但是遵从接口实现了接口中方法，同时
				//定义类的时候就将对象创建出来了 香不？
			
				//演示一下匿名类的 初级演示  大括号相当于匿名类的类体在里面实现那个单兵方法  new 是为创建匿名类对象空间 
				//最后将对象给了接口引用  使用到了多态
				A001 a001 = new A001() {
						@Override
						public void test() {
								System.out.println("匿名内部类的初级演示");
						}
				};
				a001.test();
				
				//匿名内部类的中级演示  用到匿名对象
				//我们连引用都不用，我们直接用匿名类的匿名对象来调用方法  看到这个引用也太碍眼
				new A001() {
					
					@Override
					public void test() {
						// TODO Auto-generated method stub
						System.out.println("匿名类的中级演示：直接使用匿名对象");
					}
				};
				
				//匿名内部类的高级演示 (将匿名内部类对象直接入参方法)
			testInterface(new A001() {
				
				@Override
				public void test() {
					// TODO Auto-generated method stub
					System.out.println("匿名内部类直接作为方法实参传入，这与咱们使用的排序就相互契合了，匿名内部类对象直接入参");
				}
			});
			
			//匿名内部类的终极演示  lamada表达式 
			//先不说了
			
		}
		public static void testInterface(A001 a) {
				a.test();
		}
		
}
