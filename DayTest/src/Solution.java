import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Solution
 * @Description TODO Solution
 * @Author 张洋
 * @Date 2020/4/15 14:16
 * @Version 2018.1.5
 **/


/*
和为S的正数连续序列：
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Solution {
    //方法一：采用两个指针的方法
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > sequenceList = new ArrayList<ArrayList<Integer> >();
        if(sum<=0)
            return sequenceList;

        int small = 1;
        int big = 2;
        int curSum = small+big;
        while(small <= sum/2){
            if(curSum == sum){
                ArrayList<Integer> sequence = new ArrayList<Integer>();
                for(int i=small;i<=big;i++)
                    sequence.add(i);
                sequenceList.add(sequence);
                curSum-=small;
                small++; //这两行位置先后要注意
            }
            if(curSum < sum){
                big++;
                curSum+=big;
            }
            if(curSum > sum){
                curSum-=small;
                small++;
            }
        }
        return sequenceList;
    }

    public static void main(String[] args) {
        int sum = 15;
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(sum);
        System.out.println(arrayLists);
    }
}
/*
平衡二叉树
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */

/*
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
}

 */
/*
求1+2+3+...+n
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
    /*
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n>1) && ((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}

     */
/*
二叉树的下一个结点
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
/*
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }
        if (pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next!=null){
            if (pNode == pNode.next.left){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
 */
/*
表示数值的字符串
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
    /*
public class Solution {
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!((ch >= '0' && ch <= '9') || ch == 'e' || ch == 'E' || ch == '+' || ch == '-' || ch == '.')) {
                return false;
            }
        }
        //正负号,E不能在末尾
        if (s.charAt(len - 1) == '+' || s.charAt(len - 1) == '-' || s.charAt(len - 1) == 'e' || s.charAt(len - 1) == 'E') {
            return false;
        }
        //正负号在中间的位置时，前面的是e，E,后面是数字
        for (int i = 1; i < len - 1; i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (!(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E') || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')) {
                    return false;
                }
            }
        }
        //判断小数点，只能有一个
        if (s.indexOf(".") != s.lastIndexOf(".")) {
            return false;
        }
        //e的后面不能有小数点12E+4.3
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (i == len - 1) {
                    return false;
                }
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    if (s.indexOf(".", i + 2) != -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

     */
/*
二叉树的深度
题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
/*
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return Math.max(leftDepth+1,rightDepth+1);
    }
}
 */
/*
二叉树的镜像
链接：
https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
操作给定的二叉树，将其变换为源二叉树的镜像。
二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */
/*
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution{
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
*/