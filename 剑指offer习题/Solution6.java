/*
栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
*/
import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null){
            return false;
        }
        if(pushA.length != popA.length && pushA.length != 0){
            return false;
        }
        Stack<Integer> s = new Stack<>();
        int popAIndex = 0;
        for(int i=0;i<pushA.length;i++){
            s.push(pushA[i]);
            while(!s.empty() && s.peek() == popA[popAIndex]){
                s.pop();
                popAIndex++;
            }
        }
        return s.empty();
    }
}

/*
重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }
}

/*
数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int flag = array[0];
        int count = 1;
        for(int i=1;i<array.length;i++){
            if(array[i] == flag){
                count++;
            }else{
                count--;
                if(count == 0){
                    flag = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;
        for(int j=0;j<array.length;j++){
            if(array[j] == flag){
                num++;
            }
        }
        return num > (array.length/2) ? flag : 0;
    }
}
/*
机器人的运动范围
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
*/
import java.util.*;
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] flag = new int[rows][cols];
        func(0,0,threshold,rows,cols,flag);
        return count;
    }
    public int count = 0;
    public void func(int i,int j,int threshold,int rows,int cols,int[][] flag){
        if(i<0||i>=rows||j<0||j>=cols){
            return;
        }
        if(flag[i][j] == 1){
            return;
        }
        if(!isFunc(i,j,threshold)){
            flag[i][j] = 1;
            return;
        }
        flag[i][j] = 1;
        count++;
        func(i,j+1,threshold,rows,cols,flag);
        func(i,j-1,threshold,rows,cols,flag);
        func(i+1,j,threshold,rows,cols,flag);
        func(i-1,j,threshold,rows,cols,flag);
    }
    public boolean isFunc(int rows,int cols,int threshold){
        int sum = 0;
        while(rows > 0){
            sum += rows % 10;
            rows = rows / 10;
        }
        while(cols > 0){
            sum += cols % 10;
            cols = cols / 10;
        }
        if(sum > threshold){
            return false;
        }else{
            return true;
        }
    }
}