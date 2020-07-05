package Java_Basic;

import java.util.Scanner;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/1 0001
 * @Description: Java_Basic
 * @version: 1.0
 */
/*
 * public int nextInt():获取一个int类型的数据
 * public String nextLine():获取一个字符串类型的数据
 */
public class ScannerDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
    }
}
