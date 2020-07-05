package Java_Basic;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: Java_Basic
 * @version: 1.0
 */

/*
 * 把数组中的数据按照指定格式拼接成一个字符串
 * 举例：int[] arr = {1,2,3};
 * 输出结果：[1, 2, 3]
 */
public class StringDemoTest5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String res = ArrayToString(arr);
        System.out.println(res);
    }
    public static String ArrayToString(int[] arr) {
        String s = "";
        s += "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s += arr[i];
            } else {
                s += arr[i];
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
