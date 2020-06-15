/*
找零
Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
现在小Y使用1024元的纸币购买了一件价值为N (0 < N \le 1024)N(0<N≤1024)的商品，请问最少他会收到多少硬币？
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = func(n);
        System.out.println(ret);
    }
    public static int func(int n){
        int num = 1024 - n;
        int count = 0;
        int sum = 0;
        sum += num / 64;
        count = num % 64;
        sum += count / 16;
        count = count % 16;
        sum += count / 4;
        count = count % 4;
        sum += count / 1;
        return sum;
    }
}

/*
万万没想到之聪明的编辑
我叫王大锤，是一家出版社的编辑。我负责校对投稿来的英文稿件，这份工作非常烦人，因为每天都要去修正无数的拼写错误。但是，优秀的人总能在平凡的工作中发现真理。
我发现一个发现拼写错误的捷径：
1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。用不了多久，我就会出任CEO，
当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
……
万万没想到，我被开除了，临走时老板对我说： “做人做事要兢兢业业、勤勤恳恳、本本分分，人要是行，干一行行一行。
一行行行行行；要是不行，干一行不行一行，一行不行行行不行。” 我现在整个人红红火火恍恍惚惚的……
请听题：请实现大锤的自动校对程序
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = sc.next();
        }
        for(int i=0;i<str.length;i++){
            StringBuffer sb = new StringBuffer(str[i]);
            for(int j=2;j<sb.length();j++){
                if(sb.charAt(j) == sb.charAt(j-1) && sb.charAt(j-2) == sb.charAt(j-1)){
                    sb.deleteCharAt(j);
                    j--;
                }else if(j>=3 && sb.charAt(j) == sb.charAt(j-1) && sb.charAt(j-2) == sb.charAt(j-3)){
                    sb.deleteCharAt(j);
                    j--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}