package PlaneGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseMotionListener {
    // 继承JPanel 重写panit方法 这样创建GamePanel对象的时候就能自动调用panit方法画图
    // 英雄机左上角坐标 初始位置 之后根据鼠标拖拽改变位置
    int heroX = 300;
    int heroY = 400;
    int score = 0;// 记录分数 当子弹击中敌机则+10分
    // 存储敌机的数组
    List<Enemy> enemys = new ArrayList<Enemy>();
    // 创建子弹的数组
    List<Bullet> bullets = new ArrayList<Bullet>();
    // 创建保存碰撞图片的数组
    List<Bomb> bombs = new ArrayList<Bomb>();
    // 英雄机图片
    ImageIcon heroImage = new ImageIcon("src/PlaneGame/img/hero.png");
    // 背景图片
    ImageIcon bgImage = new ImageIcon("src/PlaneGame/img/background.png");

    // 构造方法 在创建GamePanel对象时就创建敌机对象 使得敌机对象一开始就出现在面板中
    public GamePanel() {
        // 创建10个敌机 加入数组中
        for (int i = 0; i < 10; i++) {
            enemys.add(new Enemy());
        }

    }

    // 窗口对象自动调用 不需手动调用 绘制图片
    public void paint(Graphics g) {
        super.paint(g);
        // 展示背景图片
        g.drawImage(bgImage.getImage(), 0, 0, null);
        // 设置字体
        g.setFont(new Font("", Font.BOLD, 30));// 字体、字体样式、字体大小
        // 设置字体颜色
        g.setColor(Color.WHITE);
        // 在窗体上展示一个字符串 即得分情况
        g.drawString("当前得分：" + score, 10, 30);// 显示内容 位置
        // 绘制英雄机
        g.drawImage(heroImage.getImage(), heroX, heroY, null);
        // 绘制全部敌机
        for (int i = 0; i < enemys.size(); i++) {
            Enemy enemy = enemys.get(i);
            enemy.drawImage(g);
        }

        // 英雄机只有一架 而敌机子弹等有多架 因此定义绘制函数 每个对象都调用自己的绘制绘制函数

        // 绘制全部子弹
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.drawImage(g);
        }

        // 绘制全部爆炸图片
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            bomb.drawImage(g);
        }
        // 重新绘制自动调用paint方法 更新图片 否则实现不了动画效果
        repaint();

    }

    // //初始化使用 逻辑操作
    public void init() {
        int flag = 0;// 用来使子弹的创建不过密
        // 一直进行添加、删除、判断是否碰撞等操作
        while (true) {
            flag++;
            // 创建子弹 使子弹的创建不过密
            if (flag % 20 == 0) {
                // 创建一些子弹 修改子弹位置 使子弹位置在飞机正中间
                Bullet bullet = new Bullet(heroX + (heroImage.getIconWidth() / 2) - 2, heroY - 15);
                // 添加到子弹数组中
                bullets.add(bullet);
            }
            // 让子弹移动起来
            for (int i = 0; i < bullets.size(); i++) {
                Bullet tempBullet = bullets.get(i);
                tempBullet.move();
            }
            // System.out.println(bullets.size());
            // 删除越界的子弹 否则子弹一直在增加 不利于内存
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                if (bullet.getY() < 0) {// 子弹越界了
                    bullets.remove(bullet);
                }
            }

            // 让所有敌机往下移动
            for (int i = 0; i < enemys.size(); i++) {
                Enemy enemy = enemys.get(i);
                enemy.move();// 移动敌机 使敌机往下移 改变敌机y值
                // 判断敌机是否飘出下界 敌机y坐标是否超过窗体 超过则将该架敌机移除释放内存 重新添加一架敌机否则敌机移除完就没有了
                if (enemy.getY() > GameMain.heigh) {
                    enemys.remove(enemy);
                    enemys.add(new Enemy());
                }
            }
            // 判断是否发生碰撞 子弹打到敌机 获取当前所有敌机和子弹 任意两个相撞都是碰撞了
            for (int i = 0; i < enemys.size(); i++) {
                Enemy enemy = enemys.get(i);// 敌机
                for (int j = 0; j < bullets.size(); j++) {
                    Bullet bullet = bullets.get(j);// 子弹
                    // 判断是否击中
                    if (isHit(enemy, bullet)) {
                        // 击中 +10分
                        score = score + 10;

                        // 如果击中 则敌机消失 将敌机删除移除敌机列表
                        enemys.remove(enemy);
                        // 再新加入一个敌机 否则如果所有敌机打完全部删光 没有敌机了
                        enemys.add(new Enemy());

                        // 删除该子弹
                        bullets.remove(bullet);
                        // 添加新的子弹进去
                        bullets.add(new Bullet(heroX + (heroImage.getIconWidth() / 2) - 2, heroY - 15));

                        // 创建一个爆炸图片的对象 爆炸图片的位置就是被击中敌机的位置
                        Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                        // 添加到爆炸图片集合中
                        bombs.add(bomb);
                    }

                }
            }

            // 删除爆炸图片 否则爆炸图片一直停留在界面上
            for (int i = 0; i < bombs.size(); i++) {
                Bomb bomb = bombs.get(i);
                bomb.move();
                // 多次调用move方法 当同一个爆炸图片对象的 count次数超过3之后才删除该爆炸图片 这样不会使爆炸图片转瞬即逝 视觉无法捕捉
                // if (bomb.getCount() > 3) {
                // bombs.remove(bomb);
                // }
                // 休息40ms再移除 否则爆炸图片转瞬而过 视觉无法捕捉 与上述count代码二选一
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                bombs.remove(bomb);
            }
            // 休息7ms 否则敌机移动太快 视觉无法捕捉
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // //重新绘制自动调用paint方法 更新图片 否则实现不了动画效果
            // repaint();
        }

    }

    // 碰撞方法 判断子弹是否打中敌机 即子弹是否运动到敌机所处区域
    public boolean isHit(Enemy enemy, Bullet bullet) {
        // 指定一个区域 即敌机图片所处区域
        Rectangle rect = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeigth());
        // 表示(x,y)坐标空间中的位置的点 即子弹的中心位置
        Point p = new Point(bullet.getX() + bullet.getWidth() / 2, bullet.getY() + bullet.getHeigth());
        // 如果子弹处在敌机的区域 则认为子弹击中了敌机 返回true
        return rect.contains(p);
    }

    // 重写鼠标拖拽方法
    public void mouseDragged(MouseEvent e) {
        // 鼠标的x、y
        int x = e.getX();
        int y = e.getY();
        // 将鼠标拖拽位置赋给英雄机坐标
        heroX = x - (heroImage.getIconWidth() / 2);// 使鼠标在英雄机图片的中央
        heroY = y - (heroImage.getIconHeight() / 2);
        // 使英雄机不超出边界
        // 右边界
        if ((x + heroImage.getIconWidth()) > GameMain.width) {
            heroX = GameMain.width - heroImage.getIconWidth() - 20;// 20为误差值 根据效果调整
        }
        // 左边界
        if ((x) < 80) {
            heroX = 0;
        }
        // 下边界
        if ((y + heroImage.getIconHeight()) > GameMain.heigh) {
            heroY = GameMain.heigh - heroImage.getIconHeight() - 20;
        }
        // 上边界
        if (y < 80) {
            heroY = 0;
        }

        // System.out.println(heroX+" "+heroY);
    }

    // 重写鼠标移动方法
    public void mouseMoved(MouseEvent e) {
        // System.out.println("鼠标移动");
    }

}
