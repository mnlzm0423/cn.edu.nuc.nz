/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;


/**
 *  1.现在有这么一个开发需求：王者荣耀的英雄，每个英雄都有QWER四个技能，但是每个英雄的QWER技能都是不一样的，对于一个常年做开发的人来说
 *  第一时间会想到做一个英雄父类里面有QWER这是个技能方法，每一个真正的英雄都去继承这个父类，重写QWER技能方法做到真正适合这个英雄，由于英雄
 *  众多，需要多人开发，有些程序员在做英雄的时候老是忘记重写技能方法，有什么合适的措施去解决这个问题了？如果不重写技能方法就会报错。。。
 *  
 *  4.加上abstract关键字，有用没用不知道但是程序时报错了。这是abstract的语法机制第一条 被abstract修饰的方法，不能写方法体，只能写方法声明
 *  那什么时候写方法的具体实现了？继承该类的子类，而且子类必须重写被abstract修饰的方法。
 *  Abstract methods do not specify a body
 *  抽象方法不能指定方法体
 *  
 *  
 *  5.你骗人的哇，我把方法体移除了以后，仍然会报错。这实际上是abstract语法机制的第二条，拥有abstract修饰的方法（抽象方法）的类必须被abstract修饰（即抽象类）
 *  也就是说还得在父类上加abstract关键字
 *  The type WangZheHero must be an abstract class to define abstract methods
 * 为了定义一个抽象方法， WangZheHero 类必须是一个抽象类
 *  
 *  6.父类终于不报错了但子类又错了，为什么？回到刚才的问题，咱们最初的目的是什么？子类忘记继承父类方法   加上abstract关键字，只要子类不重写abstract修饰的变量
 *  子类就会报错， 看看子类报错的原因 
 *  The type SheShou must implement the inherited abstract method WangZheHero.R()  
 *  解释：SheShou必须实现继承自WangZheHero的
 *  抽象方法R
 *  
 *  7.总结：抽象类是被abstract修饰的普通类（因此抽象类可以有普通类的所有成员，加上abstract关键字这个普通类可以容纳抽象方法了）     
 *               抽象方法是被abstract修饰的普通方法 因为被abstract修饰，方法不能有方法体了。（abstract修饰的方法没有方法体）
 *               抽象方法的载体类必是抽象类/接口
 *               类的继承是单个的
 *               抽象类是不能被实例化的
 *              
 *    
 *  @author lizhimin
 *  @version 1.0
 */

abstract class WangZheHero {
	public abstract void Q();
	public abstract void W();
	public abstract void E();
	public abstract void R();
	
}
class SheShou extends WangZheHero {
	public void Q() {
		System.out.println("具体Q技能");
	}
	public void W() {
		System.out.println("具体Q技能");
	}
	public void E() {
		System.out.println("具体Q技能");
	}
	//R技能忘记重写了
	@Override
	public void R() {
		System.out.println("射手大招");
		
	}
}

public class Demo02 {
	public static void main(String[] args) {
		SheShou sheShou = new SheShou();
		System.out.println("射手英雄技能展示：");
		sheShou.Q();
		sheShou.W();
		sheShou.E();
		sheShou.R();
		//2.由于未重写父类的R技能，导致射手英雄真正的R技能未展示出来，这是要命的事
		//3.为了解决这种问题，我们引入了abstract关键字，它的作用就是在将需要重写的方法在父类加上abstract关键字 这样只要继承父类，
		//子类就必须重写父类的方法，否则就会报错
	}
}
