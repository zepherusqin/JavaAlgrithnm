package Java_Basic;

import java.util.Scanner;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: Java_Basic
 * @version: 1.0
 */
/*
 * 字符串反转
 * 举例：键盘录入”abc”		输出结果：”cba”
 */
public class StringDemoTest6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = sc.nextLine();
        String res = reverse(s);
        System.out.println(res);
    }
    public static String reverse(String s) {
        String res = "";
        char[] chs = s.toCharArray();//把字符串转为字符数组
        for(int i = chs.length - 1; i >= 0; i--) {
            res += chs[i];
        }
        return res;
    }
}
