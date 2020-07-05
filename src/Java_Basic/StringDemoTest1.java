package Java_Basic;

import java.util.Scanner;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/2 0002
 * @Description: Java_Basic
 * @version: 1.0
 */
/*
 * 模拟登录,给三次机会,并提示还有几次。
 *
 * 分析：
 * 		A:给出固定的用户名和密码
 * 		B:键盘录入用户名和密码
 * 		C:比较用户名和密码
 * 		D:给出三次机会
 */
public class StringDemoTest1 {
    public static void main(String[] args) {
        // 给出固定的用户名和密码
        // String username = "admin";
        // String password = "admin";
        for (int x = 0; x < 3; x++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String name = sc.nextLine();
            System.out.println("请输入密码");
            String passwd = sc.nextLine();

            if("admin".equals(name) && "admin".equals(passwd)) {
                System.out.println("登录成功");
                break;
            } else {
                if (2 - x == 0) {
                    System.out.println("帐号被锁定，请与班长联系");
                } else {
                    // 2,1,0
                    System.out.println("登录失败，你还有" + (2 - x) + "次机会");
                }
            }
        }
    }
}
