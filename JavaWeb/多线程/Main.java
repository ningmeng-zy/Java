package lesson2;

/**
 * @ClassName MyThread
 * @Description TODO MyThread
 * @Author 张洋
 * @Date 2020/3/27 18:50
 * @Version 2018.1.5
 **/
public class Main{
    public static void main(String[] args) {
        //创建线程的方式1
        MyThread myThread = new MyThread();
        myThread.start(); //start方法首先启动了线程，然后再由JVM去调用该线程的run方法
        myThread.run();  //run方法直接调用，不会启动线程，只是在当前main线程中调用了run方法
        //创建线程的方式2
//        new Thread(new MyRunnable()).start();
        //线程启动时通过start方法启动
    }
}
class MyThread extends Thread {
    @Override
    public void run() { //run是线程运行的时候执行的代码块
        //自己的代码
        System.out.println(Thread.currentThread().getName());
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}