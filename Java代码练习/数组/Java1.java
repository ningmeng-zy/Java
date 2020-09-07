/*
一维数组的动态和
https://leetcode-cn.com/problems/running-sum-of-1d-array/
给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
请返回 nums 的动态和。
*/

class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int len = nums.length;
        int[] array = new int[len];
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            array[i] = sum;
        }
        return array;
    }
}


/*
好数对的数目
https://leetcode-cn.com/problems/number-of-good-pairs/
给你一个整数数组 nums 。
如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
返回好数对的数目。
*/
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}

/*
拥有最多糖果的孩子
https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
*/
class Solution {
    public  List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<Boolean>();
        int len = candies.length;
        boolean[] array = new boolean[len];
        int max = 0;
        int index = 0;
        for(int i=0;i<len;i++){
            if(candies[i] > max){
                max = candies[i];
                index = i;
            }
        }
        for(int j=0;j<len;j++){
            if(candies[j]+extraCandies >= max ){
                array[j] = true;
            }else{
                array[j] = false;
            }
            list.add(array[j]);
        }
        return list;
    }
}

/*
重新排列数组
https://leetcode-cn.com/problems/shuffle-the-array/
给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
*/
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] array = new int[n*2];
        for(int i=0;i<n;i++){
            array[i*2] = nums[i];
            array[i*2+1] = nums[i+n];
        }
        return array;
    }
}

/*
矩阵对角线元素的和
https://leetcode-cn.com/problems/matrix-diagonal-sum/
给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
*/
class Solution {
    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += mat[i][i] + mat[i][len-1-i];
        }
        if(len % 2 == 1){
            sum -= mat[len/2][len/2];
        }
        return sum;
    }
}
