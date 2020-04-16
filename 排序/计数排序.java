/**
 * @ClassName Sort6
 * @Description TODO Sort6
 * @Author 张洋
 * @Date 2020/4/16 16:08
 * @Version 2018.1.5
 **/

//计数排序
    //场景：数据密集集中在某个范围
    //时间复杂度：O(N) N：表示区间中元素的个数
    //空间复杂度：O(M) M：表示区间中元素种类的个数
    //稳定性：稳定
public class Sort6 {
    public static void countSort(int[] array){
        // 1.统计元素的范围
        int minValue = array[0];
        int maxValue = array[0];
        for (int i=1; i<array.length;++i){
            if (array[i] > maxValue){
                maxValue = array[i];
            }
            if (array[i] < minValue){
                minValue = array[i];
            }
        }
        //2.该范围中最多包含不同元素种类的个数
        int range = maxValue - minValue + 1;
        int[] arrayCount = new int[range];
        //3.统计每个元素出现的次数
        for (int i=0; i<array.length; ++i){
            arrayCount[array[i]-minValue]++;
        }
        //4.对元素进行回收----排序
        int index = 0;
        for (int i=0;i<range;++i){
            while (arrayCount[i] != 0){
                array[index++] = i+minValue;
                arrayCount[i]--;
            }
        }
    }
    public static void printArray(int[] array){
        for (int e:array)
            System.out.print(e+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {3,1,2,3,7,8,4,8,4,3,9,2,6,7,5,8,3,5,1,4,7};
        countSort(array);
        printArray(array);
    }
}
