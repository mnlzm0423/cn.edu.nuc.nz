/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 		代码块的分类：
 * 			1.构造代码块
 * 				i.初始化当前类的所有对象，为什么？只要我们执行构造方法，不管是有参的构造方法
 * 					还是无参的构造方法，只要我们执行构造方法，构造代码块随之执行
 * 				ii.我们通过javap -c -1 -private Dog.class 命令会发现Java编译器在编译前
 * 					就会将构造代码块的内容装到各个构造方法里
 * 				ii.构造代码块的书写格式：
 * 					{//构造代码块的内容} 
 * 					一般放在成员变量之后，构造方法之前（其实放在
 * 					其他位置也行，Java编译器会将构造代码块整合到各个构造方法里的）
 * 				
 * 			2.静态代码块
 * 				i.初始化类，当类文件（字节码文件）被加载的时候，静态代码块的所有内容就被执行了
 * 				ii.静态代码块的书写格式：
 * 					static {
 * 						//静态代码块中的内容
 * 					}
 * 				iii.静态代码块的执行是随类文件的加载而执行的那么什么时候进行类文件的加载？
 * 					
 * 			3.局部代码块
 * 				局部代码块是为了提高效率，节约内存，优化jvm的垃圾回收机制（淘汰）
   *      静态代码块的使用：
 *		    
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class Dog {
	private String nameString;
	
	//构造代码块
	{
		System.out.println("做狗嘛，重要的是开心");
	}

	/**
	 * 
	 */
	public Dog() {
		super();
		System.out.println("正在执行无参构造方法");
	}

	/**
	 * @param nameString
	 */
	public Dog(String nameString) {
		super();
		this.nameString = nameString;
		System.out.println("正在执行有参构造方法");
	}
	
	
}
public class Demo6 {
	public static void main(String[] args) {
		/*
		 * //我们现在用 无参构造方法 创建对象，看 构造代码块 是否跟随执行 new Dog();
		 * //结果证明，我们调用无参构造方法创建对象，构造代码块会跟随构造方法执行
		 */	
		/*
		 * //我们现在用 有参构造方法 去创建对象 看 构造代码块 是否跟随 有参构造器 执行 new Dog("单身狗"); //结果， 我们调用有参构造方法
		 * 去创建对象 构造代码块也会跟着执行
		 */		
		
		
		
	}
		
}
