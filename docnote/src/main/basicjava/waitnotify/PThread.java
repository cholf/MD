package basicjava.waitnotify;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/10
 * Time  : 下午8:55
 * 类描述 :
 */
public class PThread  implements Runnable{

    private  ObjectWaitNotify objectWaitNotify;
    public  PThread(ObjectWaitNotify objectWaitNotify){
        this.objectWaitNotify = objectWaitNotify;
    }

    @Override
    public void run() {

        int index =0;
        for (;;){
            index++;
            objectWaitNotify.put(index+"号");
        }
    }
}
