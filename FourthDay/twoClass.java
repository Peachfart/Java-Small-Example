package FourthDay;

import java.awt.Frame;
import java.io.IOException;
import java.util.Random;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.awt.image.BufferedImage;

public class twoClass extends Frame {

    // String name[] = {};

    // 启动方法，作用是将所有需要运行的程序统一启动
    public void start() {
        Random rd = new Random();
        setSize(500, 500);
        setTitle("比你好看");
        // 设定弹窗出现的位置
        setLocation(rd.nextInt(1280), rd.nextInt(900));
        // 设定窗口是否显示
        setVisible(true);
        new shuaxin().start();
    }

    // BufferedImage 作用是读取图片
    BufferedImage img;

    // 随机数
    Random rd = new Random();
    // int n = rd.nextInt(name.length);
    int n = rd.nextInt();

    // read 方法可以实现IO流读取图片
    public void read() {
        // ImageIO.read() 专用于读取图片，一次只能读取一张图片
        try {
            img = ImageIO.read(twoClass.class.getResourceAsStream("./photo/aa.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 将读取的图片画到窗口中

    public void paint() {

        // 运行此方法之前读取图片
        read();
        // drawImage() 方法作用是将读取的图片画到窗口中
        // getGraphics().drawImage(img, 0, 0, 500, 500, null);
    }

    class shuaxin extends Thread {
        @Override
        public void run() {
            // 刷新的速度可以达到0.05s刷新一次
            repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        new music().start();
        // 加入控制鼠标
        // Robot类主要作用是控制电脑鼠标与键盘
        Robot rb = new Robot();
        Random rd = new Random();
        java.awt.Frame f = new Frame();
        f.setSize(1280, 1280);
        f.setBackground(Color.BLACK);
        for (int i = 1; i < 500; i++) {
            Thread.sleep(150);
            twoClass t = new twoClass();
            t.start();
            int x = rd.nextInt(1200);
            int y = rd.nextInt(1200);
            rb.mouseMove(x, y);
        }
        // 继承Thread后，该类可以与其他程序并列运行，多线程

    }
}

class music extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            AdvancedPlayer ad = new AdvancedPlayer(music.class.getResourceAsStream("./hot.mp3"));
            ad.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}