package lesson2;

/**
 * @ClassName ThreadYield
 * @Description TODO ThreadYield
 * @Author 张洋
 * @Date 2020/3/27 20:04
 * @Version 2018.1.5
 **/
public class ThreadYield {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        while (Thread.activeCount() > 1){  //Thread.activeCount()获取当前所在线程组的活跃线程数
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
