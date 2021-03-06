/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	泛型的使用：
 * 			泛型的引入，在实际开发中，通常会出现有一大批功能模块，由于数据类型的不同而导致整个功能模块需要重新
 * 					编写，工作量极大。即使是翻新，也会由于数据类型的不同而导致大量的bug，给程序员造成大量的困扰。
 * 					为解决这种问题，我们引入了泛型，咱们先不说泛型是什么，就说它改变了什么？对于哪些逻辑代码相同，
 * 					由于数据类型不同，而代码失效问题。它就可以解决，我们在设计功能模块的时候，就将数据类型写成活的
 * 					这样不同数据类型就可已使用相同的逻辑代码，完美不？可能感受不是很深，就以我们前天做的学生管理系统
 * 					哪些增删改查排的方法，我们使用泛型  学生类可以使用，教师类可以使用，员工可以使用。。。。
 * 			总之有了泛型就像相当于给方法/类/接口与数据类型实现解耦，方法如同一个 小霸王游戏机  数据类型相当于游戏卡
 * 				游戏机就那一个（方法就那一个）  一切游戏，我们可以放到那个游戏机中使用（一切数据类型都可以使用这方法
 * 				完成相同的逻辑功能）
 * 				泛型的书写格式是什么？  <T>  <E> <K> <V>   一对尖括号里放大写字母   大写字母一般是  type  element
 * 				key  value   
 * 				
 * 			泛型在方法中的使用：
 * 						先看格式：讲一下，泛型就像相当于js中的变量  在定义的时候并没有什么类型，但是然而可是却，当我们真正
 * 					使用它的时候，根据我们传入的值确定到底是哪种类型变量？  var name  = 1234  这个变量是数字类型  
 * 					var  name  = ”李志民“  就个变量就是字符串类型变量。泛型与之类似，我们在真正使用泛型方法的时候，必须要
 * 					给方法一个具体类型的实参来确定这个泛型到底是什么数据类型，方法才能根据这个具体的类型开始运转。
 * 					问题来了,我们要想传一个实参来确定泛型的类型。就必须在定义方法的时候。方法的形参中传入一个泛型变量，当我们使用
 * 					的时候，通过实参来确定泛型真正的数据类型
 * 					其次我们方法在使用泛型的时候必须要有一个标识，什么标识？证明该方法使用了泛型
 * 
 * 					所以泛型方法的定义格式是：
 * 						权限访问修饰符  <T> 返回值类型 方法名 （形参列表【必须有一个泛型类型的变量，用于规范泛型的数据类型   T  t】）
 * 						public static <T> void  test(T t);
 * 						方法使用泛型之后，可以用泛型作为返回值类型  实际上当我们将实参传入泛型方法的时候，就已经约束的泛型的类型
 * 						方法在具体执行的时候，方法内部的泛型早就替换成了具体的数据类型   非常完美
 * 						方法上使用泛型就称之为泛型方法   ，现在看方形方法的简单示例
 * 
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo17 {
		public  static void main(String[] args) {
			
			Integer[] arr1 = {1,3,2,4,5,6,7,8,9};
			String[] arr2 = {"猪猪侠","闪电侠","蜘蛛侠","娃娃机","烤饼子","小霸王"};
			// method traverseArray(T[]) in the type Demo17 is not applicable for the arguments (int[])
			//基本数据类型要想使用泛型必须使用包装类入参
			//Demo17的方法traverseArray(T[]) 不适用于int[]参数（基本数据类型必须使用包装类入参）
			traverseArray(arr1);
			System.out.println("----------------------------------");
			traverseArray(arr2);
		}

		//泛型方法的使用：遍历任意类型的数组
		/**
		 * 遍历任意类型数组	
		 * 
		 * @param <T>  泛型方法使用的标志
		 * @param t	一个任意类型的数组  同时约束泛型的数据类型
		 */
		public static <T> void traverseArray(T[] t) {
				for (int i = 0; i < t.length; i++) {
						System.out.print(t[i] + " ");
						if (i == t.length - 1) {
								System.out.print(t[i]);
						}
				}
		}
}
