package lesson6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Test
 * @Description TODO Test
 * @Author 张洋
 * @Date 2020/4/4 14:27
 * @Version 2018.1.5
 **/
public class Test {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4); //创建线程池
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到北京，A同学");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到新疆，B同学");
            }
        });
        System.out.println("我正在做事情");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("送快递到北京，A同学");
//            }
//        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("送快递到新疆，B同学");
//            }
//        });
//        System.out.println("我正在做事情");
//
    }
}
