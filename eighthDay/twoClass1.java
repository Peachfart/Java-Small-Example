package eighthDay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class twoClass1 {
	/*
	 * 	要求见twoClass
	 */
	
	public static void main(String[] args) throws IOException {
		System.out.println("请定义一个文件名");
		Scanner sc = new Scanner(System.in);
		
		String file = sc.next();
		File file_name = new File(file);
		if(file_name.exists()) {
			// 存在
			System.out.println("该文件存在,请输入内容");
		} else {
			// 不存在,这创建新文件
			file_name.createNewFile();
			System.out.println("新文件已经创建,请输入内容");
		}
		// 创建一个字节流,指定数据存储地
		FileOutputStream fos = new FileOutputStream(file_name + ".txt");
		// 将字节流强化,作用是可以写出字节
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		// 将字节流输出附加在字符流上边,使其可以输出单个字符
		BufferedWriter bw = new BufferedWriter(osw);
		// 强化字符流,使其可以输出整行字符
		PrintWriter pw = new PrintWriter(bw);
		
		for(;;) {
			System.out.println("请输入内容:");
			Scanner sc_msg = new Scanner(System.in);
			String msg = sc_msg.next();
			
			if(msg.equals("exit")) {
				System.out.println("程序结束");
			} else {
				pw.println(msg);
			}
			pw.close();
		}
	
	}
	
}
