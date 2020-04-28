package lesson2;

/**
 * @ClassName ThreadAdvantage
 * @Description TODO ThreadAdvantage
 * @Author 张洋
 * @Date 2020/3/14 15:51
 * @Version 2018.1.5
 **/
public class ThreadAdvantage {
    // 多线程并不一定就能提高速度，可以观察，count 不同，实际的运行效果也是不同的
    private static final long count = 10_0000_0000;
    public static void main(String[] args) throws InterruptedException {
    // 使用并发方式
        concurrency();
    // 使用串行方式
        serial();
    }
    private static void concurrency() throws InterruptedException {
        long begin = System.nanoTime();
    // 利用一个线程计算 a 的值
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a--;
                }
            }
        });
        thread.start();
    // 主线程内计算 b 的值
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
    // 等待 thread 线程运行结束
        thread.join();
    // 统计耗时
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("并发: %f 毫秒%n", ms);
    }
    private static void serial() {
// 全部在主线程内计算 a、b 的值
        long begin = System.nanoTime();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a--;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("串行: %f 毫秒%n", ms);
    }
}