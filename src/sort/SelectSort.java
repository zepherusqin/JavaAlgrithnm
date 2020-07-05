package sort;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/24 0024
 * @Description: sort
 * @version: 1.0
 */
public class SelectSort {
    public static void main(String[] args){
        int arr[] = {101, 34, 119, 1};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序之后：");
        System.out.println(Arrays.toString(arr));

    }
    //时间复杂度O(n^2)
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
