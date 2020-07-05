package Java_Basic.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/6 0006
 * @Description: Java_Basic.Arrays
 * @version: 1.0
 */
/*
 * 查找元素：
 * 		基本查找  数组元素无序
 *		二分查找  数组元素有序(折半查找)
 */
public class ArrayDemo3 {
    public static void main(String[] args) {
        int[] arr = { 13, 24, 57, 69, 80 };
        int index = getIndex(arr, 80);
        System.out.println(index);
    }
    public static int getIndex(int[] arr, int value) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int middleIndex = (maxIndex + minIndex) / 2;
        while(arr[middleIndex] != value) {
            if(arr[middleIndex] > value) {
                maxIndex = middleIndex - 1;
            } else if(arr[middleIndex] < value) {
                minIndex = middleIndex + 1;
            }
            if(minIndex > maxIndex) {
                return -1;
            }
            middleIndex = (maxIndex + minIndex) / 2;
        }
       return middleIndex;
    }
}
