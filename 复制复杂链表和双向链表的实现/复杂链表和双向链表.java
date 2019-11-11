//复制复杂链表
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val,cur.next,null);
            Node tmp=cur.next;
            cur.next=node;
            cur=tmp;
        }
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        cur=head;
        Node newHead=cur.next;
        while(cur.next!=null){
            Node tmp=cur.next;
            cur.next=tmp.next;
            cur=tmp;
        }
        return newHead;
    }
}

//双向链表
class ListNode{
    public int data;
    public ListNode prev;  //前驱
    public ListNode next;  //后继
    public ListNode(int data){
        this.data=data;
    }
}
class DoubleList {
    public ListNode head;
    public ListNode last;

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node.prev;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.prev = this.last;
            this.last.next = node;
            this.last = node;
        }
    }

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
	
 //任意位置插入,第一个数据节点为0号下标
	private ListNode searchIndex(int index) {
        if (index<0||index>getLength()||this.head ==null){
            return null;
        }
        ListNode cur=this.head;
        while (index>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data){
       if (index==0){
           addFirst(data);
           return;
       }
       if (index==getLength()){
           addLast(data);
           return;
       }
       ListNode cur=searchIndex(index);
       if (cur==null){
           return;
       }
       ListNode node=new ListNode(data);
       node.next=cur;
       node.prev=cur.prev;
       cur.prev.next=node;
       cur.prev=node;

    }
    public int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    } 
	
	//查找是否包含关键字key是否在单链表中
    public boolean contains(int key){
       ListNode cur =this.head;
       while (cur!=null){
           if (cur.data==key){
               return true;
           }
           cur=cur.next;
       }
       return false;
    }
	
	//删除第一次出现关键字为key的节点
    //返回的值是要删除的节点的值
	    public int remove(int key){
        int oldData = -1;//存储要删除的数字
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                oldData = cur.data;
                //头
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return oldData;
                }else {
                    cur.prev.next = cur.next;
                    //cur.next.prev = cur.prev;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        //尾
                        this.last = cur.prev;
                    }
                    return oldData;
                }
            }
            cur = cur.next;
        }
        return -1;
    }
	//删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                //头
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    //cur.next.prev = cur.prev;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        //尾
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
	 //防止内存泄漏
    public void clear(){
        //this.head = null;
        while (this.head != null) {
            ListNode cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        this.last = null;
    }
public class Test1 {
    public static void main(String[] args) {
        DoubleList doubleList=new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(4);
        doubleList.addFirst(3);
        doubleList.addFirst(2);
        doubleList.addFirst(1);
        doubleList.addLast(6);
        doubleList.addLast(7);
        doubleList.addLast(1);
        doubleList.addLast(9);
        doubleList.addLast(1);
        doubleList.display();
        doubleList.addIndex(2,99);
        doubleList.display();
        boolean folg=doubleList.contains(12);
        System.out.println(folg);
        doubleList.remove(99);
        doubleList.display();
//        int ret=doubleList.remove(99);
//        System.out.println(ret);
        doubleList.removeAllKey(1);
        doubleList.display();
        doubleList.clear();
        System.out.println("hhhhhhhhhh");
    }
}
	