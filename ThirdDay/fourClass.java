package ThirdDay;

import java.awt.Frame;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class fourClass extends Frame {

    // frame作用是制造窗口，并且可以修饰窗口
    // 快乐的不可关闭的弹窗v1.1
    public void start() {
        Random rd = new Random();
        int x = rd.nextInt(1280);
        int y = rd.nextInt(700);
        setSize(500, 500);
        setTitle("学习资料");
        setLocation(x, y);
        setVisible(true);
    }

    private JPanel getContentPane() {
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        new music().start();
        // 调用
        // fourClass f = new fourClass();

        for (int i = 1; i <= 100; i++) {
            fourClass f = new fourClass();
            Thread.sleep(100);
            f.start();
        }

    }

}

/**
 * 内部类是不需要实例化的 但是，不能实例化的内部类是不能执行的 1.是在内部类中添加main函数，（所以程序都会从main函数开始运行）
 * 2.将内部类改为外部类
 */
class music extends Thread {
    // run 快捷键弹出 用第一个 在后面加上 AdvancedPlayer..
    @Override
    public void run() {
        super.run();
        try {
            AdvancedPlayer ad = new AdvancedPlayer(music.class.getResourceAsStream("./mood.mp3"));
            ad.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}