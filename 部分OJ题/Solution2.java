//猜数字;将数字变成0的操作次数; 整数的各位积和之差; IP 地址无效化; 解压缩编码列表
/*
猜数字
小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for(int i=0;i<guess.length;i++){
            if(guess[i] == answer[i]){
                count++;
            }
        }
        return count;
    }
}

/*
将数字变成 0 的操作次数
给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
*/
class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num != 0){
            if(num % 2 == 0){
                num /= 2;
                count++;
            }else{
                num -= 1;
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num != 0){
            if((num & 1) == 1){
                num  = num -1;
            }else{
                num = num / 2;
            }
            count++;
        }
        return count;
    }
}

/*
 整数的各位积和之差
 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
*/
class Solution {
    public int subtractProductAndSum(int n) {
        int ret = 1;
        int sum = 0;
        while(n != 0){
            ret *= n % 10;
            sum += n % 10;
            n = n/10;
        }
        return ret - sum;
    }
}

/*
 IP 地址无效化
 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
*/
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i) == '.'){
                str.append("[.]");
            }else{
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }
}

/*
统计位数为偶数的数字
给你一个整数数组 nums，请你返回其中位数为偶数的数字的个数。
*/
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i:nums){
            if(String.valueOf(i).length() % 2 == 0){
                count++;
            }
        }
        return count;
    }
}

/*
 解压缩编码列表
给你一个以行程长度编码压缩的整数列表 nums 。
考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，
你需要从左到右连接所有子列表以生成解压后的列表。
请你返回解压后的列表。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int[] decompressRLElist(int[] nums) {
        if(nums.length <= 1){
            return new int[]{nums[0]};
        }
        int len = 0;
        for(int i=0;i<nums.length;i+=2){
            len += nums[i];
        }
        int[] res = new int[len];
        for(int i=0,j=0;i<nums.length;i+=2){
            for(int k=0;k<nums[i];k++){
                res[j++] = nums[i+1];
            }
        }
        return res;
    }
}
