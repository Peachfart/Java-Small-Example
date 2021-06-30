package ThirdDay;

import java.util.Random;
import java.util.Scanner;

public class twoClass {
    // 方法，作用就是将一系列答处理方法封装到一个模块中，方便调用

    public static void jia() {
        // 玩家得分
        int f = 10;
        // 两个随机数
        Random rd = new Random();
        int a = rd.nextInt(100) + 1;
        int b = rd.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入" + a + "+" + b + "的结果");
        int c = sc.nextInt();
        if (c == (a + b)) {
            System.out.println("答对了");
        } else {
            System.out.println("答错了");
            f--;
        }
        System.out.println("最后得分" + f);
    }

    public static void jian() {
        // 玩家得分
        int f = 10;
        // 初始化
        int x = 0;
        int y = 0;
        // 两个随机数
        Random RD = new Random();
        int d = RD.nextInt(1000) + 1;
        int e = RD.nextInt(1000) + 1;
        if (d > e) {
            x = d;
            y = e;
        } else {
            x = e;
            y = d;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入" + x + "-" + y + "的结果");
        int c = sc.nextInt();
        if (c == (x - y)) {
            System.out.println("答对了");
        } else {
            System.out.println("答错了");
            f--;
        }
        System.out.println("最后得分" + f);
    }

    public static void main(String[] args) throws InterruptedException {
        // 幼儿计算能力提升程序
        // 保持加法运算和减法运算到正常运行
        // 让用户选择减法
        for (;;) {
            System.out.println("输入1.加法运算，2.减法运算");
            Scanner dc = new Scanner(System.in);
            int hanshu = dc.nextInt();
            if (hanshu == 1) {
                // 运行加法运算
                jia();
            }
            if (hanshu == 2) {
                // 运行减法运算
                jian();
            } else {
                System.out.println("个是玩不起？...... 我走？");
                if (hanshu == 0) {
                    Thread.sleep(5000);
                    System.out.println("看来真的玩不起！我走");
                    break;
                }
            }
        }
    }
}