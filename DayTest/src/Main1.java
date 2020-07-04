import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO Main1
 * @Author 张洋
 * @Date 2020/4/17 14:37
 * @Version 2018.1.5
 **/
/*
//链接：https://www.nowcoder.com/questionTerminal/e016ad9b7f0b45048c58a9f27ba618bf
//来源：牛客网
//有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
//给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
//测试样例：
//[1,3,5,2,2],5,3
//返回：2
import java.util.*;
public class Main1 {
    public int findKth(int[] a, int n, int K) {
        return findKth(a,0,n-1,K);
    }
    public int findKth(int[] a, int low,int high,int k){
        int mid = partation(a,low,high);
        if(k == mid - low +1){
            return a[mid];
        }else if(k > mid - low +1){
            return findKth(a,mid+1,high,k-mid+low-1);
        }else{
            return findKth(a,low,mid-1,k);
        }
    }
    public int partation(int[] a, int low, int high){
        int key = a[low];
        while(low < high){
            while(low < high && a[high] <= key){
                high--;
            }
            if(low < high){
                a[low] = a[high];
            }
            while(low < high && a[low] >= key){
                low++;
            }
            if(low < high){
                a[high] = a[low];
            }
        }
        a[low] = key;
        return low;
    }
}
//统计回文
//链接：https://www.nowcoder.com/questionTerminal/9d1559511b3849deaa71b576fa7009dc
//来源：牛客网
//
//“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。花花非常喜欢这种拥有对称美的回文串，
// 生日的时候她得到两个礼物分别是字符串A和字符串B。现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。
// 你接受花花的请求，帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
//例如：
//A = “aba”，B = “b”。这里有4种把B插入A的办法：
//* 在A的第一个字母之前: "baba" 不是回文
//* 在第一个字母‘a’之后: "abba" 是回文
//* 在字母‘b’之后: "abba" 是回文
//* 在第二个字母'a'之后 "abab" 不是回文
//所以满足条件的答案为2
public class Main1 {
    public static boolean isHuiWen(String str){
        int i = 0;
        int j = str.length()-1;
        while (i < j){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for (int i=0;i<=str1.length();i++){
            StringBuilder s = new StringBuilder(str1);
            s.insert(i,str2);
            if (isHuiWen(s.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
*/