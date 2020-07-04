import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO Main2
 * @Author 张洋
 * @Date 2020/4/18 16:04
 * @Version 2018.1.5
 **/
/*
链接：https://www.nowcoder.com/questionTerminal/bb06495cc0154e90bbb18911fd581df6
来源：牛客网
有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计一个高效的算法，计算给定数组中的逆序对个数。
给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
 */
//2.分治思想
public class Main2{
    public static int count(int[] A, int n) {
        if (A == null || n == 0){
            return 0;
        }
        return mergeSort(A,0,n-1);
    }
    public static int mergeSort(int[] array, int left, int right) {
        if (left == right){
            return 0;
        }
        int mid = (right + left)>>1;
        return mergeSort(array,left,mid)+mergeSort(array,mid+1,right)+merge(array,left,mid,right);
    }
    public static int merge(int[] array,int left, int mid, int right){
        int[] temp = new int[array.length];
        int index = 0;
        int i = left;
        int j = mid+1;
        int count = 0;
        return 1;
    }
}
/*
import java.util.*;
//1.暴力法
public class Main2 {
    public int count(int[] A, int n) {
        int count = 0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
*/
/*
[编程题]36846-汽水瓶
https://www.nowcoder.com/practice/fe298c55694f4ed39e256170ff2c205f?tpId=37&&tqId=21245&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
*/
/*
import java.util.Scanner;
public class Main2{
    public static int func(int n){
        int count = 0;
        while(n > 2){
            count = count + n/3;
            n = n/3+n%3;
        }
        if(n==2){
            count = count + 1;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int ret = func(n);
            System.out.println(ret);
        }
    }
}
 */