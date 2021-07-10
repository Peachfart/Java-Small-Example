package ninethDay;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class threeClass {

    // 新建一个窗口,窗口需要两个输入框,让输入用户名和密码
    // 判断用户输入的用户名和密码是否正确,如果有其中一个不正确,就弹出登录失败的窗口
    // 如果正确了,那就弹出登录成功窗口
    // 初始用户名:hand 初始密码:666

    public void start() {
        // 文本框组件
        JTextField jtf = new JTextField(18);
        JTextField jtf_pw = new JTextField(18);
        // 按钮组件
        JButton jb = new JButton("登录");
        // 用来组装组件的容器
        JPanel jp = new JPanel();
        // 窗口
        JFrame jf = new JFrame();
        // 文本框提示语
        jtf.setText("用户名:");
        jtf_pw.setText("密码:");

        jp.add(jtf);
        jp.add(jtf_pw);
        jp.add(jb);
        jf.add(jp);
        jf.setVisible(true);
        jf.setSize(500, 500);

        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 自动生成的方法存根
                String name = jtf.getText();
                String pw = jtf_pw.getText();
                if ("喜欢你".equals(name) && "666".equals(pw)) {
                    JFrame jf = new JFrame();
                    jf.setSize(500, 500);
                    jf.setLocation(200, 200);
                    jf.setVisible(true);
                    jf.setBackground(Color.green);
                    jf.setTitle("我也喜欢你!");
                } else {
                    JFrame jf = new JFrame();
                    jf.setSize(500, 500);
                    jf.setLocation(200, 200);
                    jf.setVisible(true);
                    jf.setBackground(Color.red);
                    jf.setTitle("窝窝头,一块钱四个,嘿嘿");
                }
            }
        });
    }

    public static void main(String[] args) {
        threeClass tc = new threeClass();
        tc.start();
    }

}
