/*
斐波那契数列
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
n<=39
*/
//递归
public class Solution {
    public int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}

//动态规划  空间复杂度为O(n)
public class Solution {
    public int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for(int i=2;i<=n;i++){
            array[i] = array[i-1]+array[i-2];
        }
        return array[n];
    }
}

//空间复杂度将为O(1)
public class Solution {
    public int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2)
        {
            return 1;
        }
        int fn = 0;
        int f1 = 1;
        int f2 = 1;
        for(int i=3 ;i<=n ; ++i){
            fn = f1 + f2;
            f2 = f1;
            f1 = fn;
        }
        return fn;
    }
}

/*
变态跳台阶
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/
//动态规划
public class Solution {
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}

//排列   时间复杂度:O(N)
public class Solution {
    public int JumpFloorII(int target) {
        int ret = 1;
        for(int i = 2;i<=target;++i){
            ret *= 2;
        }
        return ret;
    }
}

//降低时间复杂度   时间复杂度:O(1)
public class Solution {
    public int JumpFloorII(int target) {
        return 1<<(target-1);
    }
}

/*
连续子数组的最大和
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
*/
/*
子状态：长度为1，2，3，...,n的子数组和的最大值
F(i):长度为i的子数组和的最大值，这种定义不能形成递推关系，舍弃
F(i):以array[i]为末尾元素的子数组和的最大值
状态递推：
F(i) = max(F(i-1) + array[i]，array[i])
F(i) = （F(i-1) > 0）? F(i-1) + array[i] : array[i]
初始值：F(0) = array[0]
返回结果：
maxsum：所有F(i)中的最大值
maxsum = max(maxsum，F(i))
*/
import java.util.*;
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = array[0];
        for(int i=1;i<array.length;++i){
            sum = Math.max(sum+array[i],array[i]);
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}

/*
word-break
题目描述
给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
例如:
给定s=“leetcode”；
dict=["leet", "code"].
返回true，因为"leetcode"可以被分割成"leet code".

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s ="leetcode",
dict =["leet", "code"].

Return true because"leetcode"can be segmented as"leet code".
*/
import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] c = new boolean[s.length()+1];
        c[0] = true;
        for(int i=1;i<=s.length();++i){
            for(int j=i-1;j>=0;--j){
                if(c[j]&&dict.contains(s.substring(j,i))){
                    c[i] = true;
                    break;
                }
            }
        }
        return c[s.length()];
    }
}























