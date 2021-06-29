package SecondDay;

import java.util.Random;
import java.util.Scanner;

public class twoClass {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Random rd = new Random();
        int a = rd.nextInt(20) + 1;
        for (;;) {
            System.out.println("猜数字游戏，请输入数字：");
            Scanner sc = new Scanner(System.in);
            int b = sc.nextInt();
            if (b == a) {
                System.out.println("恭喜答对了，我的宝!");
                break;
            }
            if (b < a) {
                System.out.println("猜小了");
            }
            if (b > a) {
                System.out.println("猜大了");
            }

        }
    }
}
