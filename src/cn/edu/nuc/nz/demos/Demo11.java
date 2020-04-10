/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;



/**
 * 		接口试水：（需要那一部分演示，打开注解即可）
 *  		1.一个普通类可以实现多个接口
 *  			 i.也就是说一个类可以遵循多种规范，生活中充电头遵循多个规范，就能为多个不同电压的手机充电
 * 				ii.一个类遵循多种规范，证明它普适性越高，功能越强大 
 * 			2.接口之间可以多继承
 * 				 i.也就是说一个接口可以继承多个接口，
 * 				ii.而且继承其他接口的这个接口不必去考虑实现这些抽象方法， 所有抽象方法统一都将由子类来实现
 * 			3.接口之间不存在实现关系 4.jdk1.8 以后，接口可以可以有默认方法 （必须由default来修饰这个方法）
 * 				i.这种被default修饰的方法可以有方法体（也就是说被default修饰的方法，可以有自己的默认实现）
 * 				ii.子类对于这种接口中被default修饰的方法 ，可以选择性重写（重写也行，不重写也行）
 * 
 * @author lizhimin
 * @version 1.0
 */
//-----以下说明：一个类可以实现多个接口 实现的接口越多  功能越强大，普适性越好-------------------------

/*
 * interface F { void testF(); }
 * 
 * interface G { void testG(); }
 * 
 * class Test implements F, G {
 * 
 * @Override public void testG() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void testF() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * }
 */

//-----以下说明：一个类可以实现多个接口 实现的接口越多  功能越强大，普适性越好-------------------------





//------------------接口之间可以实现多继承----------------
//记住接口中一般只有抽象方法，一定不能写方法体
/*
 * interface C { void testC(); } interface D { void testD(); } interface E
 * extends C, D {
 * 
 * }
 */
//------------------接口之间可以实现多继承----------------





//------------------接口之间没有实现关系----------------
/*
 * interface C { void testC(); }
 */
//implement cannot be resolved to a type
//无法将实现解析为类型
/*
 * interface D implementst C {
 * 
 * }
 */
//------------------接口之间没有实现关系----------------



//------------------jdk1.8 接口有了新特性，有了某些方法可以有方法体  需要default修饰----------------
/*
 * interface C { default void testC () {
 * System.out.println("接口中被default修饰的方法，可以有方法体"); } }
 */
//------------------jdk1.8 接口有了新特性，有了某些方法可以有方法体  需要default修饰----------------
public class Demo11 {
		public static void main(String[] args) {
			
		}
}
