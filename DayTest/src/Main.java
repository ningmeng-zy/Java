import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.*;

/**
 * @ClassName Main
 * @Description TODO Main
 * @Author 张洋
 * @Date 2020/4/1 16:01
 * @Version 2018.1.5
 **/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
            //String str = scanner.nextLine();
        String str = "A10;S20;W10;D30;X;A1A;B10A11; ;A10;\n";
            //以 “；”为界分割字符串
            String[] strings = str.split(";");
            int x = 0, y = 0;
            for (String string : strings) {
                if (string.length() > 0) {
                    char char1 = string.charAt(0);
                    //判断输入的第一个字母是否为 W S  A D
                    if (char1 != 'W' && char1 != 'S' && char1 != 'A' && char1 != 'D') {
                        continue;
                    }
                    String str2 = string.substring(1, string.length());
                    char[] chars2 = str2.toCharArray();

                    boolean judge = true;
                    //判断除首字母外的是否为数字
                    for (char aChars2 : chars2) {
                        if (aChars2 < 48 || aChars2 > 57) {
                            judge = false;
                        }
                    }
                    if (!judge) {
                        continue;
                    }
                    //判断命令
                    switch (char1) {
                        case 'W':
                            y += Integer.parseInt(str2);
                            break;
                        case 'S':
                            y -= Integer.parseInt(str2);
                            break;
                        case 'A':
                            x -= Integer.parseInt(str2);
                            break;
                        case 'D':
                            x += Integer.parseInt(str2);
                            break;
                        default:
                            break;
                    }
                }
            }
            System.out.println(x + "," + y);
        //}
    }
}
/*
public class Main {
    //synchronized修饰⾮静态⽅法
    public synchronized void function() throws InterruptedException {
        for (int i = 0; i <3; i++) {
            Thread.sleep(1000);
            System.out.println("function running...");
        }
    }
    //synchronized修饰静态⽅法
    public static synchronized void staticFunction()
            throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running...");
        }
    }
    public static void main(String[] args) {
        final Main demo = new Main();
        // 创建线程执⾏静态⽅法
        Thread t1 = new Thread(() -> {
            try {
                staticFunction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 创建线程执⾏实例⽅法
        Thread t2 = new Thread(() -> {
            try {
                demo.function();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 启动
        t1.start();
        t2.start();
    }
}

public class Main{
    public static boolean isHuiwen(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<=j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();

            int j = str.length();
            int count = 0;
            for (int i = 0;i<str.length();i++){
                if (isHuiwen(str.substring(0,i)+str.substring(i+1,j))){
                    count++;
                }
            }
            if (count!=0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}

import java.util.*;
import java.util.Scanner;
public class Main {
    public static int[] arrayPrint(int[][] arr, int n) {
        int[] ret = new int[n*n];
        List<Integer> list = new ArrayList<>();
        int x = 0;
        for (int y=n-1; y>=0; y--){
            int x1 = x;
            int y1 = y;
            if (x1!=0 && y1!=0){
                list.add(arr[x1][y1]);
            }
            if (x1!=0){
                y1--;
            }
            while (x1<n && (y1>=0 && y1<n)){
                list.add(arr[x1][y1]);
                x1++;
                y1++;
            }
        }
        int y=0;
        for(int i=1;i<n;i++){
            int x2=i;
            int y2=y;
            list.add(arr[x2][y2]);
            x2++;
            y2++;
            while (x2<n&&(y2>=0&&y2<n)){
                list.add(arr[x2][y2]);
                x2++;
                y2++;
            }
        }
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n = 4;
        int[] s = arrayPrint(array,n);
        System.out.println(s);
    }
}

public class Main {
    public int getLCA(int a, int b) {
        while(a!=b){
            if (a>b){
                a = a/2;
            }else {
                b = b/2;
            }
        }
        return a;
    }
}

public class Main {
    public static String path = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = in.nextInt();
            }
        }
        Helper(grid,0,0,visited,"",p);
        System.out.println(path);
    }
    public static void Helper(int[][] grid,int i,int j, boolean[][] visited,String res,int p) {
        if(i == 0 && j == grid[0].length-1 && grid[i][j] == 1){
            if(p >=0 ){
                path = res + "["+i+","+j+"]";
            }else{
                path =  "Can not escape!";
            }
            return;
        }
        if(i >=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1 && !visited[i][j]){
            visited[i][j] = true;
            res += "["+i+","+j+"],";
            Helper(grid,i,j+1,visited,res,p-1);//向右
            Helper(grid,i+1,j,visited,res,p);//向下
            Helper(grid,i,j-1,visited,res,p-1);//向左
            Helper(grid,i-1,j,visited,res,p-3);//向上
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            int I = in.nextInt();
            int L = in.nextInt();
            if(I == 1){//添加
                int j=0;
                for(;j<list.size(); j++){
                    if(list.get(j) >= L){
                        list.add(j,L);
                        break;
                    }
                }
                if(list.size() == j){
                    list.add(L);
                }
                sum += L;
            }else{
                list.remove(list.indexOf(L));
                sum -= L;
            }
            int max = list.get(list.size()-1);
            if(sum - max > max){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}

import java.util.*;
public class Main {
    public int calculateMax(int[] prices) {
        int sum = 0;
        for (int i=1;i<prices.length;i++){
            int temp = getMax(prices,0,i)+getMax(prices,i,prices.length-1);
            if (temp > sum){
                sum = temp;
            }
        }
        return sum;
    }
    public static int getMax(int[] prices,int start,int end){
        int max = 0;
        int min = prices[start];
        for (int i=start+1;i<=end;i++){
            if (prices[i] - min > max){
                max = prices[i] - min;
            }
            if (prices[i] - min < max){
                min = prices[i];
            }
        }
        return max;
    }
}

import java.util.*;
public class Main{
    public static int getmax(int [] prices ,int start ,int end )
    {
        int max = 0;
        int min = prices[start];
        for(int i=start+1;i<=end;i++)
        {
            if (prices[i]-min>max)
                max = prices[i]-min;
            if (prices[i]<min)
                min = prices[i];
        }
        return max ;
    }
    public static int calculateMax(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = getmax(prices, 0, i) + getmax(prices, i, prices.length - 1);
            if (temp > sum)
                sum = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,5,1,7,8};
        int ret = calculateMax(arr);
        System.out.println(ret);
    }
}


public class Main {
    public static void main(String[] args) {
        long richPerson = 0;
        long stranger = 0;
        for (int i=1;i<=30;i++){
            richPerson += 10;
            stranger = stranger+ (long) Math.pow(2,i-1);
        }
        System.out.println(richPerson+"万元 "+stranger+"分");
    }
}

public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String originalString = sc.next();
        //String typedOutString = sc.next();
        String originalString = "7_This_is_a_test";
        String typedOutString = "_hs_s_a_es";
        ArrayList<Character> wornOutkeys = new ArrayList<>();
        int size = originalString.length();
        int iOriginal = 0;
        int iTypeOut = 0;
        while(iOriginal < size){
            boolean wornOut = false;  //假设没有损坏
            char originalCh = originalString.charAt(iOriginal);
            char originalUpper = Character.toUpperCase(originalCh);//全部大写
            if(iTypeOut >= typedOutString.length()){
                //输出的字符已经结束
                wornOut = true;
            }else {
                char typeOutCh = typedOutString.charAt(iTypeOut);
                char typeOutUpper = Character.toUpperCase(typeOutCh);
                if(originalCh != typeOutUpper){
                    //应该看到输出的字符没有输出
                    wornOut = true;
                }
            }
            if(wornOut){
                if(!wornOutkeys.contains(originalUpper)){
                    wornOutkeys.add(originalUpper);
                }
                iOriginal++;
            }else{
                iOriginal++;
                iTypeOut++;
            }
        }
        for(int i = 0;i<wornOutkeys.size();i++){
            System.out.print(wornOutkeys.get(i));
        }
        System.out.println();
    }
}

public class Main{
    public static boolean func(int n){
        if (n == 5 || n == 6){
            return true;
        }
        if (n >= 10){
            if ((n*n)%100 == n){
                return true;
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           int n = sc.nextInt();
           boolean ret = func(n);
           if (ret == true){
               System.out.println("Yes!");
           }else {
               System.out.println("No!");
           }
       }
    }
}

 */
/*
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                b[i] = sc.nextInt();
            }
            System.out.println(func(n,a,b));
        }
    }
    public static int func(int n,int a,int[] b){
        for(int i=0;i<n;i++){
            if(a >= b[i]){
                a += b[i];
            }else{
                a += func2(b[i],a);
            }
        }
        return a;
    }
    public static int func2(int a,int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(a % b == 0){
            return b;
        }else{
            return func2(b,a%b);
        }
    }
}
*/
/*
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=1,b=1,c=1;
        while (sc.hasNext()){
            int N = sc.nextInt();
            while (c<N){
                a = b;
                b = c;
                c = a+b;
            }
            int n1 = N - b;
            int n2 = c - N;
            int ret = n1 > n2 ? n2 : n1;
            System.out.println(ret);

        }
    }
}


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int[] array = new int[N];
            int A1=0,A2=0,A3=0,A4=0,A5=0,flag=1,count=0;
            for (int i=0;i<N;i++){
                array[i] = sc.nextInt();
                if (array[i] % 5 == 0 && array[i] % 2 == 0){
                    A1 = A1 + array[i];
                }
                if (array[i] % 5 == 1){
                    A2 = A2 + flag * array[i];
                    flag = -flag;
                }
                if (array[i] % 5 == 2){
                    A3++;
                }
                if (array[i] % 5 == 3){
                    A4 = A4 + array[i];
                    count++;
                }
                if (array[i] % 5 == 4){
                    if (array[i] > A5){
                        A5 = array[i];
                    }
                }
            }
            if (A1 != 0){
                System.out.print(A1+" ");
            }else {
                System.out.print("N"+" ");
            }
            if (A2 != 0){
                System.out.print(A2+" ");
            }else {
                System.out.print("N"+" ");
            }
            if (A3 != 0){
                System.out.print(A3+" ");
            }else {
                System.out.print("N"+" ");
            }
            if (A4 != 0){
                System.out.print(A4/count+"."+(int)((A4%count*100/count+5)/10)+" ");
            }else {
                System.out.print("N"+" ");
            }
            if (A5 != 0){
                System.out.print(A5);
            }else {
                System.out.print("N");
            }
        }
    }
}




public class Main{
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a==null){
            return b;
        }
        if (b==null){
            return a;
        }
        if (a == null && b == null){
            return null;
        }
        int add = 0;
        ListNode head = new ListNode(-1);
        ListNode resCur = head;
        ListNode curA = a;
        ListNode curB = b;
        while(curA != null || curB != null){
            if(curA != null && curB !=null){
                resCur.next = new ListNode((curA.val+curB.val+add));
                resCur = resCur.next;
                add = (curA.val+curB.val+add)/10;
                curA = curA.next;
                curB = curB.next;
            }else if(curA != null){
                resCur.next = new ListNode((curA.val+add));
                resCur = resCur.next;
                add = (curA.val+add)/10;
                curA = curA.next;
            }else{
                resCur.next = new ListNode((curB.val+add));
                resCur = resCur.next;
                add = (curB.val+add)/10;
                curB = curB.next;
            }
        }
        if(add > 0){
            resCur.next = new ListNode(add);
            resCur = resCur.next;
        }
        return head.next;
    }
}


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            LinkedList<Character> L = new LinkedList<>();
            for (int i=0;i<str1.length();i++){
                char ch = str1.charAt(i);
                L.add(ch);
            }
            int count = 0;
            for (int i=0;i<str2.length();i++){
                char ch2 = str2.charAt(i);
                for (int j=0;j<L.size();j++){
                    if (ch2 == L.get(j)){
                        L.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if (count == str2.length()){
                System.out.println("Yes" + " " + (str1.length()-count));
            }else {
                System.out.println("No" + " " + (str2.length()-count));
            }

        }

    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.nextLine();
            char[] b = a.toCharArray();
            for (int i=0;i<b.length;i++){
                if (b[i] - 'A' >= 0) {
                    b[i] = (char) (b[i] > 'E' ? b[i] - 5 : b[i] + 21);
                }
            }
            System.out.println(new String(b));
        }
    }
}

public class Main{
    public static int getTotalCount(int monthCount){
        if (monthCount == 1 || monthCount == 2){
            return 1;
        }
            return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int count = getTotalCount(month);
        System.out.println(count);
    }
}


 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main{
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null){
            return null;
        }
        if (pHead.next == null){
            return pHead;
        }
        ListNode bigHead = null;
        ListNode bigEnd = null;
        ListNode smallHead = null;
        ListNode smallEnd = null;
        while (pHead != null)
        {
            ListNode next = pHead.next;
            pHead.next = null;
            if (pHead.val < x)
            {
                if (smallHead == null)
                {
                    smallHead = pHead;
                    smallEnd = smallHead;
                }
                else
                {
                    smallEnd.next = pHead;
                    smallEnd = pHead;
                }
            }
            else
            {
                if (bigHead == null)
                {
                    bigHead = pHead;
                    bigEnd = bigHead;
                }
                else
                {
                    bigEnd.next = pHead;
                    bigEnd = pHead;
                }
            }
            pHead = next;
        }

        if (smallHead == null)
        {
            return bigHead;
        }
        smallEnd.next = bigHead;
        return smallHead;
    }
}

public class Main{
    public static int getValue(int[] gifts, int n) {
        int count = 0;
        int max = 0;
        int temp = 0;
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (gifts[i] == gifts[j]){
                    count++;
                }
                if (count > max){
                    max = count;
                    temp = gifts[j];
                }
            }
            if (max > n/2){
                return temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2};
        int n = 5;
        int ret = getValue(array,n);
        System.out.println(ret);
    }
}

public class Main {
    public static String[] name;
    public static int[] score;
    public static void sort(int c){
        for (int i=1;i<name.length;i++){
            for (int j=i;j>0&&compare(j,j-1,c);j--){
                exchange(j,j-1);
            }
        }
    }
    public static boolean compare(int i,int j,int c){
        return c == 0 ? score[i] > score[j] : score[i] < score[j];
    }
    public static void exchange(int i,int j){
        String ntemp = name[j];
        int stemp = score[j];
        name[j] = name[i];
        name[i] = ntemp;
        score[j] = score[i];
        score[i] = stemp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int c = sc.nextInt();
            name = new String[n];
            score = new int[n];
            for (int i=0;i<n;i++){
                name[i] = sc.next();
                score[i] = sc.nextInt();
            }
            sort(c);
            for (int j=0;j<n;j++){
                System.out.println(name[j] + " " + score[j]);
            }
        }
    }
}


public class Main {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] b = new boolean[n];
        for (int i=0;i<n;i++){
            b[i] = s.contains(p[i]);
        }
        return b;
    }

    public static void main(String[] args) {
        String[] p = new String[]{"a","b","c","d"};
        int n = 4;
        String s = "abc";
        boolean[] ret = chkSubStr(p,n,s);
        System.out.println(Arrays.toString(ret));
    }
}

import java.util.*;
public class Main {
    public static int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        return mergeSortRecursion(A, 0, n - 1);
    }
    public static int mergeSortRecursion(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
//逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+左右结合成新的顺序数组时中出现的逆序对的数量；
        return mergeSortRecursion(arr, l, mid) + mergeSortRecursion(arr, mid + 1, r) +
                merge(arr, l, mid, r);
    }
    public static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverseNum = 0;// 新增，用来累加数组逆序对
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
// 当前一个数组元素大于后一个数组元素时，累加逆序对
// s[i] > s[j] 推导出 s[i]...s[mid] > s[j]
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left++] = temp[k];
        }
        return inverseNum;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,0};
        int n = 10;
        int ret = count(array,n);
        System.out.println(ret);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int max = 0;
        int pos = 0;
        for (int i=0;i<=str.length()-n;i++){
            int count=0;
            for (int j=i; j<i+n; j++){
                if (str.charAt(j) == 'C' || str.charAt(j) == 'G'){
                    count++;
                }
                if (count > max){
                    max = count;
                    pos = i;
                }
            }
        }
        System.out.println(str.substring(pos,pos+n));
    }
}

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();
//        String str = "AACTGTGCGACCTGA";
//        int n=5;
        int max=0;
        int maxIndex=0;
        //String res="";
        for(int i=0;i<=str.length()-n;i++){
            //String sub=str.substring(i,i+n);//截取子串
            int count=0;
            for(int j=i;j<i+n;j++){
                if(str.charAt(j)=='C'||str.charAt(j)=='G'){
                    count++;
                }
                if(count>max){
                    max=count;
                    maxIndex=i;
                }
            }
        }
        System.out.println(str.substring(maxIndex,maxIndex+n));
    }
}


public class Main {
    public static void main(String[] args) {
        int rich_money = 0;
        double money = 0.1;
        double stranger_money = 0;
        for (int i=1;i<=30;i++){
            rich_money += 10000000;
            stranger_money += money;
            money = money*2;
        }
        NumberFormat n = NumberFormat.getInstance();
        System.out.println(rich_money);
        System.out.println(n.format(stranger_money));
    }
}

public class Main {
    public static void main(String[] args) {
//        int[] array = {80,45,60};
//        int num = 60;
//        func(array,num);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        func(array,num);
    }
    public static void func(int[] array,int num){
        int count=0;
        for (int j = 0;j < array.length;j++){
            if (array[j]==num){
                count++;
            }
        }System.out.println(count);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] array = new int[n*2];
            for (int i = 0;i<array.length; i++){
                array[i] = sc.nextInt();
            }
            int m;
            for ( m=1;m<=2*n;m++){
                int index = m+1;
                for (int j=1;j<=k;j++){
                    if (index<=n){
                        index = 2*(index-1)+1;
                    }else {
                        index = 2 * (index - n);
                    }
                }System.out.print(array[m]+" ");
            }
        }
    }
}

public class Main {
    public int addAB(int A, int B) {
        // write code here
        int C = A^B;
        int D = (A&B)<<1;
        int W = addAB(C,D);
        return W;
    }
}


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    public static String GetSequeOddNum(int m) {
        int nums = (int)Math.pow(m,3);
        Queue<Integer> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        int sum=0;
        int i=0;
        for (i=1;i<1000000;i+=2){
            q.offer(i);
            if (q.size()>m){
                sum -= q.poll();
            }
            sum += i;
            if (sum == nums){
                break;
            }
        }
        if (i<1000000){
            while (!q.isEmpty()){
                str.append(q.poll());
                if (!q.isEmpty()){
                    str.append("+");
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            String s = GetSequeOddNum(n);
            System.out.println(s);
        }
    }
}


public class Main {
    public String GetSequeOddNum(int m){
        StringBuilder str = new StringBuilder();
        int nums = (int)Math.pow(m,3);
        Queue<Integer> queue = new LinkedList<>();
        int sums = 0;
        int i = 0;
        for (i = 1; i < 1000000; i += 2) {
            queue.offer(i);
            if(queue.size() > m){
                sums -= queue.poll();
            }
            sums += i;
            if(sums == nums){
                break;
            }
        }
        if(i < 1000000){
            while(!queue.isEmpty()){
                str.append(queue.poll());
                if(!queue.isEmpty()){
                    str.append("+");
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int pop = in.nextInt();
            String str = main.GetSequeOddNum(pop);
            System.out.println(str);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
    public static String GetSequeOddNum(int m){
        int n = m*(m-1);
        String s = n+"+";
        for (int i = 1; i<=m; i++){
            s += (n+2);
        }
        return s;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        for (int i=0; i<10; i++){
            array[i] = sc.nextInt();
        }
        sc.close();
        StringBuilder s = new StringBuilder();
        for (int i=1; i<10;i++){
            if (array[i]!=0){
                s.append(i);
                array[i]--;
                break;
            }
        }
        for (int j=0; j<10; j++){
            while (array[j]!=0){
                s.append(j);
                array[j]--;
            }
        }
        System.out.println(s);
    }
}


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] times = new int[10];
        for (int i = 0; i < 10; i++) {
            times[i] = in.nextInt();
        }
        in.close();

        StringBuilder s = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            if (times[i] != 0) {
                s.append(i);
                times[i]--;
                break;
            }
        }

        for (int j = 0; j < 10; j++) {
            while (times[j] != 0) {
                s.append(j);
                times[j]--;
            }
        }

        System.out.println(s);
    }
}

import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while (scan.hasNext()) {
//            String s1 = scan.next();
//            String s2 = scan.next();
//            System.out.println(AddLongInteger(s1,s2));
//        }
//        scan.close();
//    }
//    public static String AddLongInteger(String addend,String augend) {
//        int len1 = addend.length();
//        int len2 = augend.length();
//        int[] arr1 = new int[len1];
//        int[] arr2 = new int[len2];
//        for (int i = 0; i < len1; i++) {
//            arr1[i] = Integer.valueOf(addend.charAt(i)+"");
//        }
//        for (int i = 0; i < len2; i++) {
//            arr2[i] = Integer.valueOf(augend.charAt(i)+"");
//        }
//        int len = Math.max(len1,len2) + 1;
//        int[] arr = new int[len];
//        boolean flag = false;
//        while (len1 > 0 && len2 > 0) {
//            if(flag) {
//                if(arr1[len1-1] + arr2[len2-1] + 1 <= 9) {
//                    arr[len-1] = arr1[len1-1] + arr2[len2-1] + 1;
//                    flag = false;
//                }else {
//                    arr[len-1] = arr1[len1-1] + arr2[len2-1] + 1 - 10;
//                    flag = true;
//                }
//            }else {
//                if(arr1[len1-1] + arr2[len2-1] <= 9) {
//                    arr[len-1] = arr1[len1-1] + arr2[len2-1];
//                }else {
//                    arr[len-1] = arr1[len1-1] + arr2[len2-1] - 10;
//                    flag = true;
//                }
//            }
//            len1--;len2--;len--;
//        }
//        while (len1 > 0) {
//            if(flag) {
//                if(arr1[len1-1] + 1 <= 9) {
//                    arr[len-1] = arr1[len1-1] + 1;
//                    flag = false;
//                }else {
//                    arr[len-1] = arr1[len1-1] + 1 - 10;
//                    flag = true;
//                }
//            }else {
//                arr[len-1] = arr1[len1-1];
//            }
//            len1--;len--;
//        }
//        while (len2 > 0) {
//            if(flag) {
//                if(arr1[len2-1] + 1 <= 9) {
//                    arr[len-1] = arr1[len2-1] + 1;
//                    flag = false;
//                }else {
//                    arr[len-1] = arr1[len2-1] + 1 - 10;
//                    flag = true;
//                }
//            }else {
//                arr[len-1] = arr1[len2-1];
//            }
//            len2--;len--;
//        }
//        StringBuilder str = new StringBuilder();
//        if(flag) {
//            str.append(1);
//        }
//        for (int i = 1; i < arr.length; i++) {
//            str.append(arr[i]);
//        }
//        return str.toString();
//    }
//}

public class Main{
    public static String AddLongInteger(String addend,String augend){
        BigInteger s1 = new BigInteger(addend);
        BigInteger s2 = new BigInteger(augend);
        BigInteger ret = s1.add(s2);
        System.out.println(ret);
        return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            AddLongInteger(a, b);
        }
        sc.close();
    }
}
//import java.util.*;
//public class Main {
//    static  Scanner in=new Scanner(System.in);
//    public static void main(String[] args) {
//        while(in.hasNext()){
//            double n=in.nextDouble();
//            char c=in.next().charAt(0);
//            String b;
//            for (int i = 0; i < n; i++)
//                System.out.print(c);
//            System.out.println();
//            b=String.format("%.0f", n/2);
//            for (int i = 1; i <=Integer.parseInt(b)-2; i++){
//                System.out.print(c);
//                for (int j = 0; j <n-2; j++)
//                    System.out.print(" ");
//                System.out.print(c);
//                System.out.println();
//            }
//            for (int i = 0; i < n; i++)
//                System.out.print(c);
//            //System.out.println();
//        }
//    }
//}


/*
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int row = 0;
        if(n%2 == 0){
            row = n/2;
        }
        else{
            row = n/2+1;
        }
        for(int i=1; i<=row; i++){
            for(int j=1; j<=n;j++){
                if(i==1||i==row){
                     System.out.print(str);
                }else if(j==1||j==n){

                    System.out.print(str);
                }else {
                    System.out.print(" ");
                }

            }System.out.println();
        }
        return;
    }
}

public class Main{
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "100311";
//        char[] ch = str.toCharArray();
        for (char i = 0; i < 10; i++){
            int count = 0;
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == i){
                    count++;
                }
            }
            if (count > 0){
                System.out.println(i+":"+count);
            }
        }

    }
}

public class Main {
    public static int countWays(int x, int y) {
        if (x==1||y==1){
            return 1;
        }
        return countWays(x-1,y)+countWays(x,y-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ret = countWays(x,y);
        System.out.println(ret);
    }
}


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 0;
        int b = 1;
        int c = 1;
        while(N>c){
            a = b;
            b = c;
            c = a+b;
        }
        int d = c-N;
        int e = N-b;
        System.out.println(d>e?e:d);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ret = "";
        while (n!=0){
            int a = n%10;
            int b = n/10;
        }
    }
}


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 0;
        for(int i=5; i<=n; i*=5){
            ret += n/i;
        }
        System.out.println(ret);
    }
}


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int ret = 0;
        if(A == B){
            ret = A;
            System.out.println(ret);
        }
        if(A > B){
            for(int i=1; i<=B; i++){
                if((A*i)%B == 0){
                    ret = A*i;
                    System.out.println(ret);
                    break;
                }
            }
        }else{
            for(int j=1; j<=A; j++){
                if((B*j)%A == 0){
                    ret = B*j;
                    System.out.println(ret);
                    break;
                }
            }
        }
    }
}

public class Main{
    public static void shellSort(Integer[] array){
        int gap = 3;
        while (gap>0){
            for (int i =gap;i < array.length; ++i){
                int key = array[i];
                int end = i-gap;
                while (end >=0&& key < array[end] ){
                    array[end+gap] = array[end];
                    end-=gap;
                }
                array[end+gap] = key;
            }
            gap--;
        }
    }
    public static void check(Integer[] array){
        shellSort(array);
        int count = 1;
        int temp = 1;
        int ret=0;
        for (int i=0;i<array.length;i++){
            ret = array[i];
            if (array[i]==array[i+1]){
                count++;
                if (count > temp){
                    temp = count;
                    ret=array[i];
                }else {
                    break;
                }
            }else {
                count = 1;
            }
        }
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] s = str.split(" ");
            Integer [] arr = new Integer[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            check(arr);
        }
    }
}

public class Main{
    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if( ((a+c)%2!=0) || ((b+d)%2!=0) || ((d-b)%2!=0) || (c-a)%2!=0){
                System.out.println("No");
                return;
            }
            int A = (a+c)/2;
            int B = (b+d)/2;
            int C = (d-b)/2;
            if((A-B)!=a || (B-C)!=b || (A+B)!=c || (B+C)!=d){
                System.out.println("No");
                return;
            }
            System.out.println(A+" "+B+" "+C);
        }
        sc.close();
    }
}

public class Main{
    public static void func(String s1,String s2){
        ArrayList<Character> L = new ArrayList<>();
        if (s1==""||s2==""){
            return;
        }
        for (int i = 0;i<s1.length();i++){
            if (!s2.contains(s1.charAt(i)+"")){
                L.add(s1.charAt(i));
            }
        }
        for (int j=0;j<L.size();j++){
            System.out.print(L.get(j)+"");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        while(sc.hasNext()){
            func(str1,str2);
        }
    }
}


//对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
//给定一个字符串A和它的长度n,请返回一一个bool值代表它是否为一一个合法的括号串。
//一个合法的括号串定义为: 1.只包括括号字符; 2.左括号和右括号一 对应
public class Main {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> str = new Stack<>();
        for (int i = 0;i < n;i++){
            char ch = A.charAt(i);
            if (ch == '(' ){
                str.push(ch);
            }else {
                if (str.empty()){
                    return false;
                }
                char ch2 = str.peek();
                if (ch2 == '(' && ch == ')'){
                    str.pop();
                }else {
                    return false;
                }
            }
        }
        if (!str.empty()){
            return false;
        }
        return true;
    }
}

//读入一个字符串str ,输出字符串str中的连续最长的数字串
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] array = str.toCharArray();
        int count = 0;
        String ret = "";
        for (int i = 0;i < array.length;i++){
            if (array[i] >= '0'&& array[i] <= '9'){
                count = 1;
                int index = i;
                for (int j = i+1;j<array.length;j++){
                    if (array[j] >= '0'&& array[j] <= '9'){
                        count++;
                        index = j;
                    }else {
                        break;
                    }
                }
                if (count > ret.length()){
                    ret = str.substring(i,index+1);
                }else {
                    continue;
                }
            }
        }
        System.out.println(ret);
    }
}*/
