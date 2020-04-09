/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

import java.util.Arrays;

/**
 *   static修饰成员方法的用途：
 *   		1.静态成员方法摆脱了对象，需要的时候一加载，类名调用 。节省内存， 提高开发效率
 *   		2.静态方法不能使用非静态的成员变量和非静态的成员方法，但是外界传数据不影响
 *   		3静态方法常用于工具类  （Arrays 的 sort()  binarySearch() toString）	 
 *        工具类的分装
 *   static修饰代码块  静态代码块  里面声明的变量是局部变量   主要用于一些配置文件的加载
 * 
 *  @author lizhimin
 *  @version 1.0
 */

class MyArray {
	/* 工具类中大多是静态方法，为了方便 */
	/**
	 *    将数组逆序
	 * 
	 * @param arr  int[]  指定的整型数组
	 */
	public static void reverse(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
			
		}
	}
}

public class Demo9 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		MyArray.reverse(arr);
		System.out.println(Arrays.toString(arr));
	}
}
