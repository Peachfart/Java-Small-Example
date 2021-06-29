package SecondDay;

import java.util.Random;

public class oneClass {
    public static void main(String[] args) {
        // Random 的作用是可以生成一个或者多个随机数
        Random rd = new Random();
        // 使用Random生成一个整数随机数
        int a = rd.nextInt(100) + 1; // 1~100的随机数
        // 输出结果
        System.out.print(a);
    }
}
