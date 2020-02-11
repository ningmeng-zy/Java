import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO Solution
 * @Author 张洋
 * @Date 2020/2/1 13:57
 * @Version 2018.1.5
 **/

/*//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。
class Solution {
    public static int[] plusOne(int[] digits) {
        int len=digits.length;
        for (int i=len-1;i>=0;i--){
            digits[i]++;
            digits[i]%=10;
            if (digits[i]!=0){
                return digits;
            }
        }
        digits=new int[len+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        int[] arrays={9,9,9,9};
        int[] b=plusOne(arrays);
        System.out.println(Arrays.toString(b));
    }
}

//给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
class Solution {
    public static int pivotIndex(int[] nums) {
        int sum=0;
        int left=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for (int j=0;j<nums.length;j++){
            if (left*2==sum-nums[j]){
                return j;
            }
            left+=nums[j];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays={1,7,3,6,5,6};
        int ret=pivotIndex(arrays);
        System.out.println(ret);
    }
}


//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
class Solution {
    public static int[] sortArrayByParity(int[] A) {
        int[] array=new int[A.length];
        int j=0;
        for (int i=0;i<A.length;++i){
            if (A[i]%2==0){
                array[j++]=A[i];
            }
        }
        for (int i=0;i<A.length;++i){
            if (A[i]%2==1){
                array[j++]=A[i];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a={1,5,2,7,4,8};
        int[] b=sortArrayByParity(a);
        System.out.println(Arrays.toString(b));
    }
}

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
class Solution {
    public static String reverseOnlyLetters(String S) {
        StringBuilder ans=new StringBuilder();
        int j=S.length()-1;
        for (int i=0;i<S.length();++i){
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))){
                    j--;
            }
                ans.append(S.charAt(j--));
            }else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String A="Test1ng-Leet=code-Q!";
        String B=reverseOnlyLetters(A);
        System.out.println(B);
    }
}

//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
class Solution {
    public static int[] sortedSquares(int[] A) {
        int N=A.length;
        int[] b=new int[N];
        for (int i=0;i<A.length;i++){
            b[i]=A[i]*A[i];
        }
        Arrays.sort(b);
        return b;
    }

    public static void main(String[] args) {
        int[] A={-4,-1,0,3,5,7};
        int[] B=sortedSquares(A);
        System.out.println(Arrays.toString(B));
    }
}

//给定一个整数数组，判断是否存在重复元素。
//如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrays={1,2,3,4,5,6};
        boolean ret=containsDuplicate(arrays);
        System.out.println(ret);
    }
}
//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int len=m+n-1;
        while (i>=0&&j>=0){
            if (nums1[i]>=nums2[j]){
                nums1[len--]=nums1[i--];
            }else {
                nums1[len--]=nums2[j--];
            }
        }
        while (j>=0){
            nums1[len--]=nums2[j--];
        }

    }

    public static void main(String[] args) {
        int[] arrays1={1,2,3,0,0,0};
        int[] arrays2={2,5,6};
        int m=3;
        int n=3;
        merge(arrays1,m,arrays2,n);
    }
}
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度
public class Solution {
    public int lengthOfLastWord(String s) {
        int end=s.length()-1;
        int count=0;
        while (end>=0){
            char c=s.charAt(end);
            if ((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                count++;
            }else {
                if (count!=0){
                    break;
                }
            }
            end--;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String c="abdcf daoj sdffwf";
        int a=solution.lengthOfLastWord(c);
        System.out.println(a);
    }
}
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度
public class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int count = 0;
        while (end >= 0){
            //从后往前遍历
            char c = s.charAt(end);
            if((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z'){
                //只有是字符请况下 count++
                count++;
            } else {
                if(count != 0){
                    //避免最后一位是空格
                    break;
                }
            }
            end--;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution S = new Solution();
        String s = "asdsa fffa";
        int a = S.lengthOfLastWord(s);
        System.out.println(a);
    }
}

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 public class Solution {
  public static boolean isPalindrome(int x) {
        if (x<0||x%10==0&&x!=0){
            return false;
        }
        if (x>=0&&x<=9){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int x=41;
        boolean ret=isPalindrome(x);
        System.out.println(ret);
    }
}

//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] arrays=magazine.toCharArray();
        if (ransomNote.length()>magazine.length()){
            return false;
        }
        for (int i=0;i<ransomNote.length();i++){
            int j=judge(arrays,ransomNote.charAt(i));
            if (j!=-1){
                arrays[j]='0';
            }else {
                return false;
            }
        }
        return true;
    }
    public int judge(char[] arrays,char a){
        for (int i=0;i<arrays.length;i++){
            if (arrays[i]==a){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String ransomNote="aab";
        String magazine="baba";
        boolean a=solution.canConstruct(ransomNote,magazine);
        System.out.println(a);
    }
}

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arrays={1,3,5,6};
        int j=5;
        int ret=searchInsert(arrays,j);
        System.out.println(ret);
    }

//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
public class Solution {
    public static int removeElement(int[] nums, int val) {
        int ret=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){

            }else {
                nums[ret]=nums[i];
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arrays={3,3,2,3};
        int val=3;
        int j=removeElement(arrays,val);
        System.out.println(j);
    }
}

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class Solution {
    public static int[] rotate(int[] nums, int k) {
        while(k>0){
            int tmp=nums[nums.length-1];
            for (int i=nums.length-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=tmp;
            k--;
        }
        return nums;
    }
    public static void main(String[] args){
        int[] arrays={1,2,3,4,5,6,7};
        int k=3;
        int[] arrays2 =rotate(arrays,k);
        System.out.println(Arrays.toString(arrays2));
    }
}
//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
public class Solution {
    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        char[] arrys = new char[str.length()];
        for (int i = 0; i < arrys.length; i++) {
            if (str.charAt(i) > 65 && str.charAt(i) < 90) {
                char newChar = (char) (str.charAt(i) + 32);
                arrys[i] = newChar;
            } else {
                arrys[i] = (char) str.charAt(i);
            }
        }
        return new String(arrys);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入字符串");
        String str=scanner.nextLine();
        String str2=toLowerCase(str);
        System.out.println(str2);
//        String str = "LOYEQSL";
//        System.out.println(toLowerCase(str));
    }
}*/
