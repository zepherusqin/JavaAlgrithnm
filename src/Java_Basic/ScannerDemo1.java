package Java_Basic;

import java.util.Scanner;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/1 0001
 * @Description: Java_Basic
 * @version: 1.0
 */

/*
 * 成员方法：
 * 		hasNextXxx():判断下一个输入项是不是指定的数据类型
 * 		nextXxx():获取该类型的数据
 *
 * 注意：
 * 		键盘录入数据，需要的是int类型，我却给了一个字符串。
 * 		在控制台就提示：InputMismatchException	输入不匹配异常。
 *
 */
public class ScannerDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input an integer:");
        if (sc.hasNextInt()) {
            int number = sc.nextInt();
            System.out.println(number);
        }
        System.out.println("over");
    }
}
