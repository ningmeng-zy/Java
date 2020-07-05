/**
 * @ClassName TestPriorityQueue
 * @Description TODO TestPriorityQueue
 * @Author 张洋
 * @Date 2020/3/25 11:25
 * @Version 2018.1.5
 **/
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Comparator;

class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public int compareTo(Card o){
        //牌面值
        return rank - o.rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Card)){
            return false;
        }
        Card card = (Card) o;
        return rank == card.rank
                && suit.equals(card.suit);
    }

}
public class TestPriorityQueue {
    public static void TestPriorityQueue1() {
        //1.构造一个空的优先级队列   注意：空的优先级队列，但是底层已经有了11个默认空间;
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        //2.按照指定容量来进行构造
        PriorityQueue<Integer> p2 = new PriorityQueue<>(20);
        //3.可以用一个集合来直接构造优先级队列，将来就会将集合中的元素放到优先级队列中
        List<Integer> L = new ArrayList<>();
        L.add(4);
        L.add(0);
        L.add(3);
        L.add(2);
        L.add(1);
        System.out.println(L);
        PriorityQueue<Integer> p3 = new PriorityQueue<>(L);
        System.out.println(p3.size());

    }
    public static void TestPriorityQueue2(){
        PriorityQueue<Integer> p =new PriorityQueue<>();
        p.offer(4);
        p.offer(1);
        p.offer(3);
        p.offer(0);
        p.offer(5);
        p.offer(2);
        System.out.println(p);
        //peek();取优先级队列中第一个（最小的）元素
        //poll();删除优先级队列中第一个元素（最小的）元素
        //       剩余元素会自动进行调整---->将剩余元素中最小的元素调整到首元素位置
        System.out.println(p.peek());
        p.poll();
        System.out.println(p.peek());
        p.poll();
        System.out.println(p.peek());
        System.out.println(p.size());
        p.clear();
        if (p.isEmpty()){
            System.out.println("优先级队列已经为空");
        }
        else{
            System.out.println("优先级队列不为空");
        }
    }
    public static void TestPriorityQueue(){
        PriorityQueue<Card> q = new PriorityQueue<Card>();
        q.offer(new Card(5,"♠"));
        q.offer(new Card(6,"♠"));
        q.offer(new Card(4,"♠"));
    }
    public static void TestCompare1(){
        int a = 10;
        int b = 20;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);
        char c1 = 'A';
        char c2 = 'B';
        System.out.println(c1 > c2);
        System.out.println(c1 < c2);
        System.out.println(c1 == c2);
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 == b2);
        System.out.println(b1 != b2);
    }
    public static void TestCompare2(){
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = c1;
        Card c4 = new Card(1, "♠");
        //System.out.println(c1 > c2); // 编译报错
        System.out.println(c1 == c2); // 编译成功 ----> 打印false，因为c1和c2指向的是不同对象
        //System.out.println(c1 < c2); // 编译报错
        System.out.println(c1 == c3); // 编译成功 ----> 打印true，因为c1和c3指向的是同一个对象
        System.out.println(c1 == c4);
        if (c1.equals(c4)){
            System.out.println("c1 == c4");
        }else {
            System.out.println("c1 != c4");
        }
        System.out.println(c1.compareTo(c2));
    }
    public static void TestCompare3(){
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = c1;
        Card c4 = new Card(1, "♠");
        //如果要先比较，先要给一个比较器的对象
        CardComp comp = new CardComp();
        if (comp.compare(c1,c2) > 0){
            System.out.println("c1>c2");
        }else if (comp.compare(c1,c2) == 0){
            System.out.println("c1==c2");
        }else {
            System.out.println("c1<c2");
        }

    }
    //基于比较器的比较
    static class CardComp implements Comparator<Card>{

        @Override
        public int compare(Card o1, Card o2) {
            if (o1 == o2){
                return 0;
            }
            if (null == o1){
                return -1;
            }
            if (null == o2){
                return 1;
            }
            return o2.rank-o1.rank;
        }
    }
    public static void TestPriorityQueue4(){
        Card c1 = new Card(5, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = new Card(1,"♠");
        Card c4 = new Card(3, "♠");
        PriorityQueue<Card> p1 = new PriorityQueue<>(4);
        p1.offer(c1);
        p1.offer(c2);
        p1.offer(c2);
        p1.offer(c4);
        PriorityQueue<Card> p2 = new PriorityQueue<>(4);
        p2.offer(c1);
        p2.offer(c2);
        p2.offer(c2);
        p2.offer(c4);

    }
    public static void main(String[] args) {
        //TestPriorityQueue();
        //TestCompare1();
        //TestCompare2();
        //TestCompare3();
        TestPriorityQueue4();
    }
}
