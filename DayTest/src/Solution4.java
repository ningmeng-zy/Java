import java.util.Arrays;

/**
 * @ClassName Solution4
 * @Description TODO
 * @Author 张洋
 * @Date 2020/6/28 16:02
 * @Version 2020.1
 **/
public class Solution4 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        // 统计出现频率 frequency
        int[] freq = new int[101]; // 索引即数值
        for (int num : nums) freq[num]++;

        // 对频率(而非对原数组nums)从前到后累加
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        // 输出结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0) res[i] = freq[nums[i] - 1];
        }
        return res;
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        for(int i=0; i < index.length; i++) {
            if (i > index[i]) {
                int t = nums[i];
                for(int j = i-1; j >= index[i]; j--) {
                    nums[j+1] = nums[j];
                }
                nums[index[i]] = t;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        int[] ret = createTargetArray(nums,index);
        System.out.println(Arrays.toString(ret));
    }
}
