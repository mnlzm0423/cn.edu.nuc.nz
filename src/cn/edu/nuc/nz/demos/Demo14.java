/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 异常（以前你不是很清楚）： 
 * 			生活中的异常：出现异常，什么异常，解决方案，最终收尾 
 * 			java中的异常： Throwable类：
 * 					 i.Exception类：异常类 可以处理 代码还有拯救的可能
 *					 ii.Error类：错误 GG思密达 Throwable类：
 * 					构造方法（constructor）：
 * 							 i.Throwable() 创建Throwable对象，Throwable对象中存储的异常或错误信息为nulll
 * 							ii.Throwable() 一个参数的构造方法用于创建Throwable对象，Throwable对象中存储着 异常或错误的信息
 * 					普通方法（Method）：
 * 							 i.String getMessage() 获取Throwable对象中错误或异常的信息 
 * 							ii.String toString() 返回当前异常或错误的简要叙述 
 * 							iii.void printStackTrace() 返回当前错误的前因后果【红色字体】
 * 							演示Throwable的构造方法和普通方法
 * 			异常和错误的区别
 * 					i.Exception异常可以通过代码修改  处理 NullPointException
 * 					ii.Error错误就彻底完了  StackOverFlowError
 * 
 * @author lizhimin
 * @version 1.0
 */
public class Demo14 {
	public static void main(String[] args) {
				//演示构造方法
						//演示无参构造
						Throwable throwable = new Throwable();
						
						//无参构造下演示普通方法getMessage() 
						//结果：当我们用无参构造方法创建Throwable对象 
						//调用的getMessage()方法，里面什么信息也没有-----null
						//System.out.println(throwable.getMessage());
						
						//无参构造下演示toString()方法  
						//结果:只有  java.lang.Throwable
						//System.out.println(throwable.toString());
						
						//无参构造下演示printStacktrace()
						//结果：直接打印下面信息
						//java.lang.Throwable 
						//at cn.edu.nuc.nz.demos.Demo14.main(Demo14.java:30)
						//throwable.printStackTrace();
						
		System.out.println("----------------------------------------------------------------------------");				
		
						//演示有参构造下的Throwable对象
						Throwable throwable2 = new Throwable("异常信息：这是一条单身狗");
						
						//有参构造下演示getMessage()
						//结果：getMessage() 方法得到的Exception/Error信息就是利用有参构造创建对象时输入的
						//字符串参数信息  异常信息：这是一条单身狗
						//System.out.println(throwable2.getMessage());
						
						//有参构造下演示toString（）
						//结果 ：java.lang.Throwable : 异常信息：这是一条单身狗
						//有无参构造下调用该方法 多了一条创建对象时的字符串信息
						//System.out.println(throwable2.toString());
						
						//有参构造下演示printStackTrace() 打印堆迹
						//结果：java.lang.Throwable: 异常信息：这是一条单身狗
						//at cn.edu.nuc.nz.demos.Demo14.main(Demo14.java:41)
						//throwable2.printStackTrace();
						
						
		}

}
