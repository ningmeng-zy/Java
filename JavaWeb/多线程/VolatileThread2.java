package lesson4;

/**
 * @ClassName VolatileThread2
 * @Description TODO VolatileThread2
 * @Author 张洋
 * @Date 2020/3/29 12:10
 * @Version 2018.1.5
 **/
public class VolatileThread2 {
    private volatile static int SUM;
    public static void main(String[] args) {
        for (int i = 0; i <20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++){
                        if (SUM < 100000) {
                            synchronized (VolatileThread2.class) {
                                SUM++;
                            }

                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(SUM);
    }
}
