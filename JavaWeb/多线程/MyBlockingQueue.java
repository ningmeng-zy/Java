package lesson6;

/**
 * @ClassName MyBlockingQueue
 * @Description TODO MyBlockingQueue
 * @Author 张洋
 * @Date 2020/4/4 11:27
 * @Version 2018.1.5
 **/
public class MyBlockingQueue<E> {
    private Object[] items;

    private int takeIndex;
    private int putIndex;
    private int size;

    public MyBlockingQueue(int capacity){
        items = new Object[capacity];
    }

    public synchronized void put(E e) throws InterruptedException {
        while (size == items.length){
            wait();
        }
        putIndex =(putIndex+1)%items.length;
        items[putIndex] = e;
        size++;
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (size == 0){
            wait();
        }
        takeIndex = (takeIndex+1)%items.length;
        size--;
        notifyAll();
        return (E) items[takeIndex];
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i=0; i<5; i++){
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0; j<100; j++){
                        try {
                            queue.put(k*100+j);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        while (true){
            int num = queue.take();
            System.out.println(num);
        }
    }
}
