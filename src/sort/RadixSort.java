package sort;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/30 0030
 * @Description: sort
 * @version: 1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //1.得到数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //第一轮，针对每个元素个位数进行排序处理
        //定义二维数组，表示10个桶，每个桶都是一个一维数组
        //基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶实际存放多少个数据，我们定义一个一位数组来记录每个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        //使用循环
        for (int i = 0 , n = 1; i < maxLength; i++ , n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                //放入对应的桶种
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一位数组的下标依次取出数据，放入到原来数组)
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放入
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k] = 0;
            }
            System.out.println("第"+(i+1)+"轮排序处理arr = " + Arrays.toString(arr));
        }
    }
}
        /**
        for(int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] % 10;
            //放入对应的桶种
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一位数组的下标依次取出数据，放入到原来数组)
        int index = 0;
        for(int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，才放入
            if(bucketElementCounts[k] != 0) {
                for(int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第1轮，对个位的排序处理arr = " + Arrays.toString(arr));

        //第2轮
        for(int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] / 10 % 10;
            //放入对应的桶种
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一位数组的下标依次取出数据，放入到原来数组)
        index = 0;
        for(int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，才放入
            if(bucketElementCounts[k] != 0) {
                for(int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第2轮，对十位的排序处理arr = " + Arrays.toString(arr));
        //第3轮百位
        for(int j = 0; j < arr.length; j++) {
            //取出每个元素的百位
            int digitOfElement = arr[j] / 100 % 10;
            //放入对应的桶种
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一位数组的下标依次取出数据，放入到原来数组)
        index = 0;
        for(int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，才放入
            if(bucketElementCounts[k] != 0) {
                for(int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第3轮，对百位的排序处理arr = " + Arrays.toString(arr));

    }
}
**/