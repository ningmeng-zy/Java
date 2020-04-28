package lesson4;

/**
 * @ClassName VolatileThread
 * @Description TODO VolatileThread
 * @Author 张洋
 * @Date 2020/3/29 12:01
 * @Version 2018.1.5
 **/
public class VolatileThread {
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
                        //SUM++分解为三条指令
                        //1、读取主内存SUM变量
                        //2、SUM=SUM+1
                        //3.写回主内存
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
}
