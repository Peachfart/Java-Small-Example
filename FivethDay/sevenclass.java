package FivethDay;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class sevenclass extends Frame{
	
	
	class d1 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(d1.class.getResourceAsStream("./yinjian/d1.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class d2 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(d2.class.getResourceAsStream("./yinjian/d2.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class d3 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(d3.class.getResourceAsStream("./yinjian/d3.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class d4 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(d4.class.getResourceAsStream("./yinjian/d4.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class d5 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(d5.class.getResourceAsStream("./yinjian/d5.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class d6 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(d6.class.getResourceAsStream("./yinjian/d6.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class d7 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(d7.class.getResourceAsStream("./yinjian/d7.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class h1 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(h1.class.getResourceAsStream("./yinjian/h1.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class h2 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(h2.class.getResourceAsStream("./yinjian/h2.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class h3 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(h3.class.getResourceAsStream("./yinjian/h3.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class h4 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(h4.class.getResourceAsStream("./yinjian/h4.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class h5 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(h5.class.getResourceAsStream("./yinjian/h5.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class h6 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(h6.class.getResourceAsStream("./yinjian/h6.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class h7 extends Thread{
		@Override
		public void run(){
			// TODO Auto-generated method stub
			super.run();
			try {
				AdvancedPlayer ad=new AdvancedPlayer(h7.class.getResourceAsStream("./yinjian/h7.mp3"));
				ad.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class key extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar()==65) {
				new d1().start();
			}
			if(e.getKeyChar()==66) {
				new d2().start();
			}
			if(e.getKeyChar()==67) {
				new d3().start();
			}
			if(e.getKeyChar()==68) {
				new d4().start();
			}
			if(e.getKeyChar()==69) {
				new d5().start();
			}
			if(e.getKeyChar()==70) {
				new d6().start();
			}
			if(e.getKeyChar()==71) {
				new d7().start();
			}
			if(e.getKeyChar()==72) {
				new h1().start();
			}
			if(e.getKeyChar()==73) {
				new h2().start();
			}
			if(e.getKeyChar()==74) {
				new h3().start();
			}
			if(e.getKeyChar()==75) {
				new h4().start();
			}
			if(e.getKeyChar()==76) {
				new h5().start();
			}
			if(e.getKeyChar()==77) {
				new h6().start();
			}
			if(e.getKeyChar()==78) {
				new h7().start();
			}
		}
	}

	public void start() {
		setSize(1000,500);
		setTitle("迷你钢琴");
		setBackground(Color.black);
		setVisible(true);
		addKeyListener(new key());
	}
	//画笔方法
	public void paint(Graphics g) {
		//设定颜色
		//fillRect（X轴的坐标，Y轴的坐标，图形的宽度 ，图形的高度）
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 350);
		g.fillRect(81, 0, 80, 350);
		g.fillRect(162, 0, 80, 350);
		g.fillRect(243, 0, 80, 350);
		g.fillRect(324, 0, 80, 350);
		g.fillRect(405, 0, 80, 350);
		g.fillRect(486, 0, 80, 350);
		g.fillRect(567, 0, 80, 350);
		g.fillRect(648, 0, 80, 350);
		g.fillRect(729, 0, 80, 350);
		g.fillRect(810, 0, 80, 350);
		g.fillRect(891, 0, 80, 350);
		//画黑键
		g.setColor(Color.BLACK);
		g.fillRect(50,0 , 60, 280);
		g.fillRect(131,0 , 60, 280);
		g.fillRect(212,0 , 60, 280);
		g.fillRect(293,0 , 60, 280);
		g.fillRect(374,0 , 60, 280);
		g.fillRect(536,0 , 60, 280);
		g.fillRect(617,0 , 60, 280);
		g.fillRect(698,0 , 60, 280);
		g.fillRect(779,0 , 60, 280);
		
		
		
		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		//钢琴V1.1
		//监视用户按下的按钮
		sevenclass s=new sevenclass();
		s.start();

	}

}
