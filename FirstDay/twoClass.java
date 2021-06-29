package FirstDay;

import java.io.IOException;
import java.util.Scanner;

public class twoClass {
    public static void main(String[] args) throws IOException {

        System.out.println("输入1.启动计算器。2.启动记事本。3.输出 勇敢牛牛,不惧困难!");

        try (Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();

			if (a == 1) {
			    Runtime.getRuntime().exec("/Applications/Calculator.app/Contents/MacOS/Calculator");
			}
			if (a == 2) {
			    Runtime.getRuntime().exec("/Applications/Notes.app/Contents/MacOS/Notes");
			}
			if (a == 3) {
			    System.out.println("勇敢牛牛,不惧困难!！");
			}
		}
    }
}
