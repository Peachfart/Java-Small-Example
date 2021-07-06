package seventhDay;

import java.io.File;

public class twoClass {
	
	public static void main(String[] args) {
		// 删除文件
		File f = new File("pic");
		// 通过 exisits() 方法判定该文件或目录是否存在
		if(f.exists()) {
			// 存在
			System.out.println("准备删除");
			f.delete();
			System.out.println("删除成功");
		} else {
			// 不存在
			System.out.println("该目录或文件不存在");
		}
	}
}
