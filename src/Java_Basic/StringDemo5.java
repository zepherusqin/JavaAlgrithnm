package Java_Basic;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/2 0002
 * @Description: Java_Basic
 * @version: 1.0
 */
/*
 * String类的判断功能：
 * boolean equals(Object obj):比较字符串的内容是否相同，严格区分大小写
 * boolean equalsIgnoreCase(String str):比较字符串的内容是否相同，不考虑大小写
 * boolean contains(String str):判断是否包含指定的小串
 * boolean startsWith(String str):判断是否以指定的字符串开头
 * boolean endsWith(String str):判断是否以指定的字符串结尾
 * boolean isEmpty():判断字符串的内容是否为空
 */
public class StringDemo5 {
    public static void main(String[] args) {
        String s = "helloworld";
        // boolean equals(Object obj):比较字符串的内容是否相同，严格区分大小写
        System.out.println("equals():" + s.equals("helloworld"));//true
        System.out.println("equals():" + s.equals("HelloWorld"));//false
        System.out.println("----------------------------------");

        // boolean equalsIgnoreCase(String str):比较字符串的内容是否相同，不考虑大小写
        System.out.println("equalsIgnoreCase():"
                + s.equalsIgnoreCase("helloworld"));//true
        System.out.println("equalsIgnoreCase():"
                + s.equalsIgnoreCase("HelloWorld"));//true
        System.out.println("----------------------------------");

        // boolean contains(String str):判断是否包含指定的小串
        System.out.println("contains():" + s.contains("owo"));//true
        System.out.println("contains():" + s.contains("hw"));//false
        System.out.println("----------------------------------");

        // boolean startsWith(String str):判断是否以指定的字符串开头
        System.out.println("startsWith():" + s.startsWith("hw"));//false
        System.out.println("startsWith():" + s.startsWith("owo"));//false
        System.out.println("startsWith():" + s.startsWith("h"));//true
        System.out.println("----------------------------------");

        // boolean isEmpty():判断字符串的内容是否为空
        System.out.println("isEmpty():" + s.isEmpty());
        // System.out.println("isEmpty():"+null.isEmpty());
        // //错误，对象为null，说明对象不存在，对象不存在，就不能调用方法
        System.out.println("isEmpty():" + "".isEmpty());
    }
}
