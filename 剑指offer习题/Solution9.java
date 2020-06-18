//包含min函数的栈;二叉搜索树的后序遍历序列;二叉搜索树的第k个结点；按之字形顺序打印二叉树
/*
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
*/
import java.util.Stack;

public class Solution {
    Stack<Integer> oldStack = new Stack<Integer>();
    Stack<Integer> newStack = new Stack<Integer>();
    public void push(int node) {
        oldStack.push(node);
        if(newStack.isEmpty()){
            newStack.push(node);
        }else {
            if(node <= newStack.peek()){
                newStack.push(node);
            }else{
                newStack.push(newStack.peek());
            }
        }
    }
    
    public void pop() {
        oldStack.pop();
        newStack.pop();
    }
    
    public int top() {
        return oldStack.peek();
    }
    
    public int min() {
        return newStack.peek();
    }
}

/*
二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
假设输入的数组的任意两个数字都互不相同。
*/
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length<=0){
            return false;
        }
        return HelpVerify(sequence,0,sequence.length-1);
    }
    public boolean HelpVerify(int[] sequence,int start,int root){
        if(start > root){
            return true;
        }
        int i;
        for(i=start;i<root;i++){
            if(sequence[i] > sequence[root]){
                break;
            }
        }
        for(int j=i;j<root;j++){
            if(sequence[j] < sequence[root]){
                return false;
            }
        }
        return HelpVerify(sequence,start,i-1) && HelpVerify(sequence,i,root-1);
    }
}

/*
二叉搜索树的第k个结点
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
*/
import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        inSort(pRoot);
        if(k>=1 && list.size()>=k) {
            return list.get(k-1);
        }
        return null;
    }
    public void inSort(TreeNode cur){
        if(cur!=null){
            inSort(cur.left);
            list.add(cur);
            inSort(cur.right);
        }
    }

}
//栈
import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = pRoot;
        while(!s.isEmpty() || cur != null){
            if(cur != null){
                s.push(cur);
                cur = cur.left;
            }else{
                cur = s.pop();
                if(--k == 0){
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }


}
/*
按之字形顺序打印二叉树
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/
import java.util.ArrayList;
import java.util.Stack;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> Alist = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return Alist;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        while(s1.size()>0 || s2.size()>0){
            ArrayList<Integer> list = new ArrayList<>();
            if(s1.size()>0){
                int size1 = s1.size();
                for(int i=0;i<size1;i++){
                    TreeNode cur = s1.pop();
                    list.add(cur.val);
                    if(cur.left!=null){
                        s2.push(cur.left);
                    }
                    if(cur.right!=null){
                        s2.push(cur.right);
                    }
                }
                Alist.add(list);
                continue;
            }
            if(s2.size()>0){
                int size2 = s2.size();
                for(int i=0;i<size2;i++){
                    TreeNode cur2 = s2.pop();
                    list.add(cur2.val);
                    if(cur2.right!=null){
                        s1.push(cur2.right);
                    }
                    if(cur2.left!=null){
                        s1.push(cur2.left);
                    }
                }
                Alist.add(list);
                continue;
            }
        }
        return Alist;
    }

}
