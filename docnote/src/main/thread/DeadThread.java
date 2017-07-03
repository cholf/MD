package main.thread;

/**
 * Created by bbking on 17-7-1.
 * 死锁测试
 */
public class DeadThread implements Runnable{

    public String name;
    public Object object1 = new Object();
    public Object object2 = new Object();


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

    public void setName (String name){
        this.name = name;
        System.out.println("set_name_"+name+"__"+Thread.currentThread().getName());
    }
    @Override
    public void run() {
        if (name.equals("a")){
            synchronized (object1){
                try {
                    System.out.println("userName+"+name);
                    System.out.println("run_a_obj1_"+Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("run_a_obj2_"+Thread.currentThread().getName());
                    System.out.println("object1-object2");
                }
            }
        }

        if (name.equals("b")){
            synchronized (object2){
                try {
                    System.out.println("userName+"+name);
                    System.out.println("run_b_obj1_"+Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("run_b_obj2_"+Thread.currentThread().getName());
                    System.out.println("object2-object1");
                }
            }
        }

    }
}
