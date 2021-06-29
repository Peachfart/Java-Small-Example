oneClass.java

```java
package FirstDay;

import java.io.IOException;

public class oneClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Thread.sleep();让程序休眠
        // Runtime是java中一个运行环境
        // getRuntime是Java获取电脑控制权限的一种手段
        // exec()是打开应用程序的代码
        Thread.sleep(5000);
        Runtime.getRuntime().exec("/Applications/Calculator.app/Contents/MacOS/Calculator");
        Thread.sleep(5000);
        Runtime.getRuntime().exec("/Applications/Notes.app/Contents/MacOS/Notes");
        Thread.sleep(5000);
        Runtime.getRuntime().exec("shutdown -t -s 0");
    }
}
```

oneClass.java

```java
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
```

twoClass.java

```java
package FirstDay;

import java.io.IOException;
import java.util.Scanner;

public class twoClass {
    public static void main(String[] args) throws IOException {

        System.out.println("输入1.启动计算器。2.启动记事本。3.输出 勇敢牛牛,不惧困难!");

        Scanner sc = new Scanner(System.in);
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

```

threeClass.java

```java
package FirstDay;

import java.util.Scanner;

public class threeClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("在干嘛呢？");
        Scanner sc = new Scanner(System.in);
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
```

```java
package FirstDay;

import java.awt.Frame;

public class fourClass {
    public static void main(String[] args) {
        // Fram 作用是制造串口
        java.awt.Frame f = new Frame();
        // 设定弹窗的宽高
        f.setSize(800, 666);
        // 设定弹窗的标题
        f.setTitle("贪玩蓝月");
        // 设定弹窗的显示方式，true是显示，false是不显示
        f.setVisible(true);
    }
}
```

fiveClass.java

```java
// 要求：程序开始，先提示用户输入（输入1.启动计算器。输入2.启动记事本。输入3.弹出不可关闭的窗口）
// 用户输入，判断用户输入的内容并运行相应的程序

package FirstDay;

import java.io.IOException;
import java.awt.Frame;
import java.util.Scanner;

public class fiveClass {
    public static void main(String[] args) throws IOException {
        System.out.println("输入1.启动计算器。2.启动记事本。3.弹出不可关闭的窗口");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a == 1) {
            Runtime.getRuntime().exec("/Applications/Calculator.app/Contents/MacOS/Calculator");
        }
        if (a == 2) {
            Runtime.getRuntime().exec("/Applications/Notes.app/Contents/MacOS/Notes");
        }
        if (a == 3) {
            java.awt.Frame f = new Frame();
            f.setSize(800, 666);
            f.setTitle("不可关闭");
            f.setVisible(true);
        }
    }
}

```

