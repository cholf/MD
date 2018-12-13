package mq;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/13
 * Time  : 下午12:53
 * 类描述 :
 */
public class Producer {

    private Object lock;
    public Producer(Object lock){
        this.lock = lock;
    }

    public void put(){

        try {
            synchronized (lock){
                if(!Product.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                Product.value=value;
                System.out.println("set:"+value);
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
