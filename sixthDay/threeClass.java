package sixthDay;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class threeClass {
	public static void main(String[] args) throws AWTException {
		// 获取电脑中的剪切板,并操纵电脑粘贴内容并发送
		// 在此之前要获取需要复制的内容
		
		// 首先写上要说的话
		String msg = "仙人指路!";
		// 第二步,调用 Java中的工具实现复制该内容
		// Clipboard 电脑中的剪切板
		// Toolkit.getDefaultToolkit().getSystemClipboard();作用是获取剪切板中已储存的信息
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		// 读出可以传输到信息并替换
		
		Transferable t = new StringSelection(msg);
		// 设定剪切板复制的内容
		c.setContents(t, null);
		
		Robot r = new Robot();
		// 让程序暂停5秒钟
		r.delay(5000);
		for (int i = 0; i <= 100; i++) {
		// 控制键盘按下和松开
			r.keyPress(KeyEvent.VK_META);	// 模拟键入command键
			r.keyPress(KeyEvent.VK_V); 			// 模拟键入V键
			r.delay(200);
			r.keyRelease(KeyEvent.VK_META);	// 模拟键出command键
			r.keyRelease(KeyEvent.VK_V); 		// 模拟键出V键
			r.delay(200);
			r.keyPress(KeyEvent.VK_ENTER);		// 模拟键入enter键
			r.delay(200);
			r.keyRelease(KeyEvent.VK_ENTER);	// 模拟键出enter键
		}
	}
}
