package PlaneGame;

import javax.swing.JFrame;

// import javazoom.jl.decoder.JavaLayerException;
// import javazoom.jl.player.advanced.AdvancedPlayer;

public class GameMain {
    // 窗口宽高 静态常量 使用类名.可以在其他类中直接带哦用
    static int width = 550;
    static int heigh = 700;

    public void UI() {
        // 创建一个窗体
        JFrame frame = new JFrame();
        frame.setTitle("飞机大战");// 设置标题
        frame.setSize(width, heigh);// 设置窗体大小
        frame.setLocationRelativeTo(null);// 使窗体显示在屏幕中央
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 退出时关闭窗口

        // 创建JPanel 添加到窗体上 监听在JPanel中
        GamePanel panel = new GamePanel();
        frame.add(panel);
        // 添加鼠标移动监听器
        frame.addMouseMotionListener(panel);

        frame.setVisible(true);// 显示窗体可见
        // 调用初始化方法 游戏逻辑操作
        panel.init();

    }

    // 主函数 程序入口
    public static void main(String[] args) {
        // new music().start();
        GameMain gamemain = new GameMain();
        gamemain.UI();

    }

}

// class music extends Thread {
// // run 快捷键弹出 用第一个 在后面加上 AdvancedPlayer..
// @Override
// public void run() {
// super.run();
// try {
// AdvancedPlayer ad = new
// AdvancedPlayer(music.class.getResourceAsStream("src/PlaneGame/game_music.mp3"));
// ad.play();
// } catch (JavaLayerException e) {
// e.printStackTrace();
// }
// }
// }
