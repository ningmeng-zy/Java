package lesson5;

/**
 * @ClassName BreadOperator
 * @Description TODO BreadOperator
 * @Author 张洋
 * @Date 2020/4/4 10:04
 * @Version 2018.1.5
 **/
public class BreadOperator {
    public static volatile int SUM;

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            new Thread(new Producer(),"面包师傅"+i).start();
        }
        for (int i=0; i<5; i++){
            new Thread(new Consumer(),"消费者"+i).start();
        }
    }
    private static class Producer implements Runnable{

        @Override
        public void run() {
            try {
                for (int i=0; i<20; i++){
                    synchronized (BreadOperator.class){
                        while (SUM + 3 > 100){
                            BreadOperator.class.wait();
                        }
                        SUM += 3;
                        Thread.sleep(10);
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName()+",生产了，库存为："+SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                while (true){
                    synchronized (BreadOperator.class){
                        while (SUM == 0){
                            BreadOperator.class.wait();
                        }
                        SUM--;
                        Thread.sleep(10);
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName()+",消费了，库存为："+SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

