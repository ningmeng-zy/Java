//把数组排成最小的数;调整数组顺序使奇数位于偶数前面;滑动窗口的最大值;最小的K个数;顺时针打印矩阵;数组中的逆序对
/*
把数组排成最小的数
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/
import java.util.*;
public class Solution {
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int str1 = Integer.valueOf(numbers[i]+""+numbers[j]);
                int str2 = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(str1 > str2){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        String str = new String("");
        for(int i=0;i<numbers.length;i++){
            str += numbers[i];
        }
        return str;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        String ret = PrintMinNumber(array);
        System.out.println(ret);
    }
}

/*
调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/
import java.util.*;
public class Solution {
    public void reOrderArray(int [] array) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for(int i=0;i<array.length;i++){
            if(array[i] % 2 == 1){
                queue1.offer(array[i]);
            }else{
                queue2.offer(array[i]);
            }
        }
        int i=0;
        while(!queue1.isEmpty()){
            array[i++] = queue1.poll();
        }
        while(!queue2.isEmpty()){
            array[i++] = queue2.poll();
        }
    }
}

/*
滑动窗口的最大值
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || size > num.length || size == 0){
            return list;
        }
        int i = 0;
        int j = i+size-1;
        int count = num.length-size;
        for(int n=0;n<count+1;n++){
            func(num,list,i,j);
            i++;
            j++;
        }
        return list;
    }
    public void func(int[] num,ArrayList<Integer> list,int i,int j){
        int m = i;
        int ret = num[i];
        for(;m<j;m++){
            if(ret < num[m+1]){
                ret = num[m+1];
            }
        }
        list.add(ret);
    }
}

/*
最小的K个数
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k<=0 || k>input.length){
            return list;
        }
        for(int i=1;i<input.length;i++){
            int j=i-1;
            int ret = input[i];
            while(j>=0&&input[j]>ret){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = ret;
        }
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
}

/*
顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int up = 0;
        int left = 0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;
        while(true){
            for(int i=left;i<=right;i++){
                list.add(matrix[up][i]);
            }
            up++;
            if(up>down){
                break;
            }
            for(int j=up;j<=down;j++){
                list.add(matrix[j][right]);
            }
            right--;
            if(left>right){
                break;
            }
            for(int m=right;m>=left;m--){
                list.add(matrix[down][m]);
            }
            down--;
            if(up>down){
                break;
            }
            for(int n=down;n>=up;n--){
                list.add(matrix[n][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return list;
    }
}

/*
数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
*/
public class Solution {
    private int count;
    private void MergeSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        MergeSort(array,start,mid);
        MergeSort(array,mid+1,end);
        MergeSort(array,start,mid,end);
    }
    private void MergeSort(int[] array,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        int k=0;
        int i=start;
        int j=mid+1;
        while(i<=mid&&j<=end){
            if(array[i]<array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
                count = (count+(mid-i+1))%1000000007;
            }
        }
        while(i<=mid){
            temp[k++] = array[i++];
        }
        while(j<=end){
            temp[k++] = array[j++];
        }
        for(int l=0; l<k; l++){
            array[start+l] = temp[l];
        }
    }
    public int InversePairs(int [] array) {
        MergeSort(array,0,array.length-1);
        return count;
    }
}

