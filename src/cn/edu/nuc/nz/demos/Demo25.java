/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	LinkedList的学习：
 * 			链表是什么？ 就像是自行车车链子  是由一个一个小结点列在一起  形成一根长链
 * 			生活中常常发生自行车链子断裂的情况，一般是由于其中一个节点坏了，我们只需
 * 			要将这个小结点移除（断前，断后，移除小结点），然后将前后连起来就行了    这就是
 * 			链表的删除，有时候觉得链子有点紧了，不好骑。我们就将前后断开，加入一个小结点
 * 			将小结点与前面连在一起，将小结点与后面连在一起，这就是链表的添加。
 * 			那么每一个小结点是什么样的了，要想它可与前节点连，又与后节点连是不是需要在节点本身
 * 			上弄俩个接口，一个供前一个节点连，一个供后一个节点连 这样小结点模型也出来了
 * 	
 * 			链表的增加和删除：
 * 					链表的删除操作
 * 					对于单向链表来说：我们要想在某个位置删除一个节点，我们需要找到被删除节点的前一个结点，然后根据它的
 * 					next找到被删除元素    然后将被删除元素的前一个结点的next（nodep.next）修改为 被删除节点的下一个节点
 * 					(node.next)  整个操作就是nodep.next = node.next;  最后清空node节点 node = null;这样就完成了删除操作
 * 					有一个问题为什么要删除某个节点，先找的确实被删除节点的下一个节点？
 * 							i.链表结构特殊，我们找元素的时候不可能一步到位，需要从头根据头节点的next节点的找到下一个节点
 * 								然后再根据下一个节点的next找到下下一个节点
 * 							ii. 其次对于单向链表来说，每个节点只有一个指向那就是指向下一个节点的地址next，如果我们首次找的
 * 								找的是被删除节点，那么我们就没办法将被删除节点的前一个结点与被删除节点的后一个节点连接起来
 * 								因为根据被删除节点就找不到前一个节点， 如果想找，还得再从头找，但是了，我们找到被删除节点
 * 								的前一个结点（nodep），我们就可以根据这个节点(nodep)的next找到被删除元素(node)，然后再
 * 								根据被删除节点(node)的next找到下一个节点(noden)，这样我们我们就在一次查询过程中找到了删除
 * 								操作的三大节点  前节点（nodep）  被删除节点（node） 后节点（noden）
 * 								node = nodep.next;
 * 								nodep.next = node.next;
 * 								node = null;  让node节点指向的那个节点对象变成无主内存，最后被gc掉
 * 					对于双向链表来说我们的每一个节点既有前指针（pre） 又有后指针（next）所以我们在做删除操作的时候直接
 * 					被删除元素（node） 根据被删除元素的前指针（pre） 找到前一个结点（nodep） 然后根据被删除节点的next
 * 					找到被删除元素的后一个节点（noden）然后我们就可以进行删除操作了：
 * 								nodep = node.pre;
 * 								noden = node.next;
 * 								nodep.next = noden;
 * 								noden.pre = nodep;
 * 								node = null;
 * 								这样就完成了双向链表的删除操作
 * 								实际上这种删除还是有连在一起的写法的.如何写？
 * 								node.pre.next = node.next;
 * 								node.next.pre = node.pre;
 * 								node = null;
 * 			链表的增加
 * 				链表增加的原理（在指定位置增加）就是  创建新的节点  然后找到插入位置根据插入位置找到对应节点，然后将新增
 * 				节点与这个节点连起来  该位置前面一个节点也应该与新增节点连起来，这样才能做到无缝对接
 * 				
 * 				对于单向链表的增加操作：再问一下增加操作是直接 找那个位置  还是找前一个位置，应该是找一个位置  如果直接找添加
 *  			位置，就无法找到前一个位置的节点，完不成前一个结点与新增节点的对接
 *  			i.创建新节点  nodeN      
 *  			ii.首先找到添加位置的前一个位置对应的那个节点（nodep）
 *  			iii.然后根据nodep的后指针域（next）找到添加位置对应的那个节点
 *  			iiii.然后将新节点赋值给前一个结点的后指针域（next	）
 *  			iiiii.再将新增节点的后指针域（next）指向原来这个位置的节点
 *  			Node nodeN = new Node();
 *  			Node node = nodep.next();
 *  			nodep.next = nodeN;
 *  			nodeN.next = node;
 *  			这样就完成了新增节点的添加
 *  			
 *  			对于双向链表的添加操作：
 *  					由于双向链表的每一个节点都有前指针域和后指针域 不必担心直接照这个位置的节点，还得重新找前一个结点
 *  				i.创建新节点
 *  				Node nodeN = new Node();
 *  				ii.找到添加位置对应的节点(node)
 *  				iii.将前一个节点的后指针域指向新节点
 *  				node.pre.next = nodeN;
 *  				iiii.然后将新节点的前指针域指向前一个结点；
 *  				nodeN.pre = node.pre;
 *  				iiii.再将新节点的后指针域指向当前位置节点
 *  				nodeN.next = node;
 *  				iiii.最后将旧节点的前指针域指向	新增节点
 *  				node.pre = nodeN;
 *  				这样双向链表的增加操作完成了
 *  		LinkedList<E>接口的特征方法：
 *  				添加方法：addFirst()  添加到第一个（每次添加到第一个）
 *  								  addLast()  添加到最后一个 （每次添加到最后一个）
 *  				获取方法： getFirst()  每次获取第一个元素
 *  								  getLast() 每次获取最后一个元素
 *  				删除方法：removeFirst() 每次删除当前第一个元素
 *  								  removeLast() 每次删除最后一个元素
 *					对于链表有俩个特殊的应用：
 *					栈：先进后出  push入栈     pull出栈（栈的特征就是从一个口进行添加和获取删除，导致了后进先出的现象）
 *					一套组合拳： addLast() 始终在末尾添加元素
 *										   getLast() 始终从末尾获取元素
 *										   removeLast() 始终从末尾删除元素
 *					必须明确栈为什么有先进后出的特征现象  就是因为栈始终在一个口进行增加获取删除
 *					队列：先进先出 （导致先进先出的特征现象的本质是因为添加的时候是从尾部添加，获取（删除）的时候是从首部）
 *					也就是说添加和获取就不在一个口上
 *					添加的时候用  addLast()  添加的时候始终在尾部添加
 *					获取的时候用  getFirst() 获取的时候始终从头部获取
 *					删除的时候用 removeFirst（）删除的时候也始终在头部删除
 *
 *					讲了这么多首先我们讲讲节点的设计吧   java设计语言讲究世间万物都是对象  那么节点也是对象了   想要有对象
 *					首先应该创建节点类  节点类如何创建？
 *					节点三大要素（双向链表）前引用   后引用  节点元素（Object）
 *					class Node {
 *							private Node pre;
 *							private Node next;
 *							private Object obj;
 *							public Node() {}//无参构造方法用于创建节点
 *							public Node( Object obj) {this.obj = obj}//有参构造方法用于创建节点同时初始化节点元素
 *					}
 *					我们还需要一个节点管理员MyLinkedList
 *					java思想世间万物都是对象  管理员是对象   那么就先要有管理员类 
 *					管理员掌控链表俩大要素   链表头节点的节点引用    链表的节点个数
 *					class MyLinkedList {
 *							private Node head;
 *							private int size;
 *					}
 *								
 *  		
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo25 {
		public static void main(String[] args) {
			
		}
}