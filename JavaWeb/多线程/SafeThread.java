package lesson4;

/**
 * @ClassName SafeThread
 * @Description TODO SafeThread
 * @Author 张洋
 * @Date 2020/3/29 09:38
 * @Version 2018.1.5
 **/
public class SafeThread {
    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private volatile static int SUM;
    public static void main(String[] args) {
        //同时启动20个线程，每个线程对同一个变量执行操作；循环10000次，每次循环++操作
        //所有线程执行完毕之后，打印变量值，检查是否是预期的结果
        for (int i = 0; i <NUM; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++){
                        SUM++;
//                      increment();
//                        synchronized (SafeThread.class){
//                            SUM++;
//                        }
//                        synchronized (this){ //对runnable对象进行加锁
//                            SUM++;
//                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        //1.不是预期的结果20*10000
        //2.每次运行的结果不一样
        System.out.println(SUM);
    }

    /**
     * 等同于
     * synchronized(this){}
     */
    public synchronized void increment2(){ //对this对象进行加锁操作

    }
    /**
     * 等同于
     * synchronized(SafeThread.class){}
     */
    public static synchronized void increment(){ //对当前类对象进行加锁操作
        SUM++;
    }
}
