/**
 * @ClassName BSTree
 * @Description TODO BSTree
 * @Author 张洋
 * @Date 2020/4/22 16:33
 * @Version 2018.1.5
 **/
public class BSTree {
    public static class BSTNode{
        BSTNode left = null;
        BSTNode right = null;
        int val;
        BSTNode(int val){
            this.val = val;
        }
    }
    private  BSTNode root = null;
    //将key插入到二叉搜索树中，插入成功返回true，否则返回false
    public boolean put(int key){
        //判断是否为空树
        //空树
        if (null == root){
            root = new BSTNode(key);
            return true;
        }
        //非空
        //找待插入元素在二叉搜索树中的插入位置
        BSTNode cur = root;
        BSTNode parent = null;
        while (cur != null){
            parent = cur;
            if (key < cur.val){
                cur = cur.left;
            }else if (key > cur.val){
                cur = cur.right;
            }else {
                return false;
            }
        }
        //找到待插入节点的位置
        //将新节点插入到parent的左侧或者右侧
        cur = new BSTNode(key);
        if (key < parent.val){
            parent.left = cur;
        }else {
            parent.right = cur;
        }
        return true;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(BSTNode root){
        if (null != root){
            inOrder(root.left);
            System.out.println(root.val+" ");
            inOrder(root.right);
        }
    }

    //检查key是否在二叉搜索树中
    public boolean contains(int key){
        BSTNode cur = root;
        while (cur != null){
            if (key == cur.val){
                return true;
            }else if (key < cur.val){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return false;
    }
    //最左侧节点---最大的节点
    public int rightMost(){
        if (null == root){
            //抛空指针异常

        }
        BSTNode cur = root;
        while (cur.right != null){
            cur = cur.right;
        }
        return cur.val;
    }

    //最左侧节点---最小的节点
    public int leftMost(){
        if (null == root){
            //抛空指针异常

        }
        BSTNode cur = root;
        while (cur.left != null){
            cur = cur.left;
        }
        return cur.val;
    }
    //删除
    boolean remove(int key){
        if (root == null){
            return false;
        }
        //非空
        //找到待删除节点在树中的位置
        BSTNode cur = root;
        BSTNode parent = null;
        while (cur != null){
            if (key == cur.val){
                break;
            }else if (key < cur.val){
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        //没有找到待删除节点
        if (cur == null){
            return false;
        }
        //已经找到待删除节点的位置   下一步删除该节点
        //1.cur没有孩子
        //2.cur只有左孩子
        //3.cur只有右孩子
        //4.cur左右孩子均存在
        if (null == cur.left){
            //cur只有右孩子 || cur就是叶子节点
            if (null == parent){
                //cur双亲不存在 === cur为根节点
                root = cur.right;
            }else {
                //双亲存在
                if (cur == parent.left){
                    parent.left = cur.right;
                }else {
                    parent.right = cur.right;
                }
            }
        } else if(null == cur.right) {
            //cur只有左孩子
            if (null == parent){
                root = cur.left;
            }else {
                if (cur == parent.left){
                    parent.left = cur.left;
                }else {
                    parent.right = cur.left;
                }
            }
        }else {
            //cur节点的左右孩子均存在
            //在cur子树中找替代的节点
            //方式一：在其右子树中找最小的节点：即最左侧节点
            //方式二：在其左子树中找最大的节点：即最右侧节点
            BSTNode del = cur.right;
            parent = cur;
            while (null != del.left){
                parent = del;
                del = del.left;
            }
            //替代节点找到
            cur.val = del.val;
            //删除替代节点
            if (del == parent.left){
                parent.left = del.right;
            }else {
                parent.right = del.right;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array = {5,3,4,1,7,8,2,6,0,9};
        BSTree t = new BSTree();
        for (int e:array){
            t.put(e);
        }
        t.inOrder();
        System.out.println();
        System.out.println(t.leftMost());
        System.out.println(t.rightMost());

    }
}
