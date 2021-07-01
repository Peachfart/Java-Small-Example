package FourthDay;

import java.util.Random;
import java.util.Scanner;

public class name{
  public static void main(String[] args) {
    // 创建数组
    // 数组的下标是从0开始的
    String name[] = {"小明","小红","小兰","大常","碧石","尚飞","李华"};
    // 输出数组中的元素
    // System.out.println(name[]);
    System.out.println("名亦鉴，50元一次，请输入您的姓氏");
    Scanner sc = new Scanner(System.in);
    // String 可以储存字符类型的数据
    // int 可以储存整数类型的数据
    String xing = sc.next();
    Random rd = new Random();
    // 数组名.length 指数组的长度，作用是可以直接表示，不用数元素的个数
    int a = rd.nextInt(name.length);
    System.out.println("您孩子的名字是"+ xing +name[a]);
  }
}
