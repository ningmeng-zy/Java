/*
旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length-1;
        while(low < high){
            int mid = low +(high - low)/2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}

/*
二进制中1的个数
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
*/
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}

/*
数字在排序数组中出现的次数
统计一个数字在排序数组中出现的次数。
*/
public class Solution {
    public static int GetNumberOfK(int [] array , int k) {
       if(array == null || array.length < 0){
           return 0;
       }
        int firstNum = getfirst(array,0,array.length-1,k);
        if(firstNum == -1){
            return 0;
        }
        int endNum = getend(array,firstNum,array.length-1,k);
        return endNum - firstNum + 1;
    }
    public static int getfirst(int[] array,int start,int end ,int k){
        if(start > end ){
            return -1;
        }
        int mid = (start+end)>>1;
        if(array[mid] == k){
            if(mid == 0 || array[mid-1]!=k){
                return mid;
            }else{
                end = mid - 1;
            }
        }else if(array[mid] < k){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        return getfirst(array,start,end,k);
    }
    public static int getend(int[] array,int start,int end,int k){
        if(start > end ){
            return -1;
        }
        int mid = (start+end)>>1;
        if(array[mid] == k){
            if(mid == array.length-1 || array[mid+1] != k){
                return mid;
            }else{
                start = mid + 1;
            }
        }else if(array[mid] < k){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        return getend(array,start,end,k);
    }
}

/*
数值的整数次方
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
*/
public class Solution {
    public double Power(double base, int exponent) {
        double ret  = 0;
        if(exponent > 0){
            if(exponent == 1){
                return base;
            }else{
                ret = powerNum(base,exponent);
            }
        }else if(exponent < 0){
            ret = 1 / powerNum(base,-exponent);
        }else{
            return 1;
        }
        return ret;
    }
    public static double powerNum(double base, int exponent){
        double count = 1;
        if(base == 0){
            return 0;
        }
        for(int i=1;i<=exponent;i++){
            count *= base;
        }
        return count;
    }
}

/*
矩阵覆盖
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
n = 1 --->1    n = 2 ---> 2     n = 3 --->3    n = 4 ---> 5
*/
public class Solution {
    public int RectCover(int target) {
        if(target < 1){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return RectCover(target-1)+RectCover(target-2);
    }
}

/*
和为S的两个数字
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int low = 0;
        int high = array.length-1;
        while(low < high){
            if(array[low]+array[high] == sum){
                list.add(array[low]);
                list.add(array[high]);
                break;
            }else if(array[low]+array[high] < sum){
                low++;
            }else{
                high--;
            }
        }
        return list;
    }
}