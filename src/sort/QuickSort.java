package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/29 0029
 * @Description: sort
 * @version: 1.0
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {-9, 78, 0, 2, 3, -2, 70, -4, 9, 456, 9000};
        quickSort(arr, 0, arr.length-1);
        System.out.println("arr=" + Arrays.toString(arr));
        //创建80000个随机的数据,测试执行的效率和时间
//        int[] arr = new int[80000];
//        for(int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//        System.out.println("排序前");
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String datestr = simpleDateFormat.format(date1);
//        System.out.println("排序的时间是=" + datestr);
//        quickSort(arr, 0, arr.length-1);
//        Date date2 = new Date();
//        String date2str = simpleDateFormat.format(date2);
//        System.out.println("排序的时间是=" + date2str);
    }
    public static void quickSort(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];
        while(l < r) {
            while(arr[l] < pivot) {
                l += 1;
            }
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r说明Pivot左边小于它，右边大于它
            if(l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换后，发现arr[l] == pivot值相等，前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            if(arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l==r,必须l++,r--,否则出现栈溢出
        if(l == r) {
            l++;
            r--;
        }
        if(left < r) {
            quickSort(arr, left, r);
        }
        if(right > l) {
            quickSort(arr, l, right);
        }
    }
}
