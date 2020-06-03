/*
剪绳子
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
*/
//方法一：贪心法
public class Solution {
    public int cutRope(int target) {
        int ret = 0;
        for(int i=2;i<=target;i++){
            int n = target/i;
            int c = target%i;
            int max = (int)(Math.pow(n,i-c)*Math.pow(n+1,c));
            if(max > ret){
                ret = max;
            }
        }
        return ret;
    }
}
//方法二：找规律
public class Solution {
    public int cutRope(int target) {
        if(target <= 1){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        //数字长度
        int length = target%3==0?target/3:target/3+1;
        int length2 = 3-target%3;
        int result = 1;
        for(int i=0;i<length;i++){
            result=result*(i<length-length2?3:2);
        }
        return result;
    }
}
//方法三：dp解法
import java.util.*;
public class Solution {
    public int cutRope(int target) {
        if(target <= 1){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=target;i++){
            int ret = 0;
            for(int j=1;j<=i/2;j++){
                ret=Math.max(ret,dp[j]*dp[i-j]);
            }
            dp[i] = ret;
        }
        return dp[target];
    }
}
