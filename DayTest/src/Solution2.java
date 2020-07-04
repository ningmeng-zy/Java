import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * @ClassName Solution2
 * @Description TODO
 * @Author 张洋
 * @Date 2020/5/14 16:18
 * @Version 2020.1
 **/
/*
青蛙跳台阶
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution2 {
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
/*
连续子数组最大和：
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
/*
public class Solution2 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0){
            return 0;
        }
        int sum = array[0];
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if(sum < 0){
                sum = array[i];
            }else{
                sum += array[i];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}

 */
/*

LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
想测测自己的手气,看看能不能抽到顺子,
如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
为了方便起见,你可以认为大小王是0。
 */
/*
public class Solution2 {
    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length <= 0){
            return false;
        }
        Arrays.sort(numbers);
        int a = 0;
        int d = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                a++;
            }
        }
        int b = a;
        int c = a+1;
        while(c < numbers.length){
            if(numbers[b] == numbers[c]){
                return false;
            }
            d += numbers[c++] - numbers[b++] - 1;
        }
        if(a >= d){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,3,5,0};
        boolean ret = isContinuous(arr);
        System.out.println(ret);
    }
}

 */