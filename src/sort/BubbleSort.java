package sort;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/23 0023
 * @Description: sort
 * @version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        //时间复杂度：O(n^2)
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }
}
