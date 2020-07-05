package Java_Basic.Arrays;



/**
 * @Author:QinZhubiao
 * @Date: 2020/4/6 0006
 * @Description: Java_Basic.Arrays
 * @version: 1.0
 */
public class ArrayDemo1 {
    public static void main(String[] args){
        int[] arr = { 24, 69, 80, 57, 13 };
        System.out.println("排序前的数组：");
        printArray(arr);
        System.out.println("排序后的数组：");
        bubbleSort(arr);
        printArray(arr);
    }
    // 遍历数组
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x] + ", ");
            }
        }
        System.out.println("]");
    }
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
