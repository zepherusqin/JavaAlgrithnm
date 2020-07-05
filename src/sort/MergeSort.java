package sort;



import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/29 0029
 * @Description: sort
 * @version: 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println("归并排序后=" + Arrays.toString(arr));
    }
    //分+合方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if(left < right) {
            int mid = (left+right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid+1, right, temp);
            //到合并时
            merge(arr, left, mid, right, temp);
        }
    }
    //合并方法
    /**
     *功能描述：
     *@param：arr 排序的原始数组
     *@param: left 左边有序序列的初始索引
     *@param: mid 中间索引
     *@param: right 右边索引
     *@param: temp 中转数组
     *@date:
    **/
    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        System.out.println("XXXXXX");
       int i = left;//左边有序序列的初始索引
       int j = mid + 1;//左边有序序列的初始索引
       int t = 0;
       //先把左右两边的数组按规矩填充到temp数组中
        // 直到左右两边有一边处理完毕
       while(i <= mid && j <= right) {
           if(arr[i] <= arr[j]) {
               temp[t] = arr[i];
               t += 1;
               i += 1;
           } else {
               temp[t] = arr[j];
               t += 1;
               j += 1;
           }
       }
       //把有剩余的一边的数据依次全部填充进去
        while(i <= mid) {
           temp[t] = arr[i];
           t += 1;
           i += 1;
        }
        while(j <= right) {
           temp[t] = arr[j];
           t += 1;
           j += 1;
        }
       //将temp数组的元素拷贝到arr
       //注意并不是每次都拷贝所有
       t = 0;
       int tempLeft = left;
       while(tempLeft <= right) {//每次拷贝的数据个数不一样，总共拷贝7次
           arr[tempLeft] = temp[t];
           t += 1;
           tempLeft += 1;
       }

    }
}
