package exercise;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/30 0030
 * @Description: exercise
 * @version: 1.0
 */
public class radixsort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        RadixSort(arr);
    }
    public static void RadixSort(int[] arr) {
        //用二维数组表示10个桶，每个桶都是一个一维数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for(int j = 0; j < arr.length; j++) {
            //取出每个数据的个位数字
            int digitOfElement = arr[j] % 10;
            //放入对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序，依次取出元素，放入原来的数组中
        int index = 0;
        for(int k = 0; k < bucketElementCounts.length; k++) {
            //当桶中有数据时，才取出
            if(bucketElementCounts[k] != 0) {
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第1轮，对个位的排序处理arr = " + Arrays.toString(arr));

        for(int j = 0; j < arr.length;j++) {
            int digitOfElement = arr[j] / 10 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        index = 0;
        for(int k = 0; k < bucketElementCounts.length; k++) {
            if(bucketElementCounts[k] != 0) {
                for(int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
        }
        System.out.println("第2轮，对十位的排序处理arr = " + Arrays.toString(arr));
    }
}
