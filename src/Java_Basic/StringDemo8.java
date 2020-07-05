package Java_Basic;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: Java_Basic
 * @version: 1.0
 */
/*
* 1.String replace(char old,char new)
* String replace(String old,String new)
* 2.String trim()
* 3.按字典顺序比较两个字符串  a-z
* int compareTo(String str)
* int compareToIgnoreCase(String str)
*/
public class StringDemo8 {
    public static void main(String[] args) {
        String s = "helloworld";
        String s2 = s.replace('h', 'H');
        System.out.println("s=" + s);
        System.out.println("s2=" + s2);
        String s3 = s.replace("llo", "hhh");
        System.out.println("s3=" + s3);

        String s4 = "     hello  world           ";
        System.out.println(s4);
        System.out.println("---" + s4 + "---");
        System.out.println("---" + s4.trim() + "---");

        String s5 = "hello";
        System.out.println(s.compareTo("hello")); // 0
        System.out.println(s.compareTo("Hello")); // 32
        System.out.println(s.compareTo("mello")); // -5
        System.out.println(s.compareTo("hgllo"));//第一个不同字母之差
    }
}
