package SecondDay;

import java.io.IOException;

class threeClass {
    public static void main(String[] args) throws InterruptedException, IOException {
        for (int i = 0; i < 10; i++) {
            Runtime.getRuntime().exec("Calculator");
        }
    }
}