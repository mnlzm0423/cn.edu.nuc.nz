/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

import cn.edu.nuc.nz.demos.Student1;

/**
 * Object类的常用方法：
 * 			i.String toString() 
 * 			是对当前对象的简要String类型的描述，为当前对象所属类的全限定路径
 * 			@+该对象的十六禁止地址，如果对对象展示有要求，我们就在对象的类
 * 			中重写toString方法
 * 			ii. int hashCode()
 * 			当前对象在内存的唯一索引，默认情况下是当前对象所处空间的首地址的十进制
 * 			表示
 * 			iii. boolean equals()
 * 			比较方法，判断俩个对象是否相等 Object类中的equals方法默认是比较俩个对象
 *         引用数据类型变量里的地址，地址相同，俩个对象相等，相同对象。如果我们要
 *         重新制定equals规则，就可以在当前类中重写equals
 *         方法
 *        《注意》 
 *       		java规定，如果俩个对象的equals结果是true，要求HashCode值必须相等
 *       		也就是重写equals方法的时候，必须先重写hashCode方法（由于hashcode方法和equals的限制）
 *       		通常我们一起重写，而且这俩个方法都可以用工具自动生成
 *         
 *         当然Object类中还有几个关于线程通信的方法
 *         void notify()
 *         void wait()
 *         void notifyAll()
 *         
 *         还有关于反射的方法
 *         Class<?> getClass()
 * 
 *  @author lizhimin
 *  @version 1.0
 */

public class Demo26 {
		public static void main(String[] args) {
				Student1 student1 = new Student1(1, "笑傲江湖", 19, '男');
				System.out.println(student1.toString()); 
				System.out.println(student1.hashCode()); 
				Student1 student2 = new Student1(1, "笑傲江湖", 19, '男');
				System.out.println(student2.hashCode()); 
				System.out.println(student1.equals(student2));
		}
}
