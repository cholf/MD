package mq;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/13
 * Time  : 下午12:53
 * 类描述 :
 */
public class Consumer {

    private Object lock;
    public Consumer(Object lock){
        this.lock = lock;
    }

    public void get(){
        try {
            synchronized (lock){
                if(Product.value.equals("")){
                    lock.wait();
                }
                System.out.println("get:"+Product.value);
                Product.value="";
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
