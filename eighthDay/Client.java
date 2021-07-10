package eighthDay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 客户端类,输出消息内容,接受服务器发送回来的消息内容
 */

public class Client {
    // java.net.socket Java面向网络编程的关键字
    private Socket socket;

    // 构造方法
    public Client() {
        // TODO 自动生成的构造函数存根
        /*
         * 声明一个属于客户端的socket 在声明时socket需要指定两个参数,连接对象的ipv4地址,连接对象的端口号
         */
        try {
            System.out.println("正在连接服务器...");
            socket = new Socket("192.168.43.252", 8088);
            System.out.println("连接服务器成功!");
        } catch (UnknownHostException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    /*
     * 客户端开始工作的方法
     */
    public void start() throws IOException {
        // 先写出用户输入
        Scanner sc = new Scanner(System.in);

        // 启动一个线程,该线程作用是读取服务器发送消息
        ServerHandler sh = new ServerHandler();
        Thread t1 = new Thread(sh);
        t1.start();
        // 字节流输出
        OutputStream os = socket.getOutputStream();
        // 强化字节输出流
        OutputStreamWriter osw = new OutputStreamWriter(os);
        // 将字节输出流强化为字符输出流
        BufferedWriter bw = new BufferedWriter(osw);

        // 最强输出流,功能:可以输出整行字符
        // true 在这里的作用是刷新
        PrintWriter pw = new PrintWriter(bw, true);

        // 循环检测用户输入的内容
        while (true) {
            String msg = sc.next();
            pw.println(msg);
            if (msg.equals("exit")) {
                System.out.println("对方关闭了聊天并拍了你一下");
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.start();
    }

    class ServerHandler implements Runnable {

        public void run() {
            // TODO 自动生成的方法存根
            // 通过socket获取输入流读取服务器发送过来的消息
            try {
                InputStream is = socket.getInputStream();
                // InputStreamReader 可以读取字节
                InputStreamReader isr = new InputStreamReader(is);
                // 将读取到的字节转化为字符
                BufferedReader br = new BufferedReader(isr);

                // 定义一个变量表示当前服务器没有fasongzifu
                String line = null;
                // 循环接受服务器发送的消息
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }

    }
}
