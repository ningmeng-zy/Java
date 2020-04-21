import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName Main5
 * @Description TODO Main5
 * @Author 张洋
 * @Date 2020/4/20 13:56
 * @Version 2018.1.5
 **/
/*
[编程题]23281-用两个栈实现队列
链接https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Main5{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

/*
链接：https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35
来源：牛客网
有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。
John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。
John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。
现在的问题是，John有多少种不同的选择物品的方式。
 */

public class Main5 {
    static int[] weight;
    static int N;
    static int count=0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            N = input.nextInt();
            weight = new int[N+1];
            for (int i = 1; i <= N; i++) {
                weight[i] = input.nextInt();
            }
            count(40,N);
            System.out.println(count);
        }
    }
    public static void count(int s,int n) {
//如果正好装满
        if(s==0) {
            ++count;
            return ;
        }
//是s<0或n<1则不能完成
        if(s<0||(s>0&&n<1))
            return ;
        count(s-weight[n],n-1);
        count(s,n-1);
    }
}
