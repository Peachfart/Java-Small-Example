package FourthDay;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class huatu extends Frame {
    String name[] = { "阿梨small.png", "爱吃肉的小b崽.png", "草莓蕉蕉酱.png", "沉迷直播的林小小.png", "楚佩玖.png", "呆萌小千金z.png", "杜杜呀呀.png",
            "胡嘉一.png", "花企鹅.png", "进击的瑞莉.png", "橘右羊.png", "君君超A.png", "开心麻辣堂.png", "可乐鸡翅ovo.png", "可崽没了.png",
            "赖仙仙不才i.png", "李木子L.png", "李瑞汐七哥.png", "林姗姗3.png", "林小鸟最可爱.png", "刘喵喵喵丶.png", "马猴烧酒812.png", "美文咩.png",
            "迷雾里的蝴蝶.png", "冥王星小瑞塔.png", "尛小钰.png", "木子玉i.png", "妳的多多.png", "南隐ny.png", "内蒙古老妈妈.png", "你的恩宠baby.png",
            "你的雯baby.png", "你好我是超超.png", "你de草莓很甜.png", "努力吃饱的酱酱.png", "泡芙饼干吖.png", "七七你是最胖的.png", "钱朵朵Oo.png",
            "乔乔Moon丶.png", "狮狮嗷.png", "是你的小姨妈.png", "舒瑶z.png", "宋鲸儿.png", "酸桔子糖.png", "甜心宝贝yo.png", "微儿姐姐.png",
            "我是沙耶加的美树啊.png", "曦臣丶梦.png", "仙兔兔ya.png", "想喝可乐的阿星.png", "想做你的眼睛.png", "小島cherry.png", "小滚刀刀刀.png",
            "小鹿er朵.png", "小吕酱酱Lris.png", "小萝卜冲鸭.png", "小小蜜桃Q.png", "小小苏iii.png", "小玉哈尼.png", "漩涡三两.png", "雅楠baby.png",
            "颜值斗歌台.png", "一颗饭饭.png", "一枝葫芦.png", "艺昕酱.png", "迎接太阳的庆.png", "柚柚v.png", "张嘟嘟儿xx.png", "张静初表妹馨馨.png",
            "章鱼姐姐z.png", "子铛小姐姐.png", "aa.png", "bb.png", "Chen西瓜6.png", "Joan.png", "Pumpkin小南瓜yo.png", "SG马天龙.png",
            "Zz屁屁机灵鬼儿.png" };

    public void start() throws InterruptedException {

        Random rd = new Random();
        setSize(500, 500);
        setTitle("快乐制造");
        // 设定弹窗出现的位置
        setLocation(rd.nextInt(1980), rd.nextInt(1080));
        // 设定窗口是否显示
        setVisible(true);
        new shuaxin().start();
    }

    // BufferedImage 作用是读取图片
    BufferedImage img;

    Random rd = new Random();
    int n = 0;

    // 将读取到的图片画到窗口中
    public void paint(@SuppressWarnings("exports") Graphics g) {
        // 运行此方法前读取图片
        read();
        // drawImage()方法作用是将读取到的图片画到窗口中
        g.drawImage(img, 0, 0, 500, 500, null);
        n = rd.nextInt(name.length);
    }

    // read方法可以实现IO流读取图片
    public void read() {
        // ImageIO.read()专用于读取图片，一次只能读取一张图片
        // 随机数
        try {
            img = ImageIO.read(huatu.class.getResourceAsStream("/photos/" + name[n]));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class shuaxin extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();// 它刷新的速度可以达到0.05s刷新一次
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //
        new shubiao().start();
        new music().start();
        for (int i = 1; i <= 100; i++) {
            huatu t = new huatu();
            Thread.sleep(300);
            t.start();
        }
    }

}

// 继承Thread后，该类可以与其他程序并列运行（多线程）
class music extends Thread {
    @Override
    public void run() {
        //
        super.run();
        try {
            AdvancedPlayer ad = new AdvancedPlayer(music.class.getResourceAsStream("hot.mp3"));
            ad.play();
        } catch (JavaLayerException e) {
            //
            e.printStackTrace();
        }
    }
}

class shubiao extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        for (int i = 1; i <= 10; i++) {
            try {
                sleep(200);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                Random rd = new Random();
                Robot rb = new Robot();
                // 作用是移动鼠标
                rb.mouseMove(rd.nextInt(1980), rd.nextInt(1080));
            } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
