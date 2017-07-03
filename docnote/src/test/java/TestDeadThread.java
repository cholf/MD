package test.java;

import main.thread.DeadThread;

/**
 * Created by bbking on 17-7-1.
 */
public class TestDeadThread {
    public static void main(String[] args) {
        try {
            DeadThread t1 = new DeadThread();
            t1.setName("a");
            Thread thread1 = new Thread(t1);
            thread1.start();
            Thread.sleep(200);
            t1.setName("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
