package FirstDay;

import java.io.IOException;
import java.util.Scanner;

public class oneClass {
    public static void main(String[] args) throws IOException, InterruptedException {

        int a = 123456;
        // 创建一个可以接收用户输入的功能
        Scanner sc = new Scanner(System.in);
        // 实际接收用户输入的内容
        int b = sc.nextInt();
        // 分支结构
        // 判断用户输入的密码和正确密码是否相等，如果正确，就执行第一个大括号的内容，否则则执行第二个大括号里的内容
        if (b == a) {
            System.out.println("密码正确！");
        } else {
            System.out.println("密码错误！");
        }

    }
}