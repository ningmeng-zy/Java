/**
 * @ClassName Sort5
 * @Description TODO Sort5
 * @Author 张洋
 * @Date 2020/4/14 16:55
 * @Version 2018.1.5
 **/
//冒泡排序  稳定的    适用于数据接近有序的
public class Sort5 {
    public static void BubbleSort(int[] array){
        boolean isChange = false;//用来优化冒泡排序：冒泡到一定趟数，可能已经有序了，后序的冒泡排序就不需要了
        //如果已经有序，在冒泡时肯定不需要元素交换了
        //外层循环：控制的是冒泡的趟数
        for (int i = 0; i < array.length-1; ++i){
            //具体冒泡的方式
            //一趟冒泡排序的方式：将相邻的两个元素进行比较，让大的元素往后移动
            isChange = false;
            for (int j = 1; j < array.length-i; ++j){
                if (array[j-1] > array[j]){
                    swap(array,j-1,j);
                    isChange = true;
                }
            }
            if (!isChange){
                return;
            }
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
        BubbleSort(array);
        printArray(array);
    }
}

