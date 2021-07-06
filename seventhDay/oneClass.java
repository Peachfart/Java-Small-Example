package seventhDay;

import java.io.File;

public class oneClass {
	public static void main(String[] args) {
		// 使用File文件流创建目录
		// 创建文件夹时指定目录
		File f = new File("pic");
		// 判断该目录是否存在
		// exists() 通过这个方法判定文件目录是否存在
		if(f.exists()) {
			// 存在
			System.out.println("该目录存在");
		} else {
			// 不存在
			f.mkdirs();
			System.out.println("该目录已创建成功");
		}
	}
	
	
}
