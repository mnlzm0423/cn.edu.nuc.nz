/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	接口的生活实例编写
 * 			i.定义一个USB接口
 * 			ii.定义一个键盘类是USB设备（所以要实现USB接口）
 * 			iii.电脑可以使用USB设备
 * 
 *  @author lizhimin
 *  @version 1.0
 */
/**
 * USB接口，是USB设备必须遵从的规范
 * 
 *  @author lizhimin
 *  @version 1.0
 */
interface USB {
	/**
	 * connection方法  是所有USB设备必须实现的方法
	 */
	void connection();
}
/**
 * 鼠标作为USB设备，必须遵从USB接口
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class Mouse implements USB {

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("鼠标链接USB接口，控制光标");
	}
}
/**
 * 键盘作为USB设备，必须遵从USB接口
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class KeyBoard implements USB {

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("键盘链接USB接口，作为输入设备");
	}
}
/**
 * 电脑使用USB接口，连接设备显示设备连接状态
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class Computer {
	/**
	 * 通过USB接口连接设备，展示连接状态
	 * @param usb
	 */
	void showConnection(USB usb) {
		usb.connection();
	}
}
/**
 * 罗技鼠标作为鼠标的一种，应当继承鼠标类
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class Logi extends Mouse {

	@Override
	public void connection() {
		System.out.println("罗技鼠标链接USB接口，控制光标");
	}
	
}
/**
 * 雷神键盘作为键盘的一种应当继承键盘类
 * 
 *  @author lizhimin
 *  @version 1.0
 */
class leiShen extends KeyBoard {

	@Override
	public void connection() {
		System.out.println("雷神键盘链接USB接口，作为输入");
	}
	
}
public class Demo12 {
		public static void main(String[] args) {
		//1.完成功能：生产鼠标，键盘（usb设备） 电脑使用USB接口连接键盘鼠标
			//生产鼠标，键盘（usb设备）
			Mouse mouse = new Mouse();
			KeyBoard keyBoard = new KeyBoard();
			//电脑使用USB接口连接键盘鼠标
			new Computer().showConnection(mouse);
			new Computer().showConnection(keyBoard);
		//电脑现在就要链接Logi鼠标和雷神键盘
			Logi logi = new Logi();
			leiShen leiShen = new leiShen();
			new Computer().showConnection(logi);
			new Computer().showConnection(leiShen);
			
		//我想要罗技鼠标有自己的特有显示  雷神键盘也有自己特有的显示
		//即需要罗技鼠标和键盘重写connection（）方法
			new Computer().showConnection(logi);
			new Computer().showConnection(leiShen);
			
	}
	
}
