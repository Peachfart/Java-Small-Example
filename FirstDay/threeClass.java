package FirstDay;

import java.util.Scanner;

public class threeClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("在干嘛呢？");
        try (Scanner sc = new Scanner(System.in)) {
			String a = sc.next();
			if (!a.equals("在想你啊我的宝")) {
			    Thread.sleep(1000);
			    System.out.println("emmm...");
			    Thread.sleep(1000);

			    // System.out.println() 固定语法，作用是将括号中的内容输出到窗体中

			    System.out.println("你好坏呀，我好喜欢！");
			    Thread.sleep(2000);
			}
			a = sc.next();
			if (a.equals("喜欢我的坏吗？")) {
			    Thread.sleep(1000);
			    System.out.println("渣男!");
			}
		}
    }
}