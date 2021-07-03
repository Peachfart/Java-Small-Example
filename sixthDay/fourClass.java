package sixthDay;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/* IO:Input,Output Java中传输数据标准的输入输出
 * JavaIO 是以标准的操作对外界设备进行数据交换并将读和写分为输入和输出,
 * IO 是顺序读写方式,只能向后进行读或写操作,不能够同时读与写
 * 
 * Java.io.IputStream 字节输入流,规定了读字节的相关方法
 * 
 * Java.io.OutStream 字节输出流,规定了写字节的相关方法
 * 
 * Java当中将流分为两类 节点流 处理流(也叫低级流与高级流)
 * 节点流: 真实链接数据源与程序之间的管道,真实负责搬运数据的流,读写一定是建立在节点流的基础上进行
 * 
 * 处理流: 不能独立存在的,必须建立在节点流上,使得节点流在读写数据的过程中,当数据流经过当前处理流时,
 * 对其进行加工处理,(增强传输速度),简化我们对数据传输的相关操作
 * 
 * 实际应用中,我们经常会串联一组甚至多组高级流连接低级流,使得对数据的读写以流水线的形式加工读写,
 * 以到达快速处理数据的目的,这个过程被称为流的连接,也是IO的精髓所在
 * 
 * 文件流
 * 文件流是一对节点流,用于对文件进行读写的流,文件流是顺序读写形式,基于文件流可以完成复杂的数据读写操作
 * 
 *  **/


public class fourClass {
	public static void main(String[] args) throws IOException {
		// Java中管理文件的Class:File
		// File 在使用的时候,可以根据给出的路径创建指定类型的文件
		File f = new File("/Users/aeiou/Desktop/heiguafu.txt");
		// 判断当前目录下文件是否存在,如果存在则不操作,如果不存在则创建一个
		if (f.exists()) {
			System.out.println("该文件已存在");
			
		} else {
			f.createNewFile();	// 创建该文件
			System.out.println("文件已创建");
		}
	}
}
