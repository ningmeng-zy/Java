import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @ClassName Main4
 * @Description TODO Main4
 * @Author 张洋
 * @Date 2020/4/20 09:12
 * @Version 2018.1.5
 **/

/*
[编程题]69390-删除公共字符
链接:https://www.nowcoder.com/questionTerminal/f0db4c36573d459cae44ac90b90c6212
输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
例如，输入”They are students.”和”aeiou”，
则删除之后的第一个字符串变成”Thy r stdnts.”
 */
/*


//正则表达式     replaceAll方法
public class Main4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String str = "[" + str2+"]";
            String ret = str1.replaceAll(str,"");
            System.out.println(ret);
        }
    }
}
 */

/*
方法一：
public class Main4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            char[] ch = str1.toCharArray();
            for (int i=0;i<ch.length;i++){
                if (!str2.contains(String.valueOf(ch[i]))){
                    System.out.print(ch[i]);
                }
            }

        }
    }
}
*/
/*
链接：https://www.nowcoder.com/questionTerminal/61cfbb2e62104bc8aa3da5d44d38a6ef
来源：牛客网
小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 */
/*
import java.util.Scanner;
public class Main4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNext()){
            int n = sc.nextInt();

            if(n%2==1||n<6||n==10){
                count = -1;
            }else if(n%8 == 0){
                count = n/8;
            }else{
                count = n/8+1;
            }
        }
        System.out.println(count);
    }
}
*/