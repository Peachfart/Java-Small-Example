package Chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
    public static void main(String[] args) {
        new ClientFrame("客户端");
    }
}

/*
 * 继承Jframe类表示该类可以创建一个窗口程序了， 实现ActionListener：动作监听，就是一个事件发送后应该执行什么就要重新它的方法
 * 实现Runnable：实现多线程，该窗口是个客户端窗口，要开启一个线程接收显示服务器发过来的信息
 */
class ClientFrame extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;

    private Socket socket;
    OutputStream os = null;
    BufferedWriter bw = null;

    JTextArea message;
    JScrollPane scroll;
    JTextField input;
    JButton submit;
    JPanel panel;

    String uname = "";
    // 聊天页面
    JPanel chat;

    // 登录页面
    JPanel login;
    JTextField username;
    JButton ok;

    public ClientFrame(String name) {
        super(name);

        message = new JTextArea();
        message.setEditable(false);
        scroll = new JScrollPane(message);
        input = new JTextField(20);
        submit = new JButton("发送");
        panel = new JPanel();

        panel.add(input);
        panel.add(submit);
        chat = new JPanel(new BorderLayout());
        chat.add(scroll, "Center");
        chat.add(panel, "South");

        // 在创建客户端窗体是就要把客户端与服务端连接
        try {
            // 127.0.0.1表示本机地址，地址好端口都可以改，这要看服务器那边是什么地址和端口
            socket = new Socket("10.4.15.217", 6666);
            os = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os));

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        /*
         * 在创建C端窗体的时候也应该开启一个线程接收显示来自服务器的信息 为什么要开启一个线程呢？因为在这个窗体里既要实现消息的发送，
         * 也要接收信息，而且两个不能按顺序进行，也互不干扰，所以开启一个线程时时刻刻等着S端发来的信息
         */
        // 接收信息
        new Thread(this).start();

        // 提交按钮工作监听器，点击提交时触发
        submit.addActionListener(this);

        login = new JPanel();
        username = new JTextField(20);
        ok = new JButton("确定");
        ok.addActionListener(this);
        JLabel label = new JLabel("请输入用户名");
        label.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
        label.setForeground(Color.red);
        login.add(label);
        login.add(username);
        login.add(ok);

        this.add(chat);
        this.add(login);

        this.setResizable(false);
        this.setBounds(0, 0, 400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // 如果点击提交按钮，则表示需要将信息发送出去。
            String str = null;
            // 以下三行是创建发送时间的代码
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            String dateStr = format.format(date);

            str = uname + " " + dateStr + "  " + input.getText();

            try {
                bw.write(str);
                bw.newLine();
                // System.out.println("客户端发送了："+str);
                bw.flush();
            } catch (IOException e1) {
                System.out.println("无法发送，服务器连接异常！");
            }

            // System.out.println(str);

        } else if (e.getSource() == ok) {// 用户登录
            uname = username.getText();// 获取文本框输入的文本信息
            if ("".equals(uname)) {
                JOptionPane.showMessageDialog(this, "用户名不能为空！");
            } else {
                login.setVisible(false);
                chat.setVisible(true);
                this.setTitle(uname + " 的客户端");
                this.add(chat);
            }
        }
    }

    // run方法里面的是接受S端信息和将信息显示的代码
    @Override
    public void run() {
        BufferedReader br = null;
        InputStream is = null;
        String str = null;
        try {
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while (true) {
                str = br.readLine() + "\r\n";
                message.append(str);
            }
        } catch (IOException e) {
            System.out.println("无法发送，服务器连接异常！");
        }
    }

}