package Java_Basic;

import java.util.Scanner;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: Java_Basic
 * @version: 1.0
 */
/*
 * 把一个字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
 * 举例：helloWorldAbCde
 * 结果：Helloworldabcde
 *
 * 分析：
 * 		A:键盘录入一个字符串
 * 		B:截取首字母得到s1
 * 		C:截取除首字母以外的其他字符串得到s2
 * 		D:s1转大写+s2转小写
 */
public class StringDemoTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.nextLine();
        String s1 = s.substring(0, 1);
        String s2 = s.substring(1);
        String res = s1.toUpperCase().concat(s2.toLowerCase());
        System.out.println(res);
    }
}
