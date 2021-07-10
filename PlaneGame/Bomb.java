package PlaneGame;

import java.awt.Graphics;

import javax.swing.ImageIcon;

//碰撞类
public class Bomb {
    // 碰撞图片的坐标 左上角
    private int x;
    private int y;
    // 碰撞图片的宽高
    private int width;
    private int heigth;
    // 删除的次数
    private int count;
    // 碰撞图片
    private ImageIcon bombImageIcon = new ImageIcon("src/PlaneGame/img/bomb.png");

    // 构造方法 初始化爆炸图片 爆炸图片显示再敌机位置 视觉效果为敌机被子弹击中敌机爆炸 通过创建对象时将敌机位置传入
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = bombImageIcon.getIconWidth();
        this.heigth = bombImageIcon.getIconHeight();

    }

    // 私有属性 爆炸图片x坐标的get方法
    public int getX() {
        return x;
    }

    // 私有属性 爆炸图片x坐标的set方法
    public void setX(int x) {
        this.x = x;
    }

    // 私有属性 爆炸图片y坐标的get方法
    public int getY() {
        return y;
    }

    // 私有属性 爆炸图片y坐标的set方法
    public void setY(int y) {
        this.y = y;
    }

    // 私有属性 爆炸图片宽度的get方法
    public int getWidth() {
        return width;
    }

    // 私有属性 爆炸图片宽度的set方法
    public void setWidth(int width) {
        this.width = width;
    }

    // 私有属性 爆炸图片高度的get方法
    public int getHeigth() {
        return heigth;
    }

    // 私有属性 爆炸图片高度的set方法
    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    // 绘制爆炸图片方法
    public void drawImage(Graphics g) {
        g.drawImage(bombImageIcon.getImage(), x, y, null);

    }

    // 私有属性 爆炸图片次数的get方法
    public int getCount() {
        return count;
    }

    // 私有属性 爆炸图片次数的set方法
    public void setCount(int count) {
        this.count = count;
    }

    // 多次调用move方法爆炸图片并不移动 只拖延时间 count达到一定次数之后再删除爆炸图片
    public void move() {
        count++;
    }

}
