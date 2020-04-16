/**
 * @ClassName Sort2
 * @Description TODO Sort2
 * @Author 张洋
 * @Date 2020/4/11 22:14
 * @Version 2018.1.5
 **/
public class Sort2 {
    //选择排序
    public static void selectSort(int[] array){
        for(int i=0; i<array.length-1; i++){//总共要选择的次数  每次选择最大的
            //array.length-1最后一趟选择时，区间中只有最后一个元素，一个元素自己和自己就算排好了，因此不需要选择
            //具体选择的方式:找最大元素的位置
            int maxPos = 0;
            for (int j=1; j<array.length-i; j++){
                //array.length-i表示剩的元素个数
                if (array[j]>array[maxPos]){
                    maxPos = j;
                }
            }
            //将maxPos标记的最大元素放到最后。
            if (array.length-1-i != maxPos){
                swap(array,maxPos,array.length-1-i);
            }
        }
    }
    public static void selectSortOP(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            int maxPos = begin;
            int minPos = begin;
            int index = begin + 1;
            while (index < end) {
                if (array[index] > array[maxPos]) {
                    maxPos = index;
                }
                if (array[index] < array[minPos]) {
                    minPos = index;
                }
                ++index;
            }
            if (maxPos != end) {
                swap(array, maxPos, end);
            }
            if (minPos == end) {
                minPos = maxPos;
            }
            if (minPos != begin) {
                swap(array, minPos, begin);
            }
            begin++;
            end--;
        }
    }
    public static void swap(int[] array,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static void printArray(int[] array){
        for (int e:array)
            System.out.print(e+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 6, 9, 7, 1, 4, 0, 5};
        selectSort(array);
        printArray(array);
    }
}
