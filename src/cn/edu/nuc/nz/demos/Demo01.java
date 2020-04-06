/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;



/**
 * 	1.继承带来的问题：子类继承父类，就会将父类的所有非私有化成员变量，成员方法都继承过来
 * 但是有时候子类虽然有和父类一样的行为特征，但是具体实现是不一样的，
 * 这就要涉及到父类对子类方法重写了
 * 
 * 7.解决：2到6  知识点：方法的重写
 * 
 *  @author Bob
 *  @date 2020/4/5
 *  @version 1.0
 */
class Father {
	public Father() {
		System.out.println("子类的构造器自动调用，父类的无参构造方法");
	}
	public void  work() {
		System.out.println("机械工程师");
	}
	public void game() {
		System.out.println("黄金矿工");
	}	
}
class Son extends Father {
	//2.（父类的方法不适用子类，但是子类又有和父类一样的行为特征）子类对父类的方法进行重写
	@Override
	public void work() {
		//3.这里就是子类重写父类的work方法，子类重写父类的方法 子类的方法声明必须和父类保持一致
		//4.@Override注解是对重写方法的严格格式检查（子类重写父类的方法的方法声明必须和父类保持一致）
		System.out.println("码农");
	}
	
	@Override
	public void game(){
		//5.这个方法也是子类重写父类的方法
		System.out.println("看小说");
	}
	
}
public class Demo01 {
	public static void main(String[] args) {
		Son son = new Son();
		son.work();
		son.game();
		
	}
}
