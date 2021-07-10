package PlaneGame;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

//敌机对象
public class Enemy {
    // 敌机宽高
    private int width;
    private int heigth;
    // 敌机坐标
    private int x;
    private int y;
    // 敌机图片
    private ImageIcon enemyImageIcon = new ImageIcon("src/PlaneGame/img/enemy.png");

    // 构造方法 获取敌机宽高 敌机x、y位置随机出现
    // 敌机对象有多个 每次创建对象的时候立刻得到该对象的宽高和位置
    public Enemy() {
        this.width = enemyImageIcon.getIconWidth();
        this.heigth = enemyImageIcon.getIconHeight();

        // 随机产生敌机位置
        Random random = new Random();
        // 不超出窗体范围 且在英雄机能击中的范围内
        this.x = random.nextInt(GameMain.width - width - 25);// -width-25是为了使敌机位置不超出左边界且不太偏使子弹无法击中
        this.y = -random.nextInt(GameMain.heigh - heigth);// 敌机从上往下飞 默认初始化在窗体外 窗体上方(-heigth)

    }

    // 私有属性 宽的get方法
    public int getWidth() {
        return width;
    }

    // 私有属性 宽的set方法
    public void setWidth(int width) {
        this.width = width;
    }

    // 私有属性 高的get方法
    public int getHeigth() {
        return heigth;
    }

    // 私有属性 高的set方法
    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    // 私有属性 敌机x坐标的get方法
    public int getX() {
        return x;
    }

    // 私有属性 敌机x坐标的set方法
    public void setX(int x) {
        this.x = x;
    }

    // 私有属性 敌机y坐标的get方法
    public int getY() {
        return y;
    }

    // 私有属性 敌机y坐标的set方法
    public void setY(int y) {
        this.y = y;
    }

    // 敌机移动方法 往下移 可视为敌机的移动速度
    public void move() {
        this.y += 1;

    }

    // 画敌机的方法
    public void drawImage(Graphics g) {
        g.drawImage(enemyImageIcon.getImage(), x, y, null);

    }

}
