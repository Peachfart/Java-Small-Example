package Chat;

/** import java.awt.event.*
 * 一个语义事件，指示发生了组件定义的操作。当特定于组件的操作发生时（例如被按下），
 * 该组件（例如Button ）会生成此高级事件。 
 * 事件将传递给每个注册为使用组件的addActionListener方法接收此类事件的ActionListener对象。
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** import java.io.*
 * Java IO 也称为IO流，IO = 流，它的核心就是对文件的操作，对于字节 、字符类型的输入和输出流。
 * IO是指对数据流的输入和输出，也称为IO流，IO流主要分为两大类，字节流和字符流。字节流可以处理任何类型的数据，如图片， * 视频等，字符流只能处理字符类型的数据。
 * IO流的本质是数据传输，并且流是单向的。
 * 常用的字节流FileInputStream、FileOutputStream、ObjectInputStream、ObjectOutputStream。
 */
import java.io.BufferedReader; // 增强读取流
import java.io.BufferedWriter; // 增强写入流
import java.io.IOException; // "IoException"（流异常，通常用在文件读取中）
import java.io.InputStream; // InputStream 是Java标准库提供的最基本的输入流
import java.io.InputStreamReader; // InputStreamReader 是字节流通向字符流的桥梁
import java.io.OutputStream; // OutputStream是Java标准库提供的最基本的输出流
import java.io.OutputStreamWriter; // 将输出的字符流变为字节流

/** import java.net.*
 * Java Net Java网络编程
 * 服务器实例化一个 ServerSocket 对象，表示通过服务器上的端口通信。
 * 服务器调用 ServerSocket 类的 accept() 方法，该方法将一直等待，直到客户端连接到服务器上给定的端口。
 * 服务器正在等待时，一个客户端实例化一个 Socket 对象，指定服务器名称和端口号来请求连接。
 * Socket 类的构造函数试图将客户端连接到指定的服务器和端口号。如果通信被建立，则在客户端创建一个 Socket 对象能够与服务器进行通信。
 * 在服务器端，accept() 方法返回服务器上一个新的 socket 引用，该 socket 连接到客户端的 socket。
 */
import java.net.ServerSocket;
import java.net.Socket;

/**
* java.util.List
* 可重复集，并且有序。
* 特点是可以根据下标操作元素。
* 常用实现类:
* ArrayList:使用数组实现，查询更快
* LinkedList:使用链表实现，增删更快（首尾增删效果明显）
*/
import java.util.ArrayList;
import java.util.List;

/** javax.swing.*
 * Swing 是一个为Java设计的GUI工具包。
 * Swing是JAVA基础类的一部分。
 * Swing包括了图形用户界面（GUI）器件如：文本框，按钮，分隔窗格和表。
 */
import javax.swing.JButton; // JButton()：创建一个无标签文本、无图标的按钮。
import javax.swing.JFrame; // JFrame是GUI程序的基本思路是以JFrame为基础，它是屏幕上window的对象，能够最大化、最小化、关闭。
import javax.swing.JTextArea; // 文本域组件

public class Server {
    // 用于保存Socket的集合，也可以说是把个C端与S端的一个连接通道保存起来
    // 作用：服务器将接收到的信息发给集合里的所以socket，也就是发给每个C端
    public static List<Socket> list = new ArrayList<Socket>(); // list 初始化

    public static void main(String[] args) {
        new ServerFrame("服务器端"); // 调用 ServerFrame 类
    } // main函数,代码运行从这里开始

}

/*
 * 继承Jframe类表示该类可以创建一个窗口程序了， 实现ActionListener：动作监听，在S端点击“启动服务器”是要执行的代码
 * 实现Runnable：实现多线程，该窗口是个客户端窗口，要开启一个线程接收显示服务器发过来的信息
 */
class ServerFrame extends JFrame implements ActionListener, Runnable {

    /**
     * private static final long serialVersionUID = 1L; 定义程序序列化ID。
     * 序列化ID等同于身份验证，主要用于程序的版本控制，维护不同版本的兼容性以及避免在程序版本升级时程序报告的错误。
     * Java的序列化机制通过在运行时确定类的serialVersionUID来验证版本一致性。
     */
    /**
     * private类型的数据成员只能在定义的时候修改
     */
    // 声明对象
    private static final long serialVersionUID = 1L;

    private ServerSocket serverSocket = null;

    private Socket socket;

    private JButton start;
    private JTextArea message;

    // 服务端控制窗口界面生成
    public ServerFrame(String name) {
        super(name); // 子类中调用父类

        start = new JButton("启动服务器"); // 生成带有“启动服务器”字样的按钮
        start.addActionListener(this); // 添加动作侦听器，以接收发自此按钮的动作事件
        message = new JTextArea(); // 创建文本框,用来显示用户上机情况
        message.setEditable(false); // setEditable 复合框 false 内部选项的文本不可编辑组
        this.add(start, "North"); // 设置启动服务器按钮的位置为最顶端
        this.add(message, "Center"); // 设置文本框显示位置为中间

        this.setResizable(true); // setResizable 设置窗口是否预设(false)或可拖动(true)
        this.setBounds(0, 0, 400, 300); // setBounds(int x,int y,int width,int height) 用于设置初始窗口位置和尺寸
        this.setVisible(true); // 窗口显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 窗口可关闭,程序终止
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            // 如果点击的按钮是开始按钮。则启动服务器。
            try {
                serverSocket = new ServerSocket(8808); // 指定提供监听服务的端口是8808
                message.setText("服务器已启动..."); // 在窗口打印

                // 单击“启动服务器”开启一个线程用于获取用户上线的情况
                new Thread(this).start(); // 调用类 Thread

            } catch (IOException e1) { // 抛出异常
                e1.printStackTrace();
            }
        }
    }

    // 获取C端上线的情况
    @Override
    public void run() {
        String address = null; // 初始化address 用来记录客户端ip
        int port = 0;
        // 用一个死循环一直让S端开启接收C端的连接，将C端的IP和端口显示在面板上
        // 如果不用死循环的话就只能接收一次
        while (true) {
            try {
                socket = serverSocket.accept(); // ServerSocket的accept()方法从连接请求队列中取出一个客户的连接请求，然后创建与客户连接的Socket对象，并将它返回。如果队列中没有连接请求，accept()方法就会一直等待，直到接收到了连接请求才返回。
                Server.list.add(socket);
                address = socket.getInetAddress().getHostAddress(); // 返回InetAddress对象包含远程计算机的IP地址
                port = socket.getPort(); // 获取请求
                message.append("\r\nip:/" + address + ":" + port + "\t上线了");
                // System.out.println(port);
                // 开启转发信息的线程
                new sendThread(socket).start(); // 调用类 sendThread

            } catch (IOException e) {
            }
        }
    }

}

/**
 * Thread{} 开启多线程 ,并发接收每个C端的信息并向每个C端发送接收到的信息
 */
class sendThread extends Thread {
    private Socket socket; // 声明了一个 Socket类型的对象

    public sendThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        // 声明变量
        InputStream is = null;
        BufferedReader br = null;
        String str = null;
        OutputStream os = null;
        BufferedWriter bw = null;
        while (true) {
            try {
                is = socket.getInputStream(); // 获取流程和子流程的输入流
                br = new BufferedReader(new InputStreamReader(is)); // 缓冲字符输入流
                str = br.readLine(); // 读取文件内容,如果读取不到数据的话，会一直阻塞
                for (Socket s : Server.list) { // 如果服务器与客户端
                    os = s.getOutputStream(); // 获取流程和子流程的输出流
                    bw = new BufferedWriter(new OutputStreamWriter(os)); // 缓冲字符输出流
                    bw.write(str); // 写入一行字符串
                    bw.newLine(); // 换行
                    bw.flush(); // 清空缓存
                }
            } catch (IOException e) {
                // 如果断开连接则移除对于的socket
                Server.list.remove(socket);
            }
        }
    }
}