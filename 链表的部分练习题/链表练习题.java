 //反转一个单链表。
 public ListNode reverseList(){
        ListNode prev=null;
        ListNode newHead=null;
        ListNode cur=this.head;
        while (cur!=null){
            ListNode curNext=cur.next;
            if (curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }

//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//如果有两个中间结点，则返回第二个中间结点。
    //定义快慢指针 fast slow
    public ListNode middleNode(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
	
//// 输入一个链表，输出该链表中倒数第k个结点。
	public ListNode findKthToTail(int k){
        if (k<=0||head==null){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while (k-1>0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("没有这个节点");
                return null;
            }
        }
            while (fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }

        return slow;
	}
	
//编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。
	public ListNode partition(int x) {
        ListNode cur = this.head;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (cur != null) {
            ListNode curNext=cur.next;
            cur.next=null;
            //cur.data < x
            if(cur.data < x) {
                //第一次插入
                if(beforeStart==null) {
                    beforeStart=cur;
                    beforeEnd=cur;
                }else {
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }
            }else {
                //第一次插入
                if(afterStart == null) {
                    afterStart=cur;
                    afterEnd=cur;
                }else {
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
            //cur=cur.next;
            cur=curNext;
        }
        /*
        if (beforeStart==null){
        return afterStart;
        }
         */

        if (beforeStart==null){
            return afterStart;
        }
        beforeEnd.next=afterStart;
        return beforeStart;
    }
	
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针.
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                //1、循环
                //2、退出循环 cur要多走一步
                while (cur.next != null && cur.data == cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }

// 链表的回文结构。
    public boolean chkPalindrome() {
        ListNode fast = this.head;
        ListNode slow = this.head;
		if (this.head==null){
            return false;
        }
        if (this.head.next==null){
            return true;
        }
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
        while (slow!=this.head){
            if (slow.data!=head.data){
                return false;
            }
            if (this.head.next==slow){
                return true;
            }
            this.head=this.head.next;
            slow=slow.next;
        }
        return true;
    }	
	
//给定一个链表，判断链表中是否有环。  定义两个引用，一个走一步，一个走两步
    public boolean hasCycle(){
        ListNode fast = this.head;
        ListNode slow = this.head;

        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }
//自己建一个环  用idea测；
public void creatLoop(){
        ListNode cur=this.head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }
	
// 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public ListNode detectCycle(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast) {
                break;
            }
        }
        if (fast==null||fast.next==null) {
            return null;
        }
        slow=this.head;
        while (slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
	
//测试以上练习题
 public static void main(String[] args) {
        MySignalList mySignalList=new MySignalList();
        mySignalList.addFirst(1);
        mySignalList.addLast(2);
        mySignalList.addLast(3);
        mySignalList.addLast(4);
        mySignalList.addLast(5);
        mySignalList.display();
        mySignalList.creatLoop();
        boolean flg=mySignalList.hasCycle();
        System.out.println(flg);
        ListNode node=mySignalList.detectCycle();
        System.out.println(node.data);
//		  mySignalList.addLast(4);
//        mySignalList.display();
//        ListNode node=mySignalList.partition(5);    //新的头
//        mySignalList.display2(node);
//        ListNode node=mySignalList.deleteDuplication();
//        mySignalList.display2(node);
//        boolean flg=mySignalList.chkPalindrome();
//        System.out.println(flg);
    }

// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return node.next;
    }
	
// 输入两个链表，找出它们的第一个公共结点
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        ListNode pL = headA;
        //永远指向最短的单链表
        ListNode pS = headB;


        //分别求长度
        int lenA = 0;
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        int lenB = 0;
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        //求长度的差值
        int len = lenA - lenB;
        //如果是负数-》pL = headB;  pS = headA
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //只需要让pL走len步就好了
        while (len > 0) {
            pL = pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走
        //一直走 走到next值相同时 就是交点
        while (pL != pS && pL != null && pS != null) {
            pL = pL.next;
            pS = pS.next;
        }
        if (pL == pS && pS != null) {
            return pL;
        }
        //万一没有相交  并且两个单链表长度一样    防止最后一个节点
//        if (pL.next != null && pL.next == pS.next) {
//            return pL.next;
//        }
        return null;
    }
//测试后面两练习的代码
public static void main(String[] args) {
        MySignalList mySignalList=new MySignalList();
        mySignalList.addLast(6);
        mySignalList.addLast(7);
        mySignalList.addLast(81);
        mySignalList.addLast(99);
        MySignalList mySignalList2=new MySignalList();
        mySignalList2.addLast(11);
        mySignalList2.addLast(23);
        mySignalList2.addLast(33);
        mySignalList2.addLast(42);
        mySignalList2.addLast(55);
        mySignalList2.addLast(67);
        mySignalList.addLast(102);
        ListNode node=mergeTwoLists(mySignalList.head,mySignalList2.head);
        mySignalList.display2(node);
//        creatCut(mySignalList.head,mySignalList2.head);
//        ListNode node=getIntersectionNode(mySignalList.head,mySignalList2.head);
//        System.out.println(node.data);
    }
	