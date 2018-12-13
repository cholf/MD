package mq.thread;

import mq.Consumer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/13
 * Time  : 下午1:02
 * 类描述 :
 */
public class CThead extends Thread {

    private Consumer consumer;
    public CThead(Consumer consumer){
        this.consumer=consumer;
    }

    @Override
    public void run(){
        while (true){
            consumer.get();
        }
    }
}
