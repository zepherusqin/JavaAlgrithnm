package Java_Basic;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/2 0002
 * @Description: Java_Basic
 * @version: 1.0
 */
public class StringDemo3 {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true

        String s3 = new String("hello");
        String s4 = "hello";
        System.out.println(s3 == s4);//false
        System.out.println(s3.equals(s4));//true

        String s5 = "hello";
        String s6 = "hello";
        System.out.println(s5 == s6);//true不是引用类型
        System.out.println(s5.equals(s6));//true
    }
}
