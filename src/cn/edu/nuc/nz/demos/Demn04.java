/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * static关键字 ：static修饰成员变量
 * 					会被放到一个公共的区域
 * 					所有对象的该成员变量，持有这个内容的地址
 * 					这个成员变量的内容会被所有对象共享
 * 					与共享单车作类比，总结的静态成员特性
 * 					1.公共区（内存分析图可以解释）
 * 					2.共享性（被所有对象共享使用）
 * 				    3.与对象无关 （生命周期与对象无关）
 * 					4.一处改变，处处受限
 * 	最后针对 静态成员变量与对象无关再次进行阐述：
 * 				1.从内存角度分析  
 * 					静态成员变量在数据区  对象是在栈区 俩这就不在一块存储
 * 				2.从静态成员变量与对象的生命周期分析
 * 					静态成员变量随类的字节码文件加载到内存的数据区，当程序执行完毕，退出内存以后，才会被销毁
 * 					对象了它的创建是在程序执行的过程中，程序推出内存前就会将堆栈中的内存清空（对象在堆区）
 * 					俩者生命周期就不在一条线上
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class SingleDog {
	//静态成员变量（被static修饰的成员变量）
	public static String fieldString = "单身狗";
	//非静态成员变量
	public String nameString;
	/**
	 * 
	 */
	public SingleDog() {
		super();
	}
	/**
	 * @param nameString
	 */
	public SingleDog(String nameString) {
		super();
		this.nameString = nameString;
	}
	
}
public class Demn04 {
	public static void main(String[] args) {
		
		/*
		 * // 共享性演示(结果表明所有对象共享静态成员变量fieldString) //创建8个对象 SingleDog singleDog1 = new
		 * SingleDog("老王"); SingleDog singleDog2 = new SingleDog("老李"); SingleDog
		 * singleDog3 = new SingleDog("老苏"); SingleDog singleDog4 = new SingleDog("老刘");
		 * SingleDog singleDog5 = new SingleDog("老郭"); SingleDog singleDog6 = new
		 * SingleDog("老聂"); SingleDog singleDog7 = new SingleDog("老杜"); SingleDog
		 * singleDog8 = new SingleDog("老磊"); SingleDog singleDog9 = new SingleDog("老韩");
		 * 
		 * // 让这8个对象调用静态成员变量，看结果是否一致，从而证明共享性 System.out.println(singleDog1.fieldString);
		 * System.out.println(singleDog2.fieldString);
		 * System.out.println(singleDog3.fieldString);
		 * System.out.println(singleDog4.fieldString);
		 * System.out.println(singleDog5.fieldString);
		 * System.out.println(singleDog6.fieldString);
		 * System.out.println(singleDog7.fieldString);
		 * System.out.println(singleDog8.fieldString);
		 * 
		 * //在此基础上演示 一处修改，所有受限（8个对象的静态变量都改变了） //一处修改 
		 * singleDog1.fieldString = "单声汪";
		 * 
		 * //看上面的八个对象的静态成员变量的值是否改变 System.out.println(singleDog2.fieldString);
		 * System.out.println(singleDog3.fieldString);
		 * System.out.println(singleDog4.fieldString);
		 * System.out.println(singleDog5.fieldString);
		 * System.out.println(singleDog6.fieldString);
		 * System.out.println(singleDog7.fieldString);
		 * System.out.println(singleDog8.fieldString);
		 */
		//演示静态成员变量与对象无关（对象的创建，销毁，是否使用与静态成员变量无关）
			//现在没有对象的情况下，通过类名调用静态成员变量，仍然可以调用（静态成员与是否有对象无关）
			System.out.println(SingleDog.fieldString);
			
			//匿名对象使用完以后就变成了无主内存，会被虚拟机的gc机制回收。等同于对象被销毁
			new SingleDog();
				
			//对象被销毁，看静态成员变量是否存在（存在）  
			System.out.println(SingleDog.fieldString);
			
			//静态成员变量的调用
			SingleDog singleDog = new SingleDog();
			System.out.println(singleDog.fieldString);
			//对象调用静态成员变量
			//会报黄色警告：
			//The static field SingleDog.fieldString should be accessed in a static way
			//SingleDog的静态成员变量fieldString 应该以一种静态方式调用
			//解决类名调用静态成员变量
			System.out.println(SingleDog.fieldString);
		
	}
}
