package seventhDay;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fiveClass {
	
	/* BufferedInputStream 高级流,缓冲高级流
	 * BufferedInputStream 在流连接的作用是加快数据的读写效率(它们会将读写的数据统一转换为块读写,
	 * 以达到最高效率的目的
	 * 
	 * 要达到高级流必须建立在字节流之上
	 * @throws FileNotFoundException
	 */
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("xiaoze.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("canlaoshi.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// 规定一次读取的字符
		byte b[] = new byte[1000];
		// 由于文件内容读完后会返回值-1,代表读取完成
		int end = -1;
		// System.currentTimeMillis() 是 Java 中的毫秒表,运行此代码可以记录毫秒时间
		long start_time = System.currentTimeMillis();
		// 判断读到的数据,如果读到-1就不读了
		while ((end = bis.read(b)) != -1) {
			bos.write(b);
			break;
		}
		long end_time = System.currentTimeMillis();
		System.out.println("读取完成,总耗时:" + (end_time - start_time) + "毫秒");
		// 关闭当前使用的流
		bis.close();
		bos.close();
	}

}
