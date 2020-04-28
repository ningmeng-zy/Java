package src.lesson5;

/**
 * @ClassName SingtonMain
 * @Description TODO SingtonMain
 * @Author 张洋
 * @Date 2020/4/3 09:26
 * @Version 2018.1.5
 **/
public class SingtonMain {
    public static void main(String[] args) {
//        Sington sington = Sington.getInstance();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Sington sington = Sington.getInstance();
            }
        }).start();
    }
}
