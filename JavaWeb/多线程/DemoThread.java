package lesson2;

/**
 * @ClassName DemoThread
 * @Description TODO DemoThread
 * @Author 张洋
 * @Date 2020/3/27 19:36
 * @Version 2018.1.5
 **/
public class DemoThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置线程为守护线程
        t.setDaemon(true);
        t.start();
    }
}
