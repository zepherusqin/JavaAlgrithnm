package Java_Basic.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/6 0006
 * @Description: Java_Basic.Arrays
 * @version: 1.0
 */
public class ArrayDemo4 {
    public static void main(String[] args) {
        String s = "dacgebf";
        char[] chs = s.toCharArray();
        bubbleSort(chs);
        String res = String.valueOf(chs);
        System.out.println(res);
    }
    public static void bubbleSort(char[] chs) {
        for(int i = 0; i < chs.length - 1; i++) {
            for(int j = 0; j < chs.length - i -1; j++) {
                if(chs[j] > chs[j + 1]) {
                    char temp = chs[j];
                    chs[j] = chs[j + 1];
                    chs[j + 1] = temp;
                }
            }
        }
    }
}
