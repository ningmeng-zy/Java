//合并两个排序的链表;链表中环的入口结点;孩子们的游戏(圆圈中最后剩下的数);从尾到头打印链表;复杂链表的复制;二叉搜索树与双向链表
/*
合并两个排序的链表
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
*/
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//遍历两个链表，按大小顺序拼接
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
        }
        return head.next;
    }
}
//递归
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else{
            if(list1.val < list2.val){
                list1.next = Merge(list1.next,list2);
                return list1;
            }else{
                list2.next = Merge(list1,list2.next);
                return list2;
            }
        }
    }
}

/*
链表中环的入口结点
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
*/
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode cur = pHead;
                while(cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }
}

/*
孩子们的游戏(圆圈中最后剩下的数)
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

如果没有小朋友，请返回-1

*/
//使用一个list来模拟，并使用一个索引cur类指向删除的位置，当cur的值为list的size，就让cur到头位置。
import java.util.*;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1){
            return -1;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int cur = -1;
        while(list.size()>1){
            for(int i=0;i<m;i++){
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;
        }
        return list.get(0);
    }
}
//用环形链表模拟圆圈
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=1;i<n;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        int k = 0;
        while(cur.next != cur){
            if(++k == m){
                cur.next = cur.next.next;
                k=0;
            }else{
                cur = cur.next;
            }
        }
        return cur.val;
    }
}
//分析每次被删除数字的规律并直接计算圆圈中最后剩下的数字
public class Solution {
    public int LastRemaining_Solution(int n, int m){
        if(n < 1 || m < 1){
            return -1;
        }
        return n == 1 ? 0 : (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}

/*
从尾到头打印链表
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
*/
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = listNode;
        while(cur!=null){
            list.add(0,cur.val);
            cur = cur.next;
        }
        return list;
    }
}
//递归
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}

/*
复杂链表的复制
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/
import java.util.*;
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode cur = new RandomListNode(pHead.label);
        RandomListNode oldList = pHead;
        RandomListNode newList = cur;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while(pHead != null){
            map.put(pHead,new RandomListNode(pHead.label));
            pHead = pHead.next;
        }
        while(oldList != null){
            newList.next = map.get(oldList.next);
            newList.random = map.get(oldList.random);
            oldList = oldList.next;
            newList = newList.next;
        }
        return cur;
    }
}

/*
二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/
import java.util.*;
/**
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
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree,list);
        return Convert(list);
    }
    public void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        if(pRootOfTree.left != null){
            Convert(pRootOfTree.left, list);
        }
        list.add(pRootOfTree);
        if(pRootOfTree.right != null){
            Convert(pRootOfTree.right, list);
        }
    }
    public TreeNode Convert(ArrayList<TreeNode> list){
        for(int i=0;i<list.size()-1;i++){
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }
}





