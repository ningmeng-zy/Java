 //一维数组的动态和;数组异或操作;拥有最多糖果的孩子；重新排列数组
 /*
 一维数组的动态和
 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
请返回 nums 的动态和。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 */
class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] array = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            array[i] = sum;
        }
        return array;
    }
}

/*
数组异或操作
给你两个整数，n 和 start 。
数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
请返回 nums 中所有元素按位异或（XOR）后得到的结果。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
*/
class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int ret = 0;
        for(int i=0;i<n;i++){
            nums[i] = start + 2*i;
            ret ^= nums[i]; 
        }
        return ret;
    }
}

/*
拥有最多糖果的孩子
给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有最多的糖果数目。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies

*/
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int num = 0;
        for(int i=0;i<candies.length;i++){
            num = Math.max(num, candies[i]);
        }
        List<Boolean> b = new ArrayList<Boolean>();
        for(int i=0;i<candies.length;i++){
            b.add(candies[i] + extraCandies >= num);
        }
        return b;
    }
}

/*
重新排列数组
给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shuffle-the-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] array = new int[nums.length];
        int ret = 0;
        for(int i=0;i<n;i++){
            array[ret++] = nums[i];
            array[ret++] = nums[n+i];
        }
        return array;
    }
}