package sixthDay;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class oneClass extends Frame{
//	小方块坐标轴初始化
	int x = 100;
	int y = 100;
	
	
//	调用此方法启动当前类所有功能
	public void start() {
		setSize(800,800);
		setVisible(true);
		setTitle("移动小方块");
		addKeyListener(new key());
		new fps().start();
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 200, 200);
	}
	
//	监听键盘中按下的按键
	class key extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				y -= 5;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				x -= 5;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				y += 5;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				x += 5;
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
		oneClass o = new oneClass();
		o.start();
	}

}
