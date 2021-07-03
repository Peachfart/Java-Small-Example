package sixthDay;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class tanke extends Frame{
//	小方块坐标轴初始化
	int x = 0;
	int y = 0;
	int p = 0;
	
	
//	调用此方法启动当前类所有功能
	public void start() {
		setSize(1280,900);
		setVisible(true);
		setTitle("移动小方块");
		addKeyListener(new key());
		new fps().start();
		
	}
	public void paint(Graphics g) {
		//fillRect（X轴的坐标，Y轴的坐标，图形的宽度 ，图形的高度）
			g.setColor(Color.black);
			g.fillRect(20 + x, 110 + y, 360, 120); //车体
			g.fillRect(80 + x, 80 + y, 30, 30); //包
			g.fillRect(120 + x, 60 + y, 150, 50); //炮台
			g.fillRect(150 + x, 40 + y, 80, 40); //炮头
			g.fillRect(230 + x, 80 + y, 200, 20); //炮管
			g.fillRect(410 + x + p, 80 + y, 20, 20); // 炮弹
			g.fillRect(30 + x, 250 + y, 340, 30); //履带
			g.fillRect(60 + x, 230 + y, 30, 30); //履带链接1
			g.fillRect(300 + x, 230 + y, 30, 30); //履带链接2
	}
	
//	监听键盘中按下的按键
	class key extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				y -= 20;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				x -= 20;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				y += 20;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				x += 20;
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				p += 200;
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
				sleep(200);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			}
		}
	}
	
	public static void main(String[] args) {
		tanke o = new tanke();
		o.start();
	}

}
