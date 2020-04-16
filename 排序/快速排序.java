/**
 * @ClassName Sort3
 * @Description TODO Sort3
 * @Author 张洋
 * @Date 2020/4/12 11:41
 * @Version 2018.1.5
 **/
//快速排序
public class Sort3 {
    public static void insertSort(int[] array, int left, int right){
        int tmp,j;
        for (int i = left+1; i < right; i++) {
            tmp = array[i];
            for (j = i-1; j >=left; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                }  break;
            }
            array[j+1] = tmp;
        }
    }

    public static void quickSort(int[] array, int left, int right){
        if (right-left<8) {
            insertSort(array,left,right);
        }else {

            //说明区间中至少有两个元素
            //按照基准值对[left，right）区间进行分割
            int div = partion1(array,left,right);
            //递归基准值的左半侧
            quickSort(array,left,div);
            //递归基准值的右半侧
            quickSort(array,div+1,right);
        }
    }
    //取基准值的优化
    //从区间最左侧、中间、最右侧取基准值，对该三个位置的基准值进行比较，返回比较结果的中间值
    //三数取中法
    public static int getIndexOfMiddle(int[] array, int left, int right){
        //使用三数取中法对每次取到最值的概率进行优化
        int mid = left+((right-left)>>1);
        if (array[left] < array[right-1]){
            if (array[mid] < array[left]){
                return left;
            }
            else if (array[mid] > array[right-1]){
                return right-1;
            }else {
                return mid;
            }
        }else {
            if (array[mid] > array[left]){
                return left;
            }else if (array[mid] < array[right-1]){
                return right-1;
            }else {
                return mid;
            }

        }
    }

    //horen
    public static int partion1(int[]array,int left, int right){
        int begin = left;
        int end = right-1;
        int mid = getIndexOfMiddle(array,left,right);
        swap(array,mid,right-1);
        int key = array[end];
        while (begin<end){
            while (begin< end && array[begin]<=key){
                begin++;
            }
            while (begin<end && array[end]>=key){
                end--;
            }
            if (begin<end){
                swap(array,begin,end);
            }
        }
        if (begin != right-1){
            swap(array,begin,right-1);
        }
        return begin;
    }

    //挖坑法
    public static int partion2(int[]array,int left, int right) {
        int begin =  left;
        int end = right-1;
        int mid = getIndexOfMiddle(array,left,right);
        swap(array,mid,right-1);
        int key = array[end];
        while (begin<end){
            while (begin<end && array[begin]<key){
                begin++;
            }
            if (begin<end){
                array[end--] = array[begin];
            }
            while (begin<end && array[end]>key){
                end--;
            }
            if (begin<end){
                array[begin++] = array[end];
            }
        }
        array[begin]=key;
        return begin;
    }
    public static int partion3(int[]array,int left, int right) {
        int cur = left;
        int pre = cur-1;
        int mid = getIndexOfMiddle(array,left,right);
        swap(array,mid,right-1);
        int key = array[right-1];
        while (cur<right){
            if (array[cur] < key && ++pre != cur){
                swap(array,cur,pre);
            }
            cur++;
        }
        if (++pre != right-1){
            swap(array,pre,right-1);
        }
        return pre;

    }


    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void printArray(int[] array){
        for (int e:array){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 6, 9, 7, 0, 1, 4, 5};
        quickSort(array,0,array.length);
        printArray(array);
    }
}

