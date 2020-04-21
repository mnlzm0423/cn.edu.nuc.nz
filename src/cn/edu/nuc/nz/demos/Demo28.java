/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

import java.io.File;

/**
 * 
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo28 {
		public static void main(String[] args) {
				File file = new File("c:\\");
				if (file.exists()) {
					 	System.out.println("c盘存在");
					 	System.out.println(file.getAbsolutePath());
				} else {
					System.out.println("所指文件或目录不存在");
				}
		}
}
