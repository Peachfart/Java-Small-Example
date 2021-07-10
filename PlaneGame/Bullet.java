package PlaneGame;

import java.awt.Graphics;

import javax.swing.ImageIcon;

//子弹类
public class Bullet {
    // 子弹宽高
    private int width;
    private int heigth;
    // 子弹位置
    private int x;
    private int y;
    // 子弹图片
    private ImageIcon bulletImageIcon = new ImageIcon("src/PlaneGame/img/bullet.png");

    // 构造方法 初始化子弹 子弹的位置x、y跟随鼠标位置 通过构造方法将鼠标位置传入
    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = bulletImageIcon.getIconWidth();
        this.heigth = bulletImageIcon.getIconHeight();
    }

    // 私有属性 子弹宽度width的get方法
    public int getWidth() {
        return width;
    }

    // 私有属性 子弹宽度width的set方法
    public void setWidth(int width) {
        this.width = width;
    }

    // 私有属性 子弹高度heigth的get方法
    public int getHeigth() {
        return heigth;
    }

    // 私有属性 子弹高度heigth的set方法
    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    // 私有属性 子弹坐标x的get方法
    public int getX() {
        return x;
    }

    // 私有属性 子弹坐标x的set方法
    public void setX(int x) {
        this.x = x;
    }

    // 私有属性 子弹坐标y的get方法
    public int getY() {
        return y;
    }

    // 私有属性 子弹坐标y的set方法
    public void setY(int y) {
        this.y = y;
    }

    // 子弹移动方法 子弹向上移 可视为子弹移动速度
    public void move() {
        this.y -= 3;

    }

    // 子弹绘制方法
    public void drawImage(Graphics g) {
        g.drawImage(bulletImageIcon.getImage(), x, y, null);

    }

}
