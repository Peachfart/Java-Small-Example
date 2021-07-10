package eighthDay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class twoClass {
	/*
	 * 1.让用户创建一个txt文件,并在程序运行是指定文件名
	 * 2.用户可以在控制台区域输入文字内容,程序需将输入的内容存到txt文件中
	 * 3.用户可以无限次输入内容,但是当用户输入exit时,程序退出并结束
	 */

	
	public static void main(String[] args) throws IOException {
		
		System.out.println("请输入你想要创建txt文件的目录:");
		Scanner sc_dir = new Scanner(System.in);
		String line = sc_dir.nextLine();                   
        File dir = new File(line);
        // System.out.println(dir);
        System.out.println("请输入你要创建txt文件名:");
        Scanner sc_name = new Scanner(System.in);
        String name = sc_name.next();
        // 注意,Windows电脑要将/改为//
        String file = dir + "/" + name;
        System.out.println("你要创建txt文件的完整路径为:" + dir + '/' + name);
        File doc = new File(file);
        try{
            if(doc.createNewFile()) {
                System.out.println("文件创建成功！");
            } else {
                System.out.println("出错了，该文件已经存在。");
                
            }
        }catch(FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        doc.createNewFile(); 
        BufferedWriter out = new BufferedWriter(new FileWriter(doc));
                
        for(;;) {
	        System.out.println("请输入你想在txt文件中输入的内容,如果输入exit则退出输入:");
	        Scanner sc = new Scanner(System.in);
	        String msg = sc.next();

			if (msg.equals("exit")) {
				out.close(); 
            	break;
            }
			out.write(msg);
        }
	}
}
