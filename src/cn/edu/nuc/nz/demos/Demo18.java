/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	泛型在类中使用  泛型类
 * 			1.泛型类的格式：类名后面跟泛型标志
 * 					class Student<T> {}
 * 			2.什么时候具体确定泛型的类型？在创建对象的时候，我们就可以指定泛型的具体类型(假如泛型的具体类型设置为String)
 * 						Student<String> student = new Student<String>();
 * 			3.如果我们在创建对象的时候不指定类中的泛型，对象调用方法的时候就里面的泛型自动转为Object，但这样违背了
 * 				数据一致性的原则理念
 * 			下面来练习泛型类：
 *  @author lizhimin
 *  @version 1.0
 */
class Employee<T> {
		public void test1(T t) {
			System.out.println(t);
		}
		public void test2(T t1, T t2) {
			System.out.println(t1 + "=======" + t2);
		}
		//Cannot make a static reference to the non-static type T
		//类的静态成员方法不能使用类自定义的泛型，因为静态方法随类加载类加载好了，就可以直接使用了
		//但是类自定义的泛型，需要在创建的时候才能指定出来  所以类自定义的泛型，不能被本类的静态方法使用
	/*
	 * public static test3(T t1) {
	 * 
	 * }
	 */
		//假如本类的静态方法也比较执拗，就想用一个泛型，行呀，我们前面不是说过泛型方法吗我们在类种独树一帜
		//使用方法本身声明的泛型
		public static <E> void  test4 (E e) {
			
		}
		//结果很舒适，没有报错。当静态方法被类名调用的时候 ，自己指定泛型就可以了
		
		//普通成员方法能使用方法自定义的泛型吗
		public <K> void test5(K k) {
			
		}
}
public class Demo18 {
		public static void main(String[] args) {
				//创建类对象的时候，指定类的泛型 假如设置类中泛型为String
				Employee<String> employee = new Employee<String>();
				employee.test1("程序员");
				employee.test2("敲代码", "写文档");
				//发现我们泛型类方法使用泛型 定义出来是这样的
				//void cn.edu.nuc.nz.demos.Employee.test1(T t)
				//很明显方法参数是泛型类型，没有具体的数据类型
				
				///当我们在创建对象时指定泛型以后，调用方法我们发现方法的参数全部变为了String
				//void cn.edu.nuc.nz.demos.Employee.test1(String t)
				//这是方法使用和所在类一致的泛型
				//------------------------------------------------------------------------------------
				//普通方法也可以使用自己的泛型，不适用所在类自定义的泛型
				employee.test5(5);
				//该方法自定义的泛型根据传入的实参确定为Interage类型
				//记住普通数据类型确定泛型类型  要用包装类
		}
}
