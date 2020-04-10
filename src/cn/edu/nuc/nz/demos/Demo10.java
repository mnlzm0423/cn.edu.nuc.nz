/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 *  		接口：
 *  			生活中的接口，接口众多，我以USB接口为例   电脑上的USB接口  可以连接鼠标，键盘，U盘，麦克风使用
 *  			解释：1.鼠标，键盘，U盘，麦克风之所以都可以在这个USB接口上使用，是因为这些设备都实现了这个接口的规范
 *  					  2.各个产品在连接上这个接口以后，实现的不是相同的功能，而实现的是各自不同的功能  ：鼠标基准打击
 *  						键盘飞速码字  U盘读取资源 麦克风畅所欲言
 *  					    为啥？可以这样？接口的作用是什么？
 *  					♥接口的设计满足了普适性，没有接口的时候，各种厂家各种设备都有自己的特有的连接口，导致有的机器能用这
 *  						种设备，有的机器不能用这种设备，这样的设备不具有普适性，不仅销售具有局限性，而且导致市场混乱，不利于
 *  						大规模生产，这时接口出现了，USB接口出现了，所有设备只要将接口设计成USB的类型，所有机器只要实现了USB
 *  						接口，只要各个厂家设计设备的时候都按这个标准来，只要设备双方都遵循了这种规范你们就可以互联，完全摆脱
 *  						了厂家不同的限制，只要实现互联，而且实现接口对本身功能而言没有任何影响，各设备功能可以百花齐放，只要实现接口
 *  						
 *  						生活中的接口是什么？是规范，是一种统一，既完成了普适性而且对实现这种规范的事务不会产生任何功能上的影响
 *  						
 *  		          总  结 ：接口是什么？是一种规范  目的是什么？在不影响各自的功能情况下，完成普适性要求
 *  
 *  				编程上的接口又是什么？它同样是一种规范，比如webapp之所以可以在各种服务器上跑就是因为服务器和程序员都是遵循了一种
 *  				规范，什么规范，Servlet规范   这种规范就是编程中的接口，web程序遵从了这种规范（实现了接口）服务器遵循了这种规范，程序
 *  				就可以跑，这也就是常说的面向接口编程。
 *                            
 *           						
 *  
 *  @author lizhimin
 *  @version 1.0
 */
interface Servlet {
	int num  = 10;
	//协成员变量的时候发现俩点  
	//1.成员变量是斜体  经验说明它有一个缺省的权限访问修饰符-------static
	//报错了 错误是什么  The blank final field num may not have been initialized
	//被final修饰的成员变量没有初始化，说明它还有一个缺省的权限访问修饰符--------final
	//从outline来说该成员变量就是有一个绿色的圆圈（说明还有一个权限访问修饰符-------public）上面有S，F 标识   static   final
	
	//总结：接口的成员变量  隐藏了三个权限访问修饰符   public static final
	
	void test ();
	//发现接口的成员方法也报错了
	//报错原因：Abstract methods do not specify a body
	//抽象方法不能指定一个身体，原来这个成员方法也是也有缺省的权限访问修饰符j-----abstract
	//咱们再通过outline来看看是否还有咱们不知道的隐藏的权限访问修饰符发现它是一个绿色的大圆圈（果然还有权限访问修饰符-------public）
	//大绿点上的大写A说明了abstract这个隐藏的权限访问修饰符
	
	//总结：接口的成员方法缺省了权限访问修饰符序列是  public abstract
}

//下面类A实现了Servlet接口但是报错了    The type A must implement the inherited abstract method Servlet.test()
//A必须实现继承的抽象方法test（）
class A1 implements Servlet {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		//使用接口的成成员变量,可以使用成员变量
		int i  = num;
		//修改成员变量
		//num = 100;
		//The final field Servlet.num cannot be assigned
		//被final修饰的成员变量num 不能被赋值
	}
	
}
public class Demo10 {
		public static void main(String[] args) {
			//为什么接口的成员变量和成员方法有那些缺省的权限访问修饰符
			//接口是什么是规范 ； 规范是什么是定死的东西，如何体现 ？拥有一些不可修改的属性-------public static final
			//接口的方法设计成抽象的，设备要完成什么功能，接口是不管的，但必须写在某个特定的方法内  -------public  abstract
		
			
		}
}
