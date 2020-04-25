/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

import java.io.File;

/**
 * 	对于非盘符和盘符路径的书写：
 * 			i.对于盘符路径的书写，我们必须无论是写成（以c盘为例）c:  还是  c:\\  都是正确的，在以这俩种路径创建的file对象
 * 				用file对象的getAbsolutePath（）方法获取的绝对路径都是具有 \的 结果是               c:\
 * 			ii.对于非盘符路径的书写来说（这里重点指目录）我们无论将路径写成c:\\intel还是写成c:\\intel\\，我们以这俩种路径
 * 				创建的file对象 通过调用file对象的getAbsoutePath（）方法获取的绝对路径都是末尾都是不带\\的 
 * 				结果是c:\intel
 * 			我们在进行目录拷贝的时候，有源头file  还有目标file   我们需要将源头file的东西拷贝到目标file所对应的目录中
 * 			我们需要对源头file的  getAbsolutePath（）方法获取的绝对路径进行截取字符串操作，获取绝对路径的字符串
 * 			第三个字符之后的东西srcFile.getAbsolutePath().subString(3);  
 * 			这才是正确截取字串了但是对于在目标文件夹新建的目录的路径才完成了一半，还需要将目标文件夹拼接上去
 * 			targetFile.getAbsolutePath() + srcFile.getAbsolutePath().subString(3) 
 * 			由于我们不知道目标文件夹到底是一个根还是跟下的文件夹所以我们的处理方式是不一样
 * 					对于盘符来说  获取到的绝对路径的末尾会自动添加\
 * 					但是对于非盘符文件夹来说  获取到的绝对路径末尾是不会自动添加\
 * 			我们并不会预先知道目标文件夹是在盘符下，还是盘符下的一个普通文件夹，为了程序的普适性，我们需要对获取的
 * 			目标文件的绝对路径加以判断 如果如果是以\结尾的我们就按getAbsolutePath（）方法获取的绝对路径进行拼接
 * 			如果用个体AbsolutePath（）方法获取到的路径不是以\结尾，我们就在getAbsolutePath（）方法获取到的绝对
 * 			路径后面添加\\(由于\在Java中具有转义的功效所以要想获取\ 需要写\\)
 * 			(targetFile.getAbsolutePath().endWith("\\") ? targetFile.getAbsolutePath() : target.getAbsolutePath() + "\\") + 
 * 			srcFile.getAbsolutePath().subString(3);
 * 			这就行了！！！
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
