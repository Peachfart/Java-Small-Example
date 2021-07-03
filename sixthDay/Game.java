package sixthDay;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game extends Frame{
	// 此类为坦克大战游戏
	// 读取所有图片, 地图, 英雄坦克图片
	// 存放地图名字
	String map = "./game_pic/map.jpg";
	// 存放英雄坦克图片名字
	String img[] = {"./game_pic/left.png","./game_pic/up.png","./game_pic/right.png","./game_pic/down.png"};
	// 读取图片时,数组的下标
	int a = 0;
	// 读取图片
	BufferedImage mapname;
	BufferedImage tanke;
	
	public void read() {
		try {
			mapname = ImageIO.read(Game.class.getResourceAsStream(map));
			tanke = ImageIO.read(Game.class.getResourceAsStream(img[a]));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void start() {
		setSize(800, 800);
		setTitle("坦克世界");
		setVisible(true);
		addKeyListener(new key());
		new fps().start();
	}
	// 初始化坐标
	int x = 100;
	int y = 100;
	// 画图
	public void paint(Graphics g) {
		// 画图之前调用read方法将图片读取到内存中
		read();
		// 先画背景再画坦克
		g.drawImage(mapname, 0, 0, 800, 800, null);
		g.drawImage(tanke, x, y, 50, 50, null);
		
	}
	
	// 坦克移动的方法
	class key extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				img[0] = "./game_pic/up.png";
				y -= 5;
			} else if(e.getKeyCode() == KeyEvent.VK_S) {
				img[0] = "./game_pic/down.png";
				y += 5;
			} else if(e.getKeyCode() == KeyEvent.VK_D) {
				img[0] = "./game_pic/right.png";
				x += 5;
			} else if(e.getKeyCode() == KeyEvent.VK_A) {
				img[0] = "./game_pic/left.png";
				x -= 5;
			}
		}
	}
	
//	继承Thread 使其拥有与其他程序一起运行的能力
	class fps extends Thread {
		@Override
		public void run() {
			for(;;) {
			repaint();
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			}
		}
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.start();
	}
}
