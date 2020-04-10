/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	继承的生活实例编写  ：
 * 			i.喂动物，至于喂什么动物自己来定，那么如何写才能接受各种各样的动物了？  用动物类  其他类都是它的子类  子类赋值给父类是非常成功的
 * 			ii.获取动物，即方法会一个动物 ，至于什么动物自己定  那么返回类型该 怎么定了？定成动物类，创建子类对象可以赋值给子类
 * 			
 * 		总结：1.这里无论是喂动物让动物类型做形参 ，满足喂各种动物，选用动物父类作为形参；还是为得到各种动物，将动物父类作为返回类型  
 * 				  2.从本质将都是一种多态的体现  父类做形参，满足各种子类传递   父类做返回类型 满足各种子类传递   
 * 				  3.之前的例子还有接口作为形参  满足各类实现类作为实参传递   
 * 				  4.接口作为返回值   满足各类实现类作为返回值类型传递
 * 
 * 
 * 
 * 		多态：
 * 				i.父类引用指向子类对象
 * 				ii.接口引用指向实现类对象 接口引用指向间接实现类对象
 * 			作用：
 * 					i.拓宽方法实参类型
 * 					ii.拓宽方法返回类型
 * 					
 *  @author lizhimin
 *  @version 1.0
 */
class Animal {

}
class Dogg extends Animal {
}
class Tiger extends Animal {
	
}
class rabbit extends Animal {
	
}
public class Demo13 {
	public static void main(String[] args) {
			//我现在喂动物  喂方法的形参需要指定类型，什么类型    动物类型   其他动物都是动物的子类   子类实参赋值给父类形参合乎情理
			feed(new Dogg());
			feed(new Tiger());
			//现在要获取一只动物，即返回一只动物   返回值类型定什么   我们应该是可以获取到任意一种动物  所以返回值类型定为Animal  
			//创建子类返回给父类合乎情理
		Dogg dogg	= (Dogg)getAnimal();
		System.out.println("获取到一只动物" + dogg.getClass());
			
	}
	/**
	 * 喂一只动物
	 * @param animal  指定的动物
	 */
	public static  void feed(Animal animal) {
		System.out.println(animal.getClass()+ "来吃饭了！！！");
	}
	public static Animal   getAnimal() {
			return new Dogg();
	}
}
