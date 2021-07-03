package FivethDay;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class oneClass extends Frame{
	//熟悉画图的步骤

	public void start() {
		setSize(500,500);
		setTitle("贪玩蓝月");
		setVisible(true);//设定窗口是否显示，默认值是false，也就是不显示
		

	}
	//画笔方法
	//Graphics 它在Java中的作用就像是一支笔，可以画圆形，方形
	public void paint(Graphics g) {
		//在画之前设定笔的颜色
		g.setColor(Color.BLACK);
		//fillRect 可以画出方形
		g.fillRect(100, 100, 66, 88);
	}
	
	public static void main(String[] args) {
		oneClass o=new oneClass();
		o.start();
	}
	

}