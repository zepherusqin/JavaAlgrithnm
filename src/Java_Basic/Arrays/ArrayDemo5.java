package Java_Basic.Arrays;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/6 0006
 * @Description: Java_Basic.Arrays
 * @version: 1.0
 */
/*
 * Arrays:针对数组进行操作的工具类。提供了排序，查找等功能。
 *
 * 成员方法：
 * 		public static String toString(int[] a):把数组转成字符串
 *		public static void sort(int[] a):排序(快速排序)
 *		public static int binarySearch(int[] a,int key):二分查找
 *	    return -(low + 1);  // key not found.
 *
 * 注意：
 * 		如果数组本身是无序的，不能直接使用二分查找。
 * 		并且，先排序，再二分也是有问题的，因为这样就改变了数组中元素原始的索引位置。
 */
public class ArrayDemo5 {
    public static void main(String[] args) {
        int[] arr = { 24, 13, 69, 80, 57 };
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 80));
    }
}
