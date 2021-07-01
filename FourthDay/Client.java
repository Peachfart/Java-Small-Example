package FourthDay;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
//		客户端使用的是普通Socket
//		第一个参数是指定连接目的的ipv4地址
//		第二个参数是指定目的电脑的连接端口
		
		Socket s = new Socket("localhost",8080);
//		OutputStream 是一个输出字节流，只能输出字节
		OutputStream in = s.getOutputStream();
//		DataOutputStream 是一个输出数据流，可以输出任何数据
		DataOutputStream ds = new DataOutputStream(in);
		ds.writeUTF("记事本");
		
		
	}

}