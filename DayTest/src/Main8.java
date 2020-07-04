
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main8
 * @Description TODO Main8
 * @Author 张洋
 * @Date 2020/4/25 21:17
 * @Version 2018.1.5
 **/
/*
[编程题]69386-n个数里最小的k个
链接:https://www.nowcoder.com/questionTerminal/cc727473d1e248ccb674eb31bd8683dc
找出n个数里最小的k个
 */
import java.util.*;
public class Main8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int[] num = new int[s.length-1];
            for(int i=0;i<s.length-1;i++){
                num[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(s[s.length-1]);
            int start = 0;
            int end = num.length-1;
            int index = qSort(num, start,end);
            while(index != k){
                if(index>k){
                    end = index - 1;
                    index = qSort(num, start, end);
                }else{
                    start = index + 1;
                    index = qSort(num, start, end);
                }
            }
            Arrays.sort(num, 0, k);
            for(int i=0;i<k;i++){
                System.out.print(i==k-1?num[i]:num[i] + " ");
            }
        }
    }
    public static int qSort(int[] num, int start, int end){
        int dig = num[start];
        while(start<end){
            while(start<end && num[end]>=dig)end--;
            num[start] = num[end];
            while(start<end && num[start]<dig)start++;
            num[end] = num[start];
        }
        num[start] = dig;
        return start;
    }
}
/*
[编程题]26011-删数
https://www.nowcoder.com/practice/f9533a71aada4f35867008be22be5b6e?tpId=49&&tqId=29296&r
p=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除
 */
/*


public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n > 1000){
                n = 999;
            }
            List<Integer> L = new ArrayList<>();
            for (int i=0;i<n;i++){
                L.add(i);
            }
            int ret = 0;
            while (L.size()>1){
                ret = (ret+2)%L.size();
                L.remove(ret);
            }
            System.out.println(L.get(0));
        }
    }
}
 */