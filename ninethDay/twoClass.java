package ninethDay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class twoClass {
	public void start() {
		// 文本框组件
		JTextField jtf = new JTextField(18);
		// 按钮组件
		JButton jb = new JButton("提交");
		// 用来组装组件的容器
		JPanel jp = new JPanel();
		// 窗口
		JFrame jf = new JFrame();
		// 文本框提示语
		jtf.setText("峡谷钢琴家请输入:");
		
		jp.add(jtf);
		jp.add(jb);
		jf.add(jp);
		jf.setVisible(true);
		jf.setSize(500,500);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String name = jtf.getText();
				if("我喜欢你".equals(name)) {
					JFrame jf =  new JFrame();
					jf.setSize(500, 500);
					jf.setLocation(200,200);
					jf.setVisible(true);
					jf.setTitle("我也喜欢你!");
				} else {
					JFrame jf =  new JFrame();
					jf.setSize(500, 500);
					jf.setLocation(200,200);
					jf.setVisible(true);
					jf.setTitle("窝窝头,一块钱四个,嘿嘿");
				}
			}
		});
	}
	public static void main(String[] args) {
		twoClass tc = new twoClass();
		tc.start();
	}
}
