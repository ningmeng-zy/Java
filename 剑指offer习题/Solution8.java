//把二叉树打印成多行;
/*
把二叉树打印成多行
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> Alist = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return Alist;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(pRoot);
        while(!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode t = q.poll();
                list.add(t.val);
                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
            }
            Alist.add(list);
        }
        return Alist;
        
    }
}
