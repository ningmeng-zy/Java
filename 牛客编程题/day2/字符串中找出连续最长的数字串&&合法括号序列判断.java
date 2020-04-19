import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName Main3
 * @Description TODO Main3
 * @Author 张洋
 * @Date 2020/4/19 15:41
 * @Version 2018.1.5
 **/
/*
[编程题]36939-合法括号序列判断
链接:https://www.nowcoder.com/questionTerminal/d8acfa0619814b2d98f12c071aef20d4
对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
*/

public class Main3{
    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> s = new Stack<>();
        if(A == null || n == 0){
            return false;
        }
        for (int i = 0; i<n; i++){
            if (A.charAt(i) == '('){
                s.push(A.charAt(i));
            }else if (A.charAt(i) == ')'){
                if (s.empty()){
                    return false;
                }else {
                    s.pop();
                }
            }else {
                return false;
            }
        }
        if (!s.empty()){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        String str = "(()())";
        int n = 6;
        boolean a = chkParenthesis(str,n);
        System.out.println(a);
    }
}
/*
[编程题]69385-字符串中找出连续最长的数字串
链接:https://www.nowcoder.com/questionTerminal/bd891093881d4ddf9e56e7cc8416562d
读入一个字符串str，输出字符串str中的连续最长的数字串
 */


public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int count=0;
            int max=0;
            int end=0;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)>='0' && str.charAt(i)<='9'){
                    count++;
                    if (count>max){
                        max = count;
                        end = i;
                    }
                }else {
                    count = 0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }
    }
}
