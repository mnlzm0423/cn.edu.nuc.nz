/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

import javax.naming.NameAlreadyBoundException;

/**
 * 	处理异常之抛出异常：
 * 			方法创建者：
 * 				i.throw  一旦发生异常，我们直接抛出。一般用于传入参数的合法性判断
 * 						当方法的创建者throw 异常以后，调用者一旦传入非法参数，方法自动抛出异常，
 * 						方法中之后的代码也不再执行
 * 				ii.throws  在方法声明处 抛异常 告知调用者可能出现的异常 在创建者写的时候，只是建议没什么实质性动作
 * 								（需要将这种可能出现的异常写入文档注释，才能起到警示作用）
 * 								调用者在调用该方法的时候就会鼠标悬停，就会出现异常的文档注释
 * 				注意：
 * 					throws 对于方法创建者来说就是给调用者的一种警示，但对于调用者在调用该方法的时候，throws 就是向上抛出异常
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo16 {
		public static void main(String[] args) {
				test(1, 0, null);
				System.out.println("确实没啥反应");
		}
		/**
		 * 测试异常
		 * 
		 * @param num1  int类型的参数
		 * @param num2 int类型的参数
		 * @param arr	int类型的数组
		 * @throws ArithmeticException   num2 不能为0  除数不能为0
		 * @throws NullPointerException  arr整型数组不能是null
		 */
		public static void test(int num1, int num2, int[] arr) 
				throws ArithmeticException, NullPointerException {
				//if (num2 == 0 || arr == null) {	
				if (num2 == 0 ) {
						//创建者在写方法的时候就表明，一旦调用者传入参数不合法，我就报异常（当然实在调用者捕获异常的时候）
						//throw new ArithmeticException("算数异常");
						//因为一旦使用throw抛出异常，后面的代码就不再执行了所以这是无效代码
						//Unreachable code
						//不可到达的代码---抛出第一个异常以后，后面的代码就不再执行，所以不可达
						//throw new NullPointerException("空指针异常");
				}
				if (arr == null) {
						//throw new NullPointerException("空指针异常");
				}
				
		}
}
