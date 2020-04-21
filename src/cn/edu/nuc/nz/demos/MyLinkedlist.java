/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 	 MyLinkedList的实现
 * 			
 *  @author lizhimin
 *  @version 1.0
 */
public class MyLinkedlist<E> {
		/**
		 * first始终指向链表第一个节点，始终是第一个节点的引用
		 * 
		 */
		private Node<E> first;
		/**
		 * last始终指向链表最后一个节点，始终最后一个节点的引用
		 */
		private Node<E> last;
		/**
		 * 链表有效元素的个数
		 */
		private int size;
		/**
		 * 静态节点内部类
		 * 
		 *  @author lizhimin
		 *  @version 1.0
		 */
		private static class Node<E> {
				/**
				 * 前节点引用
				 */
				Node<E> pre;
				/**
				 * 后节点引用
				 */
				Node<E> next;
				/**
				 * 节点元素
				 */
				E element;
				/**
				 * 无参构造方法用于创建节点对象
				 */
				//public Node() {}
				/**
				 * 	创建新节点
				 * @param pre  新节点的前节点引用  符合泛型约束
				 * @param element 新节点元素  符合MyLinkedList的类 泛型约束的数据类型的元素
				 * @param next  新节点的后继节点的引用  符合泛型类型
				 */
				Node(Node<E> pre, E element, Node<E> next) {
						this.pre = pre;
						this.next = next;
						this.element = element;
				}
		}
		
		/**
		 * 用于创建链表管理员
		 */
		public MyLinkedlist() {}
		/**
		 * 	添加一个符合MylinkedList类 泛型约束数据类型元素（尾插法）
		 * 
		 * @param e  符合泛型约束的数据类型的元素
		 * @return 添加成功返回true，添加失败返回false
		 */
		public boolean add(E e) {
				//获取最后一个节点的引用（成员变量last始终指向链表的最后一个元素）
				Node<E> l = last;
				//创建一个新节点
				Node<E> newNode = new Node<E>(l , e, null);
				//因为新节点被添加所以last就成了指向新节点的引用
				last = newNode;
				//如果是第一次添加需要将这个节点的引用交给成员变量first
				if (first == null) {
					first = newNode;
				}else {
					//否则需要将上一个节点的与新节点链接起来
					l.next = newNode;
				}
				//链表有效元素的个数加1
				size++;
				return true;
		}
		/**
		 *  在链表尾部添加一个符合MylinkedList类 泛型约束数据类型的元素
		 *  
		 * @param e   指定的符合MylinkedList类  泛型约束数据类型的元素
		 * @return  添加成功返回true 添加失败返回false
		 */
		public boolean addLast(E e) {
				return add(e);
		}
		/**
		 * 	在链表首部添加元素（元素符合MyLinkedList类 约束的泛型数据类型）需要改变3个指向  
		 * 		i.链表头（first）的指向
		 * 		ii.新节点后缀引用（next）的指向
		 * 		iii.旧节点的前缀引用（pre）的指向
		 * 
		 * @param e  符合泛型约束的数据类型的元素
		 * @return  添加成功返回true   添加失败返回false
		 */
		public boolean addFirst(E e) {
				//首先保存保存链表头first
				Node<E> f = first;
				//创建新节点  前缀引用就是以前链表的头节点（即first指向的节点 即f）
				Node<E> newNode = new Node<E>(null, e, f);
				//修改链表头first的指向（指向新节点）
				first = newNode;
				//判断是否是第一个节点，如果是第一个节点，则无需考虑链接问题；如果不是第一个节点，需要考虑链表连接问题
				if (null == f) {
						last = newNode;
				}else {
						f.pre = newNode;
				}
				//修改链表有效元素的数量
				size++;
				return true;
		}
		/**
		 * 	获取链表的第一个节点的元素值
		 * 
		 * @return  返回第一个节点的元素值
		 */
		public E getFirst() {
				//判断链表是否为空
				if (null == first) {
						throw new NoSuchElementException("当前链表是空，无元素返回");
				}
				return first.element;
		}
		/**
		 * 	获取链表的尾节点元素
		 * 
		 * @return  返回尾节点元素
		 */
		public E getLast() {
				//判断链表是否为空
				if (null == first) {
						throw new NoSuchElementException("当前链表是空，无元素返回");
				}
				return last.element;
		}
		/**
		 * 	获取指定下标的元素 下标必须符合一定范围
		 * 
		 * @param index  指定下标   
		 * @return 返回下标所对应的节点元素
		 */
		public E get(int index) {
				//首先查看下标是否合法
				if (index < 0 || index >= size) {
						throw new IndexOutOfBoundsException("指定下标越界");
				}
				//由于链表查询太慢，所以采用对半查
				
				if (index <= (size >> 1)) {
						Node<E> node = first;
						for (int i = 0; i < index; i++) {
								node = node.next;
						}
						//跳出循环的时候，此时node正是下标为index的元素
						return node.element;
				} else {
						Node<E> node = last;
						for (int i = size - 1; i > index; i--) {
								node = node.pre;
						}
						//跳出循环的时候，此时node正是下标为index的元素
						return node.element;
				}
		}
		/**
		 * 移除尾节点元素   链表为空，直接报异常；
		 * 								链表中只有一个元素，我们需要将last = last.pre; if (null == last) {first = null};
		 * 								链表中有多个元素， last = last.pre; last.next = null; 
		 * 								
		 * @return 返回被移除元素 
		 */
		public E removeLast() {
				Node<E> l = last;
				//查看当前集合是否是空集合
				if (null == l) {
						throw new NoSuchElementException("集合为空，无法删除");
				}
				//确认该集合不是空集的时候需要将旧尾节点的元素值保存下来，同时根据它的pre找到下一个尾节点的继承节点
				E e = l.element;
				Node<E> preNode = l.pre;
				//做完上面俩件事，l就应该准备消亡了，一下操作有助GC
				l.element = null;
				l.pre = null;
				//将新尾节点继承者变为尾节点
				last = preNode;
				if (null == preNode) {
						//该集合只有一个元素
						last  = null;
				} else {
						//该集合有多个元素，就应该考虑连接问题了
						preNode.next = null;
				}
				//修改链表的有效元素
				size--;
				return e;
				
		}
		/**
		 * 	删除链表的第一个元素   链表中无元素，抛异常；
		 * 										  链表中只有一个元素Node<E> node = first; E e = node.element; first = first.next; if (null == first) last = null
		 * 										  链表中有多个元素  first.pre = null;   
		 * 
		 * @return 返回被删除节点的元素值
		 */
		public E removeFirst() {
				Node<E> fNode  = first;
				if (null == fNode) {
						throw new NoSuchElementException();
				}
				E e = fNode.element;
				Node<E> nextNode = fNode.next;
				fNode.element = null;
				fNode.next = null;
				first = nextNode;
				if (null == nextNode) {
						last = null;
				} else {
						nextNode.pre = null;
				}
				//修改链表的有效元素
				size--;
				return e;
		}
		/**
		 * 	展示链表集合（LinkedList）
		 */
		public void show() {
				Node<E> node = first;
				if (null == node) {
						return;
				}
				for (int i = 0; i < size; i++) {
						System.out.print(node.element + "--->");
						if (i == size - 1) {
							System.out.print(node.element);
						}
						node = node.next;
				}
		}
		/**
		 * 	删除指定下标元素
		 * 
		 * @param index  指定下标
		 * @return  删除成功返回被删除元素，删除失败返回null
		 */
		public E remove(int index) {
				if (index < 0 || index >= size || 0 == size) {
					throw new NoSuchElementException();
				}
				Node<E> node = first;
				Node<E> preNode = null;
				Node<E> nextNode = null;
				Node<E> delNode = null;
				E delElement = null; 
				if (index == 0) {
						return removeFirst();
				} else if (index == size - 1) {
						return removeLast();
				} else {
						for (int i = 0; i < size; i++) {
								if (i == index) {
										delNode = node;
										break;
								}
								node = node.next;
						}
						if (delNode != null) {
								delElement = delNode.element;
								preNode = delNode.pre;
								nextNode = delNode.next;
								preNode.next = nextNode;
								nextNode.pre = preNode;
								delNode.pre = null;
								delNode.next = null;
								delNode.element = null;
								size--;
						}
						return  delElement;
				}
				
		}
		/**
		 * 	删除集合中指定元素
		 * 
		 * @param object  指定的元素
		 * @return 删除成功返回true，失败返回false
		 */
		public boolean remove(Object object) {
				boolean flag = false;
				Node<E> node = first;
				int delIndex = -1;
				for (int i = 0; i < size; i++) {
						if (node.element.equals(object)) {
								delIndex = i;
								break;
						}
						node = node.next;
				}
				if (delIndex != -1) {
						 remove(delIndex);
						flag = true;
				}
				return flag;
		}
		/**
		 * 	将指定下标的元素修改为指定元素
		 * 
		 * @param index 指定下标
		 * @param e  指定元素，必须符合MyLinkedList类 泛型约束的数据类型 
		 * @return  修改成功返回被修改的元素，修改失败返回null
		 */
		public E set(int index, E e) {
				Node<E> node = first;
				Node<E> modifiedNode = null;
				E e1 = null;
				if (index < 0 || index >= size) {
						throw new IndexOutOfBoundsException();
				}
				for (int i = 0; i < size; i++) {
						if (i == index) {
								modifiedNode = node;
								break;
						}
						node = node.next;
				}
				if (modifiedNode != null) {
						e1 = modifiedNode.element;
						Node<E> preNode = modifiedNode.pre;
						Node<E> nextNode = modifiedNode.next;
						modifiedNode.pre = null;
						modifiedNode.next = null;
						modifiedNode .element = null;
						Node<E> newNode = new Node<E>(preNode, e, nextNode);
						preNode.next = newNode;
						nextNode.pre = newNode;
				}
				return e1;
		}
	
		
}
