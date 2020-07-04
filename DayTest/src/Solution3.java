/**
 * @ClassName Solution3
 * @Description TODO
 * @Author 张洋
 * @Date 2020/5/14 20:47
 * @Version 2020.1
 **/
/*

 */

/*
左旋转字符串
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
是不是很简单？OK，搞定它！
 */
    /*
public class Solution3{
    public static String leftRotateString(char[] chars,int n) {
        if(chars==null ||chars.length<=0)
            return String.valueOf(chars);
        if(n<=0 || n>chars.length)
            return String.valueOf(chars);
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int start,int end){
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] ch = {'a','b','c','d','e'};
        int n = 2;
        String a = leftRotateString(ch,n);
        System.out.println(a);
    }
}
 */
public class Solution3 {
    public static String LeftRotateString(String str,int n) {
        char[] ch = str.toCharArray();
        if (ch.length <= 0){
            return str;
        }
        if (n<=0 || n>ch.length){
            return str;
        }
        change(ch,0,n-1);
        change(ch,n,ch.length-1);
        change(ch,0,ch.length-1);
        return String.valueOf(ch);
    }
    public static void change(char[] ch , int start , int end){
        while (start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        String str = "abcdefgh";
        int n = 4;
        String a = LeftRotateString(str,n);
        System.out.println(a);
    }
}


