/**
 * @ClassName Sort4
 * @Description TODO Sort4
 * @Author 张洋
 * @Date 2020/4/14 14:20
 * @Version 2018.1.5
 **/
//归并排序  稳定的
public class Sort4 {
    //[left,mid) [mid,right)
    private static void mergeData(int[] array, int left, int mid, int right, int[] temp){
        int index = left;
        int begin1 = left , end1 = mid , begin2 = mid , end2 = right;
        while (begin1 < end1 && begin2 < end2){
            if (array[begin1] <= array[begin2]){
                temp[index++] = array[begin1++];
            }else {
                temp[index++] = array[begin2++];
            }
        }
        //如果第一个区间中还有数据
        while (begin1 < end1){
            temp[index++] = array[begin1++];
        }
        //如果第二个区间中还有数据
        while (begin2 < end2){
            temp[index++] = array[begin2++];
        }
    }
    private static void mergeSort(int[] array, int left, int right, int[] temp){
//        if (right-left < 16){
//            inserSort(array,left,right);
//        }else {
//
//        }
        if (right-left > 1){
            int mid = left+((right-left)>>1);
            //[left,mid)....左半部分
            mergeSort(array,left,mid,temp);
            // [mid,right)....右半部分
            mergeSort(array,mid,right,temp);
            //归并
            mergeData(array,left,mid,right,temp);
            //归并结束后有序序列存储在temp中
            //将temp中的数据拷贝到array中去
            System.arraycopy(temp,left,array,left,right-left);
        }
    }
    public static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        //mergeSort(array,0,array.length,temp);
        mergeSortNor(array);
    }

    public static void mergeSortNor(int[] array){
        int[] temp = new int[array.length];
        int gap = 1;
        while (gap < array.length){
            for (int i = 0; i < array.length; i += gap*2){
                int left = i;
                int mid = left+gap;
                int right = mid+gap;
                if (mid > array.length){
                    mid = array.length;
                }
                if (right > array.length){
                    right = array.length;
                }
                mergeData(array,left,mid,right,temp);
            }
            System.arraycopy(temp,0,array,0,array.length);
            //gap *= 2;
            gap <<= 1;
        }
    }

    public static void printArray(int[] array){
        for (int e:array)
            System.out.print(e+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 6, 9, 7, 1, 4, 0, 5};
        mergeSort(array);
        printArray(array);
    }
}
