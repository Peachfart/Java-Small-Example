package eighthDay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 聊天室服务器
 */
public class Server {

	/*
	 * java.net.ServerSocket
	 * 运行在服务端的ServerSocket主要有两个工作：
	 * 1.向系统申请服务端口，客户端就是通过这个端口与服务端建立连接的
	 * 2.监听该端口，这样一旦一个客户端进行连接时，ServerSocket会自动创建一个socket，
	 * 通过这个socket就可以与客户端交互了。
	 */
	private ServerSocket server;
	/*
	 * 用来存放所有ClientHander内部对应客户端的输出流，用于广播消息
	 */
	private PrintWriter[] allOut= {};
	public Server() {
		try {
			/*
			 * 实例化ServerSocket的同时需要向系统申请服务端口，
			 * 客户端就是通过这个端口与服务器建立连接的，如果这个端口被系统其他程序占用
			 * 则会抛出异常
			 */
			System.out.println("正在启动服务端...");
			server=new ServerSocket(8088);
			System.out.println("服务端启动完毕！");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void start() {
		

		try {
			while(true) {
				System.out.println("等待客户端连接...");
				/*
				 * Socket accept()
				 * 该方法是一个阻止方法，调用后服务端开始等待客户端的连接，
				 * 知道一个客户端连接为止，并且此时会返回一个Socket实例，
				 * 使用这个实例即可与客户端进行交互。多次调用该方法可以接受多个客户端的连接。
				 */
				Socket socket=server.accept();
				System.out.println("一个客户端连接了");
				ClientHander hander=new ClientHander(socket);
				Thread t=new Thread(hander);
				t.start();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server=new Server();
		server.start();


	}
	class ClientHander implements Runnable{
		private Socket socket;
		//客户端的地址信息
		private String host;
		public ClientHander(Socket socket) {
			this.socket=socket;
			host=socket.getInetAddress().getHostAddress();
		}

		public void run() {
			PrintWriter pw=null;
			try {
				/*
				 * InputStream getInputStream()
				 * 通过Socket获取的输入流可以读取远端计算机发送过来的字节
				 */
				InputStream in=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(in,"UTF-8");
				BufferedReader br=new BufferedReader(isr);

				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(out,"UTF-8");
				BufferedWriter bw=new BufferedWriter(osw);
				pw=new PrintWriter(bw,true);
				synchronized (allOut) {
					//将该输出流存入allOut中，用于共享
					//1对数组扩容
					allOut=Arrays.copyOf(allOut, allOut.length+1);
					//2将输出流存入数组最后一个位置
					allOut[allOut.length-1]=pw;
				}
				System.out.println(host+"上线了，当前在线人数"+allOut.length);
				String line=null;
				/*
				 * 这里使用缓冲字符流的readLine方法读取客户端发过来的一串字符时，如果客户端断开了连接，
				 * 此时由于客户端系统不同，这里的反应也不同，通常Windows客户端断开连接时，readLine
				 * 方法会直接抛出异常，而Linux的客户端断开时，这里会返回null。
				 */
				while((line=br.readLine())!=null) {

					System.out.println(host+"说"+line);
					synchronized (allOut) {
						//发送给所有客户端
						for(int i=0;i<allOut.length;i++) {
							allOut[i].println(host+"说"+line);
						}
					}
				}
			}catch(Exception e) {

			}finally {
				//处理与该客户端断开连接后的操作

				try {
					synchronized (allOut) {


						for(int i=0;i<allOut.length;i++) {
							if(allOut[i]==pw) {
								
								allOut[i]=allOut[allOut.length-1];
								allOut=Arrays.copyOf(allOut, allOut.length-1);
								break;

							}
						}

					}
					System.out.println(host+"下线了，当前在线人数："+allOut.length);
					socket.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

	}


}
