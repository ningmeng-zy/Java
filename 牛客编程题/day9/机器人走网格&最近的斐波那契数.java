import java.util.Scanner;

/**
 * @ClassName Main10
 * @Description TODO
 * @Author 张洋
 * @Date 2020/5/7 16:53
 * @Version 2020.1
 **/
/*
链接：https://www.nowcoder.com/questionTerminal/e8bb8e68434e42acbcdff0341f2a32c5
来源：牛客网

有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。

给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。

测试样例：
2,2
返回：2
 */
public class Robot {
    public int countWays(int x, int y) {
        if (x==1||y==1){
            return 1;
        }
        return countWays(x,y-1)+countWays(x-1,y);
    }
}
/*
链接：https://www.nowcoder.com/questionTerminal/18ecd0ecf5ef4fe9ba3f17f8d00d2d66
来源：牛客网

Fibonacci数列是这样定义的：
F[0] = 0
F[1] = 1
for each i ≥ 2: F[i] = F[i-1] + F[i-2]
因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。
给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 */

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int a = 0;
            int b = 1;
            int c = 1;
            while (n>c){
                a = b;
                b = c;
                c = a+b;
            }
            int d = c-n;
            int e = n-b;
            System.out.println(d>e?e:d);
        }
    }
}

