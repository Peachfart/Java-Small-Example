package eighthDay;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class oneClass {
	public static void main(String[] args) throws FileNotFoundException {
		// PrintWriter 高级流
		/*
		 * 可以字节写入字符,不需要创建数组.其使用print()方法,将内容直接输出
		 * println()该方法可以将输出的内容刷新
		 */
		
		FileOutputStream  fos = new FileOutputStream("xiaoze.txt");
		// 字节流,它可以将读取到的直接输出
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		// 添加字符流,将字节转换为字符(一次输出单个字符)
		BufferedWriter bos = new BufferedWriter(osw);
		// 最后添加 PrintWriter 将内容写到txt文件中
		PrintWriter pw = new PrintWriter(bos);
		
		String msg = "三楼楼长";
		
		// 使用 PrintWriter 中的 println() 方法将内容写入
		pw.println(msg);
		// 关闭流
		pw.close();
	}
}
