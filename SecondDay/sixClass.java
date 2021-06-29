package SecondDay;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class sixClass extends Frame {

    class d1 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(d1.class.getResourceAsStream("./yinjian/d1.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class d2 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(d2.class.getResourceAsStream("./yinjian/d2.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class d3 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(d3.class.getResourceAsStream("./yinjian/d3.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class d4 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(d4.class.getResourceAsStream("./yinjian/d4.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class d5 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(d5.class.getResourceAsStream("./yinjian/d5.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class d6 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(d6.class.getResourceAsStream("./yinjian/d6.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class d7 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(d7.class.getResourceAsStream("./yinjian/d7.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class h1 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(h1.class.getResourceAsStream("./yinjian/h1.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class h2 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(h2.class.getResourceAsStream("./yinjian/h2.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class h3 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(h3.class.getResourceAsStream("./yinjian/h3.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class h4 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(h4.class.getResourceAsStream("./yinjian/h4.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class h5 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(h5.class.getResourceAsStream("./yinjian/h5.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class h6 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(h6.class.getResourceAsStream("./yinjian/h6.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class h7 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                AdvancedPlayer ad = new AdvancedPlayer(h7.class.getResourceAsStream("./yinjian/h7.mp3"));
                ad.play();
            } catch (JavaLayerException e) {

                e.printStackTrace();
            }
        }
    }

    class key extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 65) {
                new d1().start();
            }
            if (e.getKeyChar() == 83) {
                new d2().start();
            }
            if (e.getKeyChar() == 68) {
                new d3().start();
            }
            if (e.getKeyChar() == 70) {
                new d4().start();
            }
            if (e.getKeyChar() == 71) {
                new d5().start();
            }
            if (e.getKeyChar() == 72) {
                new d6().start();
            }
            if (e.getKeyChar() == 74) {
                new d7().start();
            }
            if (e.getKeyChar() == 81) {
                new h1().start();
            }
            if (e.getKeyChar() == 87) {
                new h2().start();
            }
            if (e.getKeyChar() == 69) {
                new h3().start();
            }
            if (e.getKeyChar() == 82) {
                new h4().start();
            }
            if (e.getKeyChar() == 84) {
                new h5().start();
            }
            if (e.getKeyChar() == 89) {
                new h6().start();
            }
            if (e.getKeyChar() == 85) {
                new h7().start();
            }
        }
    }

    public void start() {
        setSize(1000, 1000);
        setVisible(true);
        addKeyListener(new key());
    }

    public static void main(String[] args) {
        // 钢琴V1.1
        // 监视用户按下的按钮
        sixClass s = new sixClass();
        s.start();

    }

}