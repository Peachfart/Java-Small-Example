package ThirdDay;

import java.util.Random;
import java.util.Scanner;

public class oneClass {
    public static void main(String[] args) {
        // 运算符 加法+ 减法- 乘法* 除法/
        //
        // int a = 50;
        // int b = 60;
        //
        // System.out.print("数字结果为："+(a+b));
        //
        // 写两个随机数，并将他们相加，计算出结果后输出
        //
        // Random y = new Random();
        //
        // int b = y.nextInt(100);
        //
        // System.out.println("两随机数相加为" + (a + b));
        //
        //
        //
        //
        // 难度增加，用户可以有10次机会，如果出错一次就要扣掉一分，满分10分

        int f = 10;
        
        Random x = new Random();

        int a = x.nextInt(100);

        System.out.println("你现在的分数是：" + f);

        System.out.println("输入数字进行闯关,你有10次机会：");

        for (int c = 1; c < 11; c++) {

            System.out.println("请输入数字：");

            Scanner sc = new Scanner(System.in);

            int b = sc.nextInt();

            if (f == 0) {
                break;
            }

            if (a == b) {
                System.out.println("恭喜你，答对了！你的得分为：" + f);
                break;
            } else {
                if (a > b) {
                    f = f - 1;
                    System.out.println("很遗憾，小了，你被扣掉一分,现在得分：" + f);
                }
                if (a < b) {
                    f = f - 1;
                    System.out.println("很遗憾，大了，你被扣掉一分,现在得分：" + f);
                }
            }
        }
    }
}
