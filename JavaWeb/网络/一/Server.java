package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Server
 * @Description TODO Server
 * @Author 张洋
 * @Date 2020/4/26 18:53
 * @Version 2018.1.5
 **/
public class Server {
    private static final int PORT = 9000;

    private static final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true){
            //阻塞等待，直到有新的客户端连接
            Socket client = server.accept();
            POOL.execute(new Task(client));
        }

    }

    private static class Task implements Runnable{

        private Socket client;

        public Task(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                String str;
                //阻塞等待客户端数据输入
                int i = 1;
                while ((str = in.readLine()) != null && !str.equals("exit")){//io流在结束时返回才是null
                    System.out.println(str);
                    out.println(i + " "+"nice");
                    i++;
                }
                out.println("exit");
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
