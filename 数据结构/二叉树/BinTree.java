/**
 * @ClassName BinTree
 * @Description TODO BinTree
 * @Author 张洋
 * @Date 2020/2/29 14:21
 * @Version 2018.1.5
 **/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

//采用孩子表示法
class BTNode{
    BTNode left=null;
    BTNode right=null;
    int val;

    public BTNode(int val) {
        this.val = val;
    }
}
public class BinTree {
    private BTNode root=null;
    public void preOrder(){
        System.out.print("前序遍历:");
        preOrder(root);
        System.out.println();
    }
    public void inOrder(){
        System.out.print("中序遍历:");
        inOrder(root);
        System.out.println();
    }
    public void postOrder(){
        System.out.print("后续遍历:");
        postOrder(root);
        System.out.println();
    }
    public int getNodeCount(){
        return getNodeCount(root);
    }
    public int getLeafNodeCount(){
        return getLeafNodeCount(root);
    }
    public int getHeight(){
        return getHeight(root);
    }
    public boolean isSameTree(){
        return isSameTree(root,root);
    }
    public BTNode find(int val){
        return find(root,val);
    }
    //层序遍历
    public void LevelOrder(){
        if (null==root){
            return;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BTNode cur=q.poll();
            System.out.println(cur.val);
            if (null!=cur.left){
                q.offer(cur.left);
            }
            if (null!=cur.right){
                q.offer(cur.right);
            }
        }
        System.out.println();
    }
    public int getKLevelNodeCount(int k){
        return getKLevelNodeCount(root,k);
    }
    //非递归前序遍历
    public void preOrderNor(){
        if(null==root){
            return;
        }
        Stack<BTNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()){
            BTNode cur = s.peek();
            System.out.print(cur.val+" ");
            s.pop();
            if (null!=cur.right){
                s.push(cur.right);
            }
            if (null!=cur.left){
                s.push(cur.left);
            }
        }
        System.out.println();
    }
    public void preOrderNor2(){
        if (null==root){
            return;
        }
        Stack<BTNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()){
            BTNode cur = s.peek();
            s.pop();
            while (null!=cur){
                System.out.print(cur.val+" ");
                if (null!=cur.right){
                    s.push(cur.right);
                }
                cur=cur.left;
            }
        }
    }
    //前序遍历
    private void preOrder(BTNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //中序遍历
    private void inOrder(BTNode root){
        if (null!=root){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }
    //后序遍历
    private void postOrder(BTNode root){
        if (null!=root){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }
    private int getNodeCount(BTNode root){
        if (null==root){
            return 0;
        }else {
            return 1+getNodeCount(root.left)+getNodeCount(root.right);
        }
    }
    private int getLeafNodeCount(BTNode root){
        if (null==root){
            return 0;
        }
        if (null==root.left&&null==root.right){
            return 1;
        }
        return getLeafNodeCount(root.left)+getLeafNodeCount(root.right);
    }
    private int getKLevelNodeCount(BTNode root,int k){
        if(null==root||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }
    //求二叉树高度
    private int getHeight(BTNode root){
        if (null == root){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
    }
    //获取val在树中对应的节点，找到返回节点，否则返回null
    private BTNode find(BTNode root,int val){
        if (null==root){
            return null;
        }
        if (root.val==val){
            return root;
        }
        BTNode retNode=null;
        if (null!=(retNode=find(root.left,val))||null!=(retNode=find(root.right,val))){
            return retNode;
        }
        return null;
    }
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    private boolean isSameTree(BTNode p, BTNode q) {
        if (null==p&&null==q){
            return true;
        }
        if (null==p||null==q){
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //完全二叉树
    public boolean isCompleteTree(){
        if (null==root){
            return true;
        }
        //按照层序遍历的方式，找第一个不饱和节点
        Queue<BTNode> q=new LinkedList<>();
        q.offer(root);
        boolean isLeafOrLeft=false;
        while (!q.isEmpty()){
            BTNode cur = q.poll();
            if (isLeafOrLeft){
                if (null!=cur.left||null!=cur.right){
                    return false;
                }
            }
            else {
                if (null!=cur.left&&null!=cur.right){
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                else if (null!=cur.left){
                    q.offer(cur.left);
                    isLeafOrLeft=true;
                }else if (null!=cur.right){
                    return false;
                }else {
                    //cur是叶子节点
                    isLeafOrLeft=true;
                }
            }
        }
        return true;
    }
    public BinTree(){
        BTNode n1=new BTNode(1);
        BTNode n2=new BTNode(2);
        BTNode n3=new BTNode(3);
        BTNode n4=new BTNode(4);
        BTNode n5=new BTNode(5);
        BTNode n6=new BTNode(6);
        root=n1;
        n1.left=n2;
        n2.left=n3;
        n1.right=n4;
        n4.left=n5;
        n4.right=n6;
    }

    public static void main(String[] args) {
        BinTree bt=new BinTree();
//        bt.preOrder();
//        bt.inOrder();
       bt.postOrder();
//        System.out.println(bt.getNodeCount());
//        System.out.println(bt.getLeafNodeCount());
//        System.out.println(bt.getKLevelNodeCount(3));
//        bt.LevelOrder();
//       bt.preOrderNor();
        bt.preOrderNor2();
    }
}
