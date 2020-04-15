/*
 *   中北大学软件学院(c) 版权所有 2020-2021.
 */
package cn.edu.nuc.nz.demos;

/**
 * 	针对项目中的排序算法，我们只做了总分的降序排序，但现实生活中我们可能要根据学生的各科成绩进行排名，甚至于
 * 按年龄去排序，然而整个排序算法的核心是没有发生改变的，如果我们不对方法进行改进，那么我们需要针对各个属性
 * 都写一次排序算法，而在实际项目开发过程中一个对象可能需要比较的字段是二三十个，怎么我们要根据根据这么多
 * 字段，在这个类中写二三十个排序算法，你觉得这样行吗？答案是否定的。
 * 			现在来分析一下排序算法
 * 			for (int i = 0; i < arr.length - 1; i++) {
 * 					int index = i;
 * 					for(int j = i + 1; j <arr.length; j++) {
 * 							if (arr[index].getTotal() > arr[j].getTotal()) {
 * 									index = j;
 * 							}
 * 					}
 * 					if (index != i) {
 * 							Student student = arr[index];
 * 							arr[index] = arr[i];
 * 							arr[i] = student;
 * 					}
 * 			}
 * 		所有字段的排序算法都是这个   核心就是  二次循环里的那个条件判断   那是比较的核心，根据不同的 字段有不同的写法
 * 但是都是student.get字段   只要保证每次换他就行 我们能否通过方法的参数决定到底要比较那个字段？字符串拼接有点丑陋
 * 我们换一个角度，我们是否能将这个比较核心做成一个方法，有人说一句话不写你写一个方法，不要看眼前，假如写一个方法
 * 就能解决这个核心，我们就不用每个字段写这么排序算法了，我们将用一个简短的方法代替这个核心  而这个排序算法将会被所有
 * 字段所共用，看看如何抽取方法  
 * 					第一   方法的返回值是if语句的结果   boolean
 * 					第二   方法的参数是俩个Student类型的对象，即这个方法有俩个形式参数 形式参数列表（Student s1，Student s2）
 * 					这样，方法的入口形式参数列表有了，方法的返回签名有了   只差个方法名我们就完成了眼前的封装
 * 					public boolean compareCore（Student s1, Student s2);这就是比较核心的方法声明，我们实现了这个方法套用在比较算法里不就行了吗
 * 					如何实现？
 * 					1.针对总分进行降序排列
 *						 	public boolean compareCore(Student s1, Student s2) {
 *									//如何实现  降序  我们这个方法的任务是什么  只是将传进来的俩个参数的某个字段进行比较就可以了
 *									//现在是降序排列  我们需要前面排大的，如果前后比较小  则交换，这个方法做的就是判断前面的是否小于后面的返回
 *									//结果就行  如果是降序我们需要的就是前面是大的小就交换  如果是升序前面是小的  如果前面大就交换
 *									return s1.getTotal() < s2.getTotal();								
 *							}	
 *					2.针对年龄进行降序排列
 *						public boolean compareCore(Student s1, Student s2) {
 *								//针对年龄  降序  前面要大的
 *								return s1.getAge() < s2.getAge();
 *						}		
 *					3.针对mathScore进行升序排列
 *						public boolean compareCore(Student s1, Student s2) {
 *								//针对mathScore  升序  前面要小的
 *								return s1.getMathScore() > s2.getMathScore();
 *						}		
 *						......
 *					我们发现针对不同的字段我们方法的是现实不同的 但是规范一样（都需要俩个Student对象  返回值是true）
 *					像这样既有规范又实现不同的东西----我们学过什么  抽象方法  对就是抽象方法  方法声明是规范 子类或实现类完成具体实现
 *					public abstract boolean compareCore(Student s1, Student s2);
 *					但是独立的抽象方法又是不能独立存在的需要一个接口或者是抽象类 用接口  
 *					public interface Compare {
 *							//里面放咱们的比较核心
 *							boolean compareCore(Student s1, Student s2);
 *					}
 *					具体实现针对不同字段
 *					public class TotalCompareAsc implements  Compare {
 *							//具体实现
 *							public boolean compareCore(Student s1, Student s2) {
 *									return s1.getTotal() > s2.getTotal();
 *							}
 *					} 
 *					感觉也没少，mmp  不对少了不少   你看接口就写一个公用    实现类就实现一个方法  方法内部就一句话
 *				比起一个字段写是多行还是轻松的，现在就看最后几步   就是我们如何将这个算法核心放进去，通过真正的
 *				比较方法的形参列表  传一个实现类对象   然后  通过对象调用比较核心方法   
 *					public void xxx(总分比较实现类  对象引用) {
 *							if (对象引用.方法) {
 *							}
 *					}
 *				//这就行了，但是了，如果把具体某一个字段的实现类当成是形参  那么其他字段的实现类对象将没有办法传进来
 *				直接使用那个接口做方法的形参所有的比较核心实现类对象就都课传进去了  这就是多态扩大参数范围  
 *				运用了抽象方法的规范和多样化实现  接口做抽象方法的载体  利用多态实现了入参范围的扩大化
 *
 *				代码实际没少多少重要的是思想  代码的封装分成方法  抽象方法的规范和多样化的实现   接口作抽象方法载体
 *				利用接口做形参 实现传值多样化  多态的封装     
 *				
 *				以上思想是好但是了，几十个实现类就有点尴尬了，能不能有东西可以只实现方法不用 写那么多类  匿名类知识点
 *
 *  @author lizhimin
 *  @version 1.0
 */
public class Demo20 {

}
