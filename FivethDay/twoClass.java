package FivethDay;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class twoClass extends Frame{
	
	public void start() {
		setSize(1000,500);
		setTitle("坦克");
		setBackground(Color.white);
		setVisible(true);
	}
	
	// 
	public void paint(Graphics g) {
		int x = 0;
		int y = 0;
		//设定颜色
		//fillRect（X轴的坐标，Y轴的坐标，图形的宽度 ，图形的高度）
		g.setColor(Color.black);
		g.fillRect(20 + x, 110 + y, 360, 120); //车体
		g.fillRect(80 + x, 80 + y, 30, 30); //包
		g.fillRect(120 + x, 60 + y, 150, 50); //炮台
		g.fillRect(150 + x, 40 + y, 80, 40); //炮头
		g.fillRect(230 + x, 80 + y, 200, 20); //炮管
		g.fillRect(30 + x, 250 + y, 340, 30); //履带
		g.fillRect(60 + x, 230 + y, 30, 30); //履带链接1
		g.fillRect(300 + x, 230 + y, 30, 30); //履带链接2
		
	}
	
	class moveup extends Thread {
		public void move() {
			paint(getGraphics());
			int y = -5;
		}
	}
	class moveleft extends Thread {
		public void move() {
			int x = 5;
		}
	}
	class movedown extends Thread {
		public void move() {
			int y = 5;
		}
	}
	class moveright extends Thread {
		public void move() {
			int x =-5;
		}
}
	
	class key extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
        	// 上
            if (e.getKeyChar() == 38) {
                new moveup().start();
            }
            // 右
            if (e.getKeyChar() == 39) {
                new moveright().start();
            }
            // 下
            if (e.getKeyChar() == 40) {
                new movedown().start();
            }
            // 左
            if (e.getKeyChar() == 37) {
                new moveleft().start();
            }
        }
    }
	
	
	public static void main(String[] args) {
		System.out.println("按上下左右键运动坦克");
		twoClass s=new twoClass();
		s.start();
	}
}