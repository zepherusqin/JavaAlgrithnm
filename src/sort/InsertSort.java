package sort;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/24 0024
 * @Description: sort
 * @version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
       int arr[] = {101, 34, 119, 1};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序之后：");
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int arr[]) {
        for(int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
            //System.out.println("第"+(i+1)+"轮后:");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
