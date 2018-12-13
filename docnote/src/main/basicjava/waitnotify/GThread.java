package basicjava.waitnotify;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/10
 * Time  : 下午8:55
 * 类描述 :
 */
public class GThread implements Runnable{

    private  ObjectWaitNotify objectWaitNotify;
    public  GThread(ObjectWaitNotify objectWaitNotify){
        this.objectWaitNotify = objectWaitNotify;
    }

    @Override
    public void run() {

        for (;;){
            for (int i=0;i<objectWaitNotify.getSize();i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String value = objectWaitNotify.get(i);
            }
        }
    }
}
