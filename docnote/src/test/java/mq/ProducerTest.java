package mq;

import mq.thread.CThead;
import mq.thread.PThead;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/13
 * Time  : 下午1:06
 * 类描述 :
 */
public class ProducerTest {

    public static void main(String[] args) {
        Object lock = new Object();
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);

        Thread p = new PThead(producer);
        Thread c = new CThead(consumer);

        p.start();c.start();
    }

}