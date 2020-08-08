/*
最小数位和
链接：https://www.nowcoder.com/questionTerminal/4fc97c45a69241e992b3e705e817909c
来源：牛客网

定义\mathit S(n)S(n)，表示\mathit nn在十进制下的各位数字和。
现在给定一个\mathit xx,请你求出最小正整数\mathit nn，满足x \leq S(n)x≤S(n).
输入描述:
第一行数据组数\mathit TT，对于每组数据，一行一个数字x。
1 <= x <= 10^5 , 1 <= T <= 10 

输出描述:
对于每组数据，一行一个整数表示最小的n。
示例1
输入
2
7
9 
输出
7
9
示例2
输入
2 
13
18
输出
49  
99
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        for(int j=0;j<array.length;j++){
            int m1 = array[j] / 9;
            int m2 = array[j] % 9;
            StringBuilder str = new StringBuilder();
            if(m2!=0){
                str.append(m2);
            }
            for(int x=0;x<m1;x++){
                str.append(9);
            }
            System.out.println(str);
        }
    }
}