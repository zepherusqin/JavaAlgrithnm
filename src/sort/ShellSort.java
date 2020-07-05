package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/28 0028
 * @Description: sort
 * @version: 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //shellSort(arr);
        //创建80000个随机的数据
        int[] arr = new int[80000];
        for(int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = simpleDateFormat.format(date1);
        System.out.println("排序的时间是=" + datestr);
        //shellSort(arr);
        shellSort2(arr);
        Date date2 = new Date();
        String date2str = simpleDateFormat.format(date2);
        System.out.println("排序的时间是=" + date2str);
        //System.out.println(Arrays.toString(arr));

    }

//    public static void shellSort(int[] arr) {
//        int temp = 0;
//        int count = 0;
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            for (int i = gap; i < arr.length; i++) {
//                //遍历各组所得的元素
//                for (int j = i - gap; j >= 0; j -= gap) {
//                    //如果当前元素大于加上步长后的那个元素，说明交换
//                    if (arr[j] > arr[j + gap]) {
//                        temp = arr[j];
//                        arr[j] = arr[j + gap];
//                        arr[j + gap] = temp;
//                    }
//                }
//            }
//          //  System.out.println("希尔排序第" + (count + 1) + "轮后=" + Arrays.toString(arr));
//        }
//    }
    //移位法
    public static void shellSort2(int[] arr) {
        for(int gap = arr.length/2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的进行直接插入排序
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]) {
                    while(j - gap >= 0 && temp < arr[j-gap]) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出循环后，就找到了位置
                    arr[j] = temp;
                }
            }
        }
    }
}
        /**
        //希尔排序第一轮
        //第一轮排序将10个数分成了5组
        for(int i = 5; i < arr.length; i++) {
            //遍历各组所得的元素
            for(int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+5]) {
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));

        //第二轮排序分成5/2组
        for(int i = 2; i < arr.length; i++) {
            //遍历各组所得的元素
            for(int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+2]) {
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后=" + Arrays.toString(arr));

        //第三轮排序1组
        for(int i = 1; i < arr.length; i++) {
            //遍历各组所得的元素
            for(int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后=" + Arrays.toString(arr));
    }
         **/
