package ninethDay;

import java.util.Timer;
import java.util.TimerTask;

public class fourClass {

    public static void main(String[] args) {
        /*
         * 定时器,定时运行某些代码
         */
        Timer t = new Timer();
        // 启动定时器
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("哈拉少");
            }

        }, 2000, 2000);
    }
}
