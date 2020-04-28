package lesson2;

/**
 * @ClassName ThreadJoin
 * @Description TODO ThreadJoin
 * @Author 张洋
 * @Date 2020/3/27 20:12
 * @Version 2018.1.5
 **/
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        withoutSleep();
        withSleep();
        //当前线程：代码行执行的时候，所在线程
        //t线程：线程引用的对象
        //当前线程进行阻塞（运行态-->阻塞态）等待（满足一定的条件），t线程（不做任何处理，让t执行运行）
        //一定的条件是什么：以下哪个先执行完，就满足
        // （1）传入时间（时间值+时间单位毫秒）
        //（2）线程引用对象执行完毕

    }
    public static void withSleep() throws InterruptedException {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }
    public static void withoutSleep() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName());
    }
}
