/*
通过先序和中序数组生成后序数组
给出一棵二叉树的先序和中序数组，通过这两个数组直接生成正确的后序数组。
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pre = new int[n];
        for(int i=0;i<n;i++){
            pre[i] = sc.nextInt();
        }
        int[] mid = new int[n];
        for(int j=0;j<n;j++){
            mid[j] = sc.nextInt();
        }
        int[] pos = getPos(pre,mid);
        for(int m=0;m<n;m++){
            System.out.print(pos[m]+" ");
        }
    }
    public static int[] getPos(int[] pre,int[] mid){
        if(pre == null || mid == null){
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++){
            map.put(mid[i],i);
        }
        setPos(pre,0,len-1,mid,0,len-1,pos,len-1,map);
        return pos;
    }
    public static int setPos(int[] pre,int preStart,int preEnd,int[] mid,int midStart,
                             int midEnd,int[] pos,int posSet,HashMap<Integer,Integer> map){
        if(preStart > preEnd){
            return posSet;
        }
        pos[posSet--] = pre[preStart];
        int i = map.get(pre[preStart]);
        posSet = setPos(pre,preEnd - midEnd + i + 1,preEnd,mid,i+1,midEnd,pos,posSet,map);
        return setPos(pre,preStart+1,preStart+i-midStart,mid,midStart,i-1,pos,posSet,map);
    }
}
