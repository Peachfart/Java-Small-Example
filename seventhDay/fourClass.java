package seventhDay;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fourClass {
	
	public static void main(String[] args) throws IOException {
		// 读取文件中的内容
		/*
		 * Java.io.FileInputStream
		 * 文件输入流,用于读取原文件,读到内存中
		 * Java.io.FileOutputDtream
		 * 文件输出流,用于复制(输出)原文件内容
		 * 由于本身是一个字节流,所以需要添加byte(字节)数组,使其一次性多读一些内容
		 * 循环从原文件读取一组字节并写入到复制文件中,完成复制工作
		 * 
		 * 注意:工作完成后,要关闭这两个流,如果不关闭,会造成:1、磁盘空间占用,内存过载;2、电脑本机打不开原文件
		 * 
		 */
		
		FileInputStream fis = new FileInputStream("/Users/aeiou/Desktop/sevenDay.txt");
		FileOutputStream fos = new FileOutputStream("test.txt");
		// 使用输入流读取文件
		// 创建数组用于存储读取的字节
		byte[] b = new byte[1024];
		// 数据读完之后,会回复 -1 表示后面没有内容可读了
		int over = fis.read(b);
		
		// 在读之前需要设定读数据的长度,从什么地方开始
		/* 解释:
		 * String(b,0,over,"utf-8");
		 * b:一次读取的长度
		 * 0:从原文件起始位置开始读取
		 * over:规定读取到哪个位置
		 * “utf-8”:设定编码格式
		 */
		String s = new String(b,0,over,"utf-8");
		System.out.println(s);
		System.out.println("读取完成");
		// 读完以后写出到目标文件中
		String s2 = s;
		// 直接调用getBytes("")方法设定编码格式就可以了
		byte[] b2 = s2.getBytes("utf-8");
		fos.write(b2);
		System.out.println("写出完成");
		// 关闭输出流
		fis.close();
		fos.close();
	}

}
