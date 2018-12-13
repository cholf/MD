package basicjava.waitnotify;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/12/10
 * Time  : 下午9:04
 * 类描述 :
 */
public class Test {

    public static void main(String[] args) {
        ObjectWaitNotify objectWaitNotify = new ObjectWaitNotify(12);
        Runnable thread =  new PThread(objectWaitNotify) ;
        thread.run();
        Runnable gThread =  new GThread(objectWaitNotify);
        gThread.run();
    }
}
