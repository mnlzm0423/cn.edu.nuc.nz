/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	为什么使用集合？
 * 		实际上集合底层的实现就是数组，但为什么我们在开发中总是使用集合，数组很少见了
 * 		如果使用数组？
 * 				i.数组所有的方法需要开发者去编写
 * 				ii.数组比较死，数据类型比较单一，一旦有了新的类型，所有相关方法都需要翻新累死码农
 * 				iii.容量不可变，数组气死人的容量 一旦定义，就不可改变了 所谓的数组扩容就是创建新数组 将旧数组的数据放到
 * 					新数组中
 * 		集合了就比较优秀？
 * 				i.方法是现成的，基本满足与开发，我们只需要调一下就可以了
 * 				ii.集合适合全部类型，复用度极高
 * 				iii.容量可以动态改变，很好
 * 		实际上集合底层就是数组，之所以方法复用性那么好，与人家多态用的好，泛型用的棒  数据结构用的巧妙有关  
 * 		所以分析集合源码有助于咱们程序员水平的提高
 * 		首先就看集合的老祖宗接口 Collection<E>  你看，人家老祖宗上来就是泛型，你说好不好
 * 		collection<E>接口下有俩大接口
 * 				i. List<E> List接口  有序，可重复  List<E> 接口有三大实现类
 * 						i.ArrayList<E>   重点  在不考虑线程安全的情况下  优先使用这个
 * 						ii.LinkedList<E> 链表 还是双向的
 * 						iii.Vector<E>  线程安全（实现了线程同步）但是效率被严重影响
 * 				ii. Set<E> Set接口  无序  不可重复  俩大实现类
 * 						i.HashSet<E> 底层用HashSet表实现
 * 						ii.TreeSet<E>  底层用的是平衡二叉树
 * 						我有个想法自己补一下树，要不然真的很low比
 * 		现在来学习Collection<e>接口中的几个方法：
 * 				增：
 * 						i. boolean add(E e) 为当前集合添加元素 E是泛型  复用性很高
 * 						ii.boolean addAll(Collection<? extends E> c)  将集合c中的元素全部添加到当前集合
 * 									? extends E  规定集合c中存放元素类型的上限是E类型或者是E类型的子类型
 * 				删：
 * 						i.boolean remove(E e)  删除指定元素
 * 						ii.boolean removeAll(Collection<? extends E> c)  将当前集合与集合c的交集删除
 * 						iii.boolean retainAll(Collection<？extends E> c)   保留当前集合于集合c的交集 
 * 						iiii.void clear() 清除当前集合中的所有元素
 * 				查：
 * 						i. int size();  返回当前集合有效元素的个数
 * 						ii.boolean contain(E e)  查看当前集合是否含有e元素
 * 						iii.boolean contain(Collection<? extends E> c)  看集合c是否是当前集合的子集
 * 						iiii. boolean isEmpty() 查看当前集合是否为空
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo22 {

}
