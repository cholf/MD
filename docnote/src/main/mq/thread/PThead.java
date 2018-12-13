package mq.thread;

import mq.Producer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/13
 * Time  : 下午1:02
 * 类描述 :
 */
public class PThead extends Thread {

    private Producer producer;
    public PThead(Producer producer){
        this.producer=producer;
    }

    @Override
    public void run(){
        while (true){
            producer.put();
        }
    }
}
