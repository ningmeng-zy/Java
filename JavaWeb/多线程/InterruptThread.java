package lesson3;

/**
 * @ClassName InterruptThread
 * @Description TODO InterruptThread
 * @Author 张洋
 * @Date 2020/3/27 21:08
 * @Version 2018.1.5
 **/
public class InterruptThread {
    //中断一个线程，但是线程没有处理中断
    public static void test1(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        });
        t.start();
        t.interrupt();//在main线程对子线程进行中断
    }
    public static void test2() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0;i<50;i++){
//                    System.out.println(i+"="+Thread.currentThread().isInterrupted());
//                }
                //线程运行状态时，需要自行判断线程中断标志位，处理中断操作
                //阻塞状态时，通过捕获及处理异常，来中断线程的中断逻辑
                while (!Thread.interrupted()){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        t.start();//t线程的中断标志位=false
        t.interrupt();//t线程的中断标志位=true
    }
    public static void test3() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().isInterrupted());
                    //线程调用wait()/join()/sleep()阻塞时，如果把当前线程给中断，会直接抛一个异常
                    //抛出异常以后，线程中断标志位会重置
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t.start();//t线程的中断标志位=false
        t.interrupt();//t线程的中断标志位=true
    }
    public static void test4() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
//                    System.out.println(Thread.interrupted()); //返回中断标志位，并重置标志位
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t.start();//t线程的中断标志位=false
        t.interrupt();//t线程的中断标志位=true
    }
    public static volatile boolean IS_INTERRUPTED;
    //使用自定义的中断标志位
    public static void test5(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //自定义的标志位能满足线程处于运行态的中断操作
//                while (IS_INTERRUPTED){
//                    System.out.println(Thread.currentThread().getName());
//                }
                //自定义的标志位满足不了线程处于阻塞状态时的中断操作
                try {
                    Thread.sleep(999999);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        IS_INTERRUPTED = true;
    }
    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }
}
