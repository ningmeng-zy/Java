class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}//节点类
class MySignalList{
    public ListNode head;
    public MySignalList(){
        this.head=null;
    }
    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if (this.head==null){
            this.head=node;
        }else {
            node.next=this.head;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        ListNode cur=this.head;
        if (this.head==null){
            this.head=node;
        }else {
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=this.head;
        while (cur!=null){
            if (cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //得到单链表的长度
    public int getLength(){
        int count=0;
        ListNode cur=this.head;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    private ListNode searchIndex(int index){
        ListNode cur=this.head;
        //cur->index-1
        int count=0;
        while (count<index-1){
            count++;
            cur=cur.next;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if (index<0||index>getLength()){
            System.out.println("index不合法");
            return false;
        }
        if (index==0){
            addFirst(data);
            return true;
        }
        //找到index-1的位置
        ListNode cur=searchIndex(index);
        ListNode node=new ListNode(data);
        node.next=cur.next;
        cur.next=node;
        return true;
    }
	private ListNode searchPrev(int key) {
        ListNode prev=this.head;
        while (prev.next!=null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (this.head==null){
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //1、找到key的前驱  如果返回空

        ListNode prev = searchPrev(key);
        if (prev==null){
            return;
        }

        //2、删除节点
        ListNode del=prev.next;
        prev.next=del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev=this.head;
        ListNode cur=this.head.next;
        while (cur!=null) {
            if (prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data==key) {
            this.head = this.head.next;
        }
    }
	//clear防止内存泄漏
    public void clear(){
        //一个一个置为空
        while (this.head!=null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head=cur;
            
        }
    }
    public void display(){
        ListNode cur=this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}

public class Test4 {
    public static void main(String[] args) {
        MySignalList mySignalList=new MySignalList();
        mySignalList.addFirst(5);
        mySignalList.addFirst(4);
        mySignalList.addFirst(6);
        mySignalList.addFirst(2);
        mySignalList.addFirst(1);
        mySignalList.addLast(6);
        mySignalList.addLast(7);
        mySignalList.addLast(8);
        mySignalList.addLast(9);
        mySignalList.addLast(10);
        mySignalList.display();
        System.out.println(mySignalList.contains(5));
        System.out.println(mySignalList.contains(13));
        System.out.println(mySignalList.getLength());
        mySignalList.addIndex(10,11);
        mySignalList.display();
        mySignalList.remove(11);
        mySignalList.display();
        mySignalList.removeAllKey(6);
        mySignalList.display();
    }