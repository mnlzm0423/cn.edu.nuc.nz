/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	泛型在接口中的使用
 * 			1.在接口声明泛型和在类声明泛型是相同的
 * 			2.如何明确泛型的类型，或者说什么时候明确泛型类型
 * 					i.当实现类实现这个接口的时候，接口可以明确泛型，但实现类可以无视 这是自由模式
 * 					ii.当实现类实现这个接口的时候，接口也不明确泛型类型，子类与接口声明同名泛型，
 * 							这种情况就要在实现类创建对象的时候，对泛型进行明确，实现类泛型的名却会传递到
 * 							接口的同名泛型，接口的泛型也因实现类同名泛型的确定而确定
 * 			3.接口中泛型的使用
 * 					泛型可用于成员变量吗？不可以   接口泛型的指定一定要按照上面俩种方式   但是无论哪种方式
 * 					接口泛型的明确都比较靠后
 * 					而接口中的成员变量是公共静态常量  是随类文件的加载而放在堆区的方法区，必须是定义的时候就要初始化
 * 					而这时候根本没有什么对象，说明白了没？非常ok
 * 			接口中的泛型只能用于成员方法
 * 
 *  @author lizhimin
 *  @version 1.0
 */
interface A2<T> {
	void testA(T t);
}
class B2 implements A2<Integer> {

	@Override
	public void testA(Integer t) {
		// TODO Auto-generated method stub
		
	}
}
//-----------------以上就是接口在被实现的 时候自己将泛型的数据类型的明确------------
interface C<T> {
		void testC(T t);
}
class D<T> implements C<T> {

		@Override
		public void testC(T t) {
			// TODO Auto-generated method stub
			
		}
	
}


public class Demo19 {
		public static void main(String[] args) {
				D<String> d = new D<String>();
				d.testC("大西瓜");
		}
}
//以上这种方式，就是实现类继承了接口的泛型同名泛型，需要在实现类创建的时候才指定泛型的数据类型