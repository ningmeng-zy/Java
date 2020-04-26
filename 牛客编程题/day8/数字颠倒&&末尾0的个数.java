import java.util.Scanner;

/**
 * @ClassName Main9
 * @Description TODO Main9
 * @Author 张洋
 * @Date 2020/4/26 15:23
 * @Version 2018.1.5
 **/
/*
[编程题]36835-数字颠倒
链接https://www.nowcoder.com/questionTerminal/ae809795fca34687a48b172186e3dafe
本题关键思路:
每次取得当前数的个位数然后拼接到目标数的最前面即完成倒序。
num%10取得个位数,
Num/10进入下一轮循环
描述：
输入一个整数，将这个整数以字符串的形式逆序输出
程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class Main9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            String str = "";
            while (num != 0){
                int n1 = num % 10;
                int n2 = num / 10;
                str = str + String.valueOf(n1);
                num = n2;
            }
            System.out.println(str);
        }
    }
}

/*
[编程题]58540-末尾0的个数
链接：https://www.nowcoder.com/questionTerminal/6ffdd7e4197c403e88c6a8aa3e7a332a
【解题思路】：
任意挑选几个数字进行分解质因数，例如：
6 = 2*3
15 = 3*5
64 = 2*2*2*2*2*2 = 2^6
100 = 2^2 * 5^2
576 = 2^6 * 3^2
那么我们在计算n的阶乘时，实际上就是把所有小于等于n的正整数分解成质因数，然后再将其乘到一起，那
么末尾0的个数实际上就是2*5的个数，而2的个数明显是很多很多的，所以问题就转化成了5的个数。
而只有5的倍数才有5这个因数，所以，问题就进一步简化为小于等于n的数中有多少个数是5的倍数，当然25
的倍数，125的倍数，625还要单独考虑。
输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 */

import java.util.*;
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = n; i >= 5; i--) {
            int tmp = i;
            while(tmp % 5 == 0) {
                res++;
                tmp /= 5;
            }
        }
        System.out.println(res);
    }
}
