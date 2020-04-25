/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *	Set的使用说明：
 *			特征：无序，不可重复
 *			无序是说添加顺序和存储数据顺序是不一致的
 *			不可重复是说一个set集合中不能出现相同元素
 *			添加相同数据不会报错，但是不会显示重复数据
 *			add()方法的返回值是一个boolean类型
*	Set<E> 接口的俩个子接口
*			i.HashSet<E> 底层是一个散列表（哈希表）
*					数组加链表:我们通过hashCode来定位到底数据在那一条链表上，然后再在链表中进行增删改查
*					这样实际上是对链表增删快，查找慢的一个性能调节，我们将本身在一条链表上的所有数据，分摊到多条链表上
*					就将链表的查找新能提高了好多倍，很香
*			ii.TreeSet<E>底层是一个平衡二叉树 要想成为一棵平衡二叉树需要元素之间的比较，我们现在来尝试一下
*				Exception in thread "main" java.lang.ClassCastException: cn.edu.nuc.nz.demos.Student1 cannot be cast to java.lang.Comparable
*				这句话的意思是Student1不能被铸造成Comparable
*				原因是什么？没有元素间的比较方式
*				我们要想在添加元素的时候形成一棵平衡二叉树，必须要首先进行元素间的比较而对于系统提供的数据类型的包装类jvm自定提供比较方式，但是对
*				于我们自定义的类型来说 并未提供比较方式，jvm虚拟机不知道如何对这种自定义的元素进行比较,所以有了这个Student1不能铸造成Comparable
*				那么如何解决这种问题了？只能自己在自定义类中提供比较方法，实现Comparable接口
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo27 {
		public static void main(String[] args) {
				Set<Integer> set = new HashSet<>();
				set.add(5); 
				set.add(4); 
				set.add(3); 
				set.add(2); 
				set.add(1); 
				set.add(5);
				System.out.println(set);
		/*
		 * Set<Student1> setSet = new TreeSet<Student1>(); Student1 student1 = new
		 * Student1(1, "李志民", 18, '男'); Student1 student2 = new Student1(2, "李大招", 9,
		 * '男'); Student1 student3 = new Student1(3, "李狗蛋", 76, '男'); Student1 student4
		 * = new Student1(4, "李多多", 54, '男'); Student1 student5 = new Student1(5, "李将建",
		 * 5, '男'); setSet.add(student1); setSet.add(student2); setSet.add(student3);
		 * setSet.add(student4); setSet.add(student5);
		 */
			
		}
}
