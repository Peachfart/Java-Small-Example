package seventhDay;

import java.io.File;

public class threeClass {
	
	public static void main(String[] args) {
		// 遍历当前目录下所有的子目录
		File f = new File(".");
		// 判定
		// isDirectory() 判定当前存在的目录
		if(f.isDirectory()) {
			/* 
			 * listFiles() 它是建立在数组至上的(文件流类型的数组)
			 * 主要作用: 获取当前目录下所有的子目录,读取完成后,数据会以一个数组的形式返回到此程序中
			 * 每个数组中的元素就代表了一个子项
			 */
			File[] fs = f.listFiles();
			System.out.println("当前目录中子项的个数:" + fs.length);
			// 遍历当前数组中的元素
			for(int i = 0;i<fs.length;i++) {
				System.out.println("子项名:" + fs[i].getName());
			}
		}
	}

}
