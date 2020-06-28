//有多少小于当前数字的数字;按既定顺序创建目标数组; 删除链表中的节点;在既定时间做作业的学生人数;拿硬币
/*
有多少小于当前数字的数字
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ret = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(j!=i && nums[j] < nums[i]){
                    count++;
                }
            }
            ret[i] = count;
        }
        return ret;
    }
}
//双百
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ret = new int[101];
        for(int i:nums){
            ret[i]++;
        }
        for(int i=1;i<ret.length;i++){
            ret[i] = ret[i] + ret[i-1];
        }
        int[] array = new int[nums.length];
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                array[j] = ret[nums[j] - 1];
            }
        }
        return array;
    }
}

/*
按既定顺序创建目标数组
给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
目标数组 target 最初为空。
按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
重复上一步，直到在 nums 和 index 中都没有要读取的元素。
请你返回目标数组。
题目保证数字插入位置总是存在。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/create-target-array-in-the-given-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        for(int i=0;i<index.length;i++){
            if(i > index[i]){
                int t = nums[i];
                for(int j=i-1;j>=index[i];j--){
                    nums[j+1] = nums[j];
                }
                nums[index[i]] = t;
            }
        }
        return nums;
    }
}

/*
 删除链表中的节点
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
现有一个链表 -- head = [4,5,1,9]，它可以表示为:
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/*
在既定时间做作业的学生人数
给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for(int i=0;i<startTime.length;i++){
            if(queryTime >= startTime[i] && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
}

/*
拿硬币
桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
示例 1：
输入：[4,2,1]
输出：4
解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/na-ying-bi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int minCount(int[] coins) {
        int count = 0;
        for(int i=0;i<coins.length;i++){
            if(coins[i] > 0){
                count = count + (coins[i]/2) + (coins[i]%2);
            }
        }
        return count;
    }
}
