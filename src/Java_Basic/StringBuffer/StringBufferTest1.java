package Java_Basic.StringBuffer;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/9 0009
 * @Description: Java_Basic.StringBuffer
 * @version: 1.0
 */
public class StringBufferTest1 {
    public static void main(String[] args) {
        int[] arr = { 11, 22, 33, 44, 55 };

        String result = arrayToString(arr);
        System.out.println(result);
    }
    public static String arrayToString(int[] arr) {
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }
        sb.append("]");

        return new String(sb);
    }
}
