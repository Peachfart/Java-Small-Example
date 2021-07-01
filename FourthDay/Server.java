package FourthDay;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
//		Java中建立网络链接的类叫做Socket，在使用时客户端需要指定开放端口，服务器依照这个端口去链接
//		服务器中的Socket叫做ServerSocket，使用时，须指定客户端的连接端口
		ServerSocket ss = new ServerSocket(8080);
		System.out.println("等待...");
//		定义一个可以监测用户是否链接
//		如果用户没有链接，那么程序只会卡在这里不能运行，当有一人连接，程序就会运行一次
		Socket s = ss.accept();
		System.out.println("上钩了！！！");
//		是这个类可以传输数据
//		Java中传输数据全部都可以使用IO流传输
//		建立连接
		InputStream in = s.getInputStream();
//		加强流传输
		DataInputStream ds = new DataInputStream(in);
//		使该IO流可以读取中文
		String message = ds.readUTF();
		if (message.equals("记事本")) {
			Runtime.getRuntime().exec("/Applications/Notes.app/Contents/MacOS/Notes");
		}
		if (message.equals("计算器")) {
			Runtime.getRuntime().exec("/Applications/Calculator.app/Contents/MacOS/Calculator");
		}
		if (message.equals("关机")) {
			Runtime.getRuntime().exec("shutdown -s");
		}
		if (message.equals("取消关机")) {
			Runtime.getRuntime().exec("shutdown -a");
		}
	}
}
