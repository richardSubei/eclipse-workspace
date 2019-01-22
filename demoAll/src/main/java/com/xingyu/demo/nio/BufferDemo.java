package com.xingyu.demo.nio;

import java.nio.ByteBuffer;

public class BufferDemo {

	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(4);	//申请内存
		System.out.println(String.format("初始化：capacity容量: %s, position位置: %s, limit限制: %s", byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));
		byteBuffer.put((byte) 1);
		byteBuffer.put((byte) 2);
		byteBuffer.put((byte) 3);
		
		System.out.println(String.format("写入3字节后：capacity容量: %s, position位置: %s, limit限制: %s", byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));

		System.out.println("######开始读取");
		
		byteBuffer.flip();	//转换为读取模式	不转换也可以读数据，但是position位置不对
		byte a = byteBuffer.get();
		byte b = byteBuffer.get();
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(String.format("读取2字节后：capacity容量: %s, position位置: %s, limit限制: %s", byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));

		byteBuffer.compact();	//清除已阅读数据，未阅读数据从position为0的位置重新排列，clear清除整个缓冲区,

		byteBuffer.put((byte) 4);
		byteBuffer.put((byte) 5);
		byteBuffer.put((byte) 6);

		System.out.println("######开始读取");

		byteBuffer.flip();	//转换为读取模式	不转换也可以读数据，但是position位置不对
		System.out.println(byteBuffer.get());
		System.out.println(byteBuffer.get());
		System.out.println(byteBuffer.get());
		System.out.println(byteBuffer.get());

		System.out.println(String.format("最终情况：capacity容量: %s, position位置: %s, limit限制: %s", byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));

		
	}
}
