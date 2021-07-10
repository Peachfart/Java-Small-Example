package ninethDay;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class oneClass {

    public void Button() {
    	// 文本框,小括号中可以设定文本框的长度
    	TextField tf = new TextField();
    	tf.setText("请输入姓名:");
    	
        // 按钮
        JButton bt = new JButton("开始");
        JButton bt1 = new JButton("点击同桌的寿命少十年,自身增加八块腹肌,可以多次叠加");
        // 由于直接添加组件会影响窗口布局,所以我们需要添加一个容器Jpanel
        JPanel jp = new JPanel();
        jp.add(bt);
        jp.add(bt1);
        // 添加文本框到容器当中
        jp.add(tf);
        Frame f = new Frame();

        // add()方法可以将组件添加到窗口
        f.add(jp);
        f.setSize(500, 500);
        f.setVisible(true);
        
        bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Frame f = new Frame();
				f.setSize(500,500);
				f.setVisible(true);
				
			}
		});

        // 给bt1按钮添加点击事件(点击后运行程序)
        bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AdvancedPlayer ap = new AdvancedPlayer(oneClass.class.getResourceAsStream(null));
                    ap.play();
                } catch (JavaLayerException e1) {
                    // TODO 自动生成的方法存根
                    e1.printStackTrace();
                }
            }

        });
    }

    public static void main(String[] args) {
        oneClass oc = new oneClass();
        oc.Button();
    }
}
