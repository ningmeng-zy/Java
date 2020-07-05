import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description TODO Sort
 * @Author 张洋
 * @Date 2020/3/26 19:53
 * @Version 2018.1.5
 **/
public class Sort {
    public static void insertSort(int[] array){
        for (int i =1;i < array.length; ++i){
            int key = array[i];
            int end = i-1;
            while (end >=0&& key < array[end] ){
                array[end+1] = array[end];
                end--;
            }
            array[end+1] = key;
        }

    }
    public static void shellSort(int[] array){
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
    public static void printArray(int[] array){
        for (int e : array){
            System.out.print(e+" ");

        }System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {3,8,2,6,5,7,1,4,0,9};
        //insertSort(array);
        //printArray(array);
        shellSort(array);
        printArray(array);

    }
}
