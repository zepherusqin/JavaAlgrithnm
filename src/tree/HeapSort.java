package tree;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/3 0003
 * @Description: tree
 * @version: 1.0
 */
public class HeapSort {
    public static void main(String[] args){
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }
    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
        int temp = 0;
        //分步实现
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for(int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }
    //将一个数组调整一个大根堆
    /**
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整，逐渐减少
     **/
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        //开始调整
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k+1]) {//说明左子节点的值小于右子节点
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//!!! i指向k,继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后，已经将以i为父节点的树的最大值，放到了最顶
        arr[i] = temp;
    }
}
