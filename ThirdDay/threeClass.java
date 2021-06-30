package ThirdDay;

import java.util.Random;
import java.util.Scanner;

public class threeClass {
    // 抽奖程序
    // 一等奖10万奖金
    // 二等奖5万元购车现金
    // 三等奖华为平板
    // 四等奖魅族的手机
    // 五等奖拍立得
    // 六等奖电烤箱
    // 七等奖快乐奖
    // 那个ta的编号为9527
    public static void main(String[] args) {
        for (;;) {
            Random rd = new Random();
            int a = rd.nextInt(7) + 1;
            System.out.println("员工编号：");
            Scanner sc = new Scanner(System.in);
            int c = sc.nextInt();
            if (c == 9527) {
                a = 1;
            }
            if (a == 1) {
                System.out.println("恭喜中奖一等奖");
            } else if (a == 2) {
                System.out.println("恭喜中奖二等奖");
            } else if (a == 3) {
                System.out.println("恭喜中奖三等奖");
            } else if (a == 4) {
                System.out.println("恭喜中奖四等奖");
            } else if (a == 5) {
                System.out.println("恭喜中奖五等奖");
            } else if (a == 6) {
                System.out.println("恭喜中奖六等奖");
            } else if (a == 7) {
                System.out.println("恭喜中奖七等奖");
            }
        }
    }
}