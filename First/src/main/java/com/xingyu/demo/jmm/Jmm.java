package com.xingyu.demo.jmm;

/**
 * 本例子主要讲解利用javap命令得到字节码指令，进一步分析对堆栈内存
 * @author forever11270201
 *
 */
public class Jmm {

	public static int x = 100;
	
	public static void main(String[] args) {
//		int a = 500;
//		int b = 600;
//		a++;
//		b = a + b;
		
		Jmm jmm = new Jmm();
		int y = 500;
		y = y + Jmm.x;
		
	}
}
