import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Solution
 * @Description TODO Solution
 * @Author 张洋
 * @Date 2020/4/15 14:16
 * @Version 2018.1.5
 **/


//变态跳台阶
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class Solution {
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return 2*JumpFloorII(target-1);
    }
}

//把字符串转换成整数
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
public class Solution {
    public static int StrToInt(String str) {
        if (str == null || str.length() <= 0){
            return 0;
        }
        char[] ch= str.toCharArray();
        long num = 0;
        boolean judge = false;
        for (int i=0; i<ch.length;i++){
            if (i == 0 && ch[i] == '-'){
                judge = true;
            }else if (i == 0 && ch[i] == '+'){
                judge = false;
            }else {
                int a = (int)(ch[i]-'0');
                if (a<0||a>9){
                    return 0;
                }
                num = (judge==false)?num*10+a:num*10-a;
                if((!judge && num>0x7FFFFFFF)
                        ||(judge && num<0x80000000)){
                    return 0;
                }
            }
        }
        return (int) num;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int n = StrToInt(str);
            System.out.println(n);
        }
    }
}
//不用加减乘除做加法
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class Solution {
    public static int Add(int num1,int num2) {
        if (num1 == 0){
            return num2;
        }
        if (num2 == 0){
            return num1;
        }
        int s1 = num1^num2;
        int s2 = (num1 & num2) << 1;
        int s = Add(s1,s2);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int A = Add(n1,n2);
        System.out.println(A);
    }
}


//构建乘积数组
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
// 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
public class Solution {
    public static int[] multiply(int[] A) {
        if (A == null){
            return A;
        }
        int[] B = new int[A.length];
        for (int i=0; i<A.length;i++){
            int sum = 1;
            for (int j=0; j<A.length; j++){
                if (j != i){
                    sum *= A[j];
                }
            }
            B[i] = sum;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A ={1,2,3,4,5,6};
        int[] R = multiply(A);
        System.out.println(Arrays.toString(R));
    }
}
