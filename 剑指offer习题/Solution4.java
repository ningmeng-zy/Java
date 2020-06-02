/*
丑数
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
*/
import java.util.*;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        while(list.size()<index){
            int m2 = list.get(t2)*2;
            int m3 = list.get(t3)*3;
            int m5 = list.get(t5)*5;
            int min = Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min == m2){
                t2++;
            }
            if(min == m3){
                t3++;
            }
            if(min == m5){
                t5++;
            }
        }
        return list.get(list.size()-1);
    }
}

/*
数组中重复的数字
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
*/
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0){
            return false;
        }
        for(int a : numbers){
            if(a < 0 || a >= length){
                return false;
            }
        }
        int temp = 0;
        for(int i=0;i<length;i++){
            while(numbers[i] != i){
                if(numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }
                temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
    
}

/*
二维数组中的查找
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length<=0){
            return false;
        }
  
        int row=0;
        int column=array[0].length-1;
        while(row<=array.length-1 && column>=0){
            if(target==array[row][column]){
                return true;
            }else if(target<array[row][column]){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }
}

/*
替换空格
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/
/*
方法一
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }
}
/*
方法二
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i) == ' ') {
                n += 2;
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }
}

