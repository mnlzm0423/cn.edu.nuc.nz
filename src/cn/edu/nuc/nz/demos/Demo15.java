/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	处理异常之捕获异常：
 * 			i.try{}catch(Exception e){}
 * 			ii.try{}catch(Exception e){}finally{}  这种加finally的捕获异常的方式  一般是涉及到资源的时候才会用
 * 			
 * 			具体处理方法：就是将有可能出现异常的代码块用try的大括号括起来  catch（具体异常对象）{这里是对异常的处理
 * 			 例如打印异常信息printStacktrace（）等等}
 * 			
 * 			注意：
 * 					程序得一次执行过程：
 * 						一旦try代码块中某一句代码出现了异常，try代码块中其他后续代码（出现异常那句代码之后的代码）
 * 						就不会继续执行了，直接跳到catch块中 等到catch块将异常处理完毕以后（就相当于生病被医生治好了，
 * 						完全成为一个健康人了）try catch 后面的代码将会正常执行不会有任何问题，但是遗留在try中的后续代码
 * 						不会执行了
 *    				对于这中trycatch捕获异常的方式，假如try代码块中出现了多个异常，但一次捕获只能捕获一个异常，其他的异常
 *    				将会在下次运行被捕获（上一次出现异常的代码已经修改完毕）
 * 
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo15 {
		public static void main(String[] args) {
			//下面的代码会出现俩种异常  算数异常    空指针异常 看看是否如总结的一样 一次只处理一个
				//sum(10, 0);
				//结果：
				//java.lang.ArithmeticException: / by zero
				//at cn.edu.nuc.nz.demos.Demo15.sum(Demo15.java:40)
				//at cn.edu.nuc.nz.demos.Demo15.main(Demo15.java:29)
				//果然一次执行只处理了一个异常  只有算数异常  当这个异常被解决后第二次运行看看结果怎样
				sum(10, 2);
				//结果2：
				//java.lang.NullPointerException
				//at cn.edu.nuc.nz.demos.Demo15.sum(Demo15.java:48)
				//at cn.edu.nuc.nz.demos.Demo15.main(Demo15.java:35)
				//说明俩点：1.一次执行只能处理一个异常
				//                  2.一旦出现异常try代码块内后面的语句将不会被执行
		}
		public static int sum(int num1, int num2) {
			//sum cannot be resolved to a variable
			//sum不能被解析为一个变量，原因是sum属于局部变量（try代码块中）跳出代码块变量就失效了
			//当真正运行的的时候，这种局部变量运行完毕以后就会在栈内被清空
			//解决将变量sum从try块中提出来
			//The local variable sum may not have been initialized
			//局部变量必须被初始化才能被使用
				int sum = 0;
				try {
						sum = num1 / num2;
						String aString = null;
						System.out.println(aString.getBytes());
				}catch(ArithmeticException exception) {
					exception.printStackTrace();
				}catch(NullPointerException exception) {
					exception.printStackTrace();
				}
				return sum;
		}
}
