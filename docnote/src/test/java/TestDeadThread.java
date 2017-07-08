package test.java;

import main.thread.DeadThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bbking on 17-7-1.
 */
public class TestDeadThread {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(1, 1, 1, TimeUnit.DAYS,
                    new ArrayBlockingQueue<Runnable>(1));
            threadPoolExecutor.submit()
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
