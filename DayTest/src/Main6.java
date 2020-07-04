import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * @ClassName Main6
 * @Description TODO Main6
 * @Author 张洋
 * @Date 2020/4/22 09:36
 * @Version 2018.1.5
 **/

/*
[编程题]69387-n个数里出现次数大于等于n/2的数
链接:https://www.nowcoder.com/questionTerminal/eac8c671a0c345b38aa0c07aba40097b
输入n个整数，输出出现次数大于等于数组长度一半的数。
 */
public class Main6 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //while (in.hasNext()) {
            //String str = in.nextLine();
        String str = "3 9 3 2 5 6 7 3 2 3 3 3";
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                } else if (count > 0) {
                    count--;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        //}
    }
}
/*
[编程题]46579-计算糖果
链接：https://www.nowcoder.com/questionTerminal/02d8d42b197646a5bbd0a98785bb3a34
来源：牛客网
A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 */

/*
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            int n4 = sc.nextInt();
            if( ((n1+n3)%2!=0) || ((n2+n4)%2!=0) || ((n4-n2)%2!=0) || (n3-n1)%2!=0){
                System.out.println("No");
                return;
            }
            int A = (n1+n3)/2;
            int B = (n2+n4)/2;
            int C = (n4-n2)/2;
            if((A-B)!=n1 || (B-C)!=n2 || (A+B)!=n3 || (B+C)!=n4){
                System.out.println("No");
                return;
            }
            System.out.println(A+" "+B+" "+C);
        }
    }
}
 */
