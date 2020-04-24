import java.util.Scanner;

/**
 * @ClassName Main7
 * @Description TODO Main7
 * @Author 张洋
 * @Date 2020/4/24 20:58
 * @Version 2018.1.5
 **/
/*
[编程题]36932-求最小公倍数
链接https://www.nowcoder.com/questionTerminal/22948c2cad484e0291350abad86136c3
正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 */
/*
//方法一：
import java.util.Scanner;
public class Main7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int ret = 0;
            if(A == B){
                ret = A;
                System.out.println(ret);
            }
            int max = 0;
            int min = 0;
            if(A > B){
                max = A;
                min = B;
            }else{
                max = B;
                min = A;
            }
            for(int i=1; i<=min; i++){
                if((max*i)%min == 0){
                    ret = max * i;
                    System.out.println(ret);
                    break;
                }
            }
        }
    }
}
*/
//方式二
public class Main7 {
    public static int lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(lcm(a, b));
    }
}
/*
链接：https://www.nowcoder.com/questionTerminal/1183548cd48446b38da501e58d5944eb
来源：牛客网
二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
小易想知道最多可以放多少块蛋糕在网格盒子里。
//就是每四行四列为一个周期pattern相同如下的图案：
＊＊ 1 1 ＊＊ 1 1 ＊＊ 1 1
＊＊ 1 1 ＊＊ 1 1 ＊＊ 1 1
1 1 ＊＊ 1 1 ＊＊ 1 1 ＊＊
1 1 ＊＊ 1 1 ＊＊ 1 1 ＊＊
＊＊ 1 1 ＊＊ 1 1 ＊＊ 1 1
＊＊ 1 1 ＊＊ 1 1 ＊＊ 1 1
 */
/*
import java.util.Scanner;
public class Main7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int ret = 0;
            if(w%4==0||h%4==0){
                ret = (w*h)/2;
                System.out.println(ret);
            }else{
                ret = (w*h)/2+1;
                System.out.println(ret);
            }
        }
    }
}
*/