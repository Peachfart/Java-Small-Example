package SecondDay;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Robot;
import java.rmi.AccessException;
import java.util.Random;

public class fiveClass {
    public static void main(String[] args) throws AccessException, AWTException, InterruptedException {
        // Robot类主要作用是控制电脑鼠标与键盘
        Robot rb = new Robot();
        Random rd = new Random();
        java.awt.Frame f = new Frame();
        f.setSize(1280, 1280);
        f.setBackground(Color.BLACK);
        for (int i = 1; i < 5; i++) {
            Thread.sleep(1000);
            int x = rd.nextInt(900);
            int y = rd.nextInt(900);
            rb.mouseMove(x, y);
        }
    }
}
