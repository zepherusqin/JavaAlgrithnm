package Java_Basic.ArrayList_Vector_LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/18 0018
 * @Description: Java_Basic.ArrayList_Vector_LinkedList
 * @version: 1.0
 */
/*
 * 去除集合中字符串的重复值(字符串的内容相同)
 * 举例：
 * 		hello,world,java,android,world,java,javaee,java,java,java,android
 * 结果：
 * 		hello,world,java,android,javaee
 *
 * 创建新集合的方式：
 * 		A:定义集合，存储带重复的元素
 * 		B:创建新集合
 * 		C:遍历旧集合，获取到旧集合中的每一个元素
 * 		D:那旧集合的每一个元素到新集合中去找，看有没有
 * 			有：就不添加(不搭理它)
 * 			木有：就添加
 * 		E:遍历新集合
 */
public class ArrayTest01 {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        array.add("hello");
        array.add("world");
        array.add("java");
        array.add("android");
        array.add("world");
        array.add("java");
        array.add("javaee");
        array.add("java");
        array.add("java");
        array.add("java");
        array.add("android");
        ArrayList newArray = new ArrayList();
        for(int i = 0; i < array.size(); i++) {
            String string = (String) array.get(i);
            if(!newArray.contains(string)) {
                newArray.add(string);
            }
        }

        Iterator it = newArray.iterator();
        while(it.hasNext()) {
            String string = (String) it.next();
            System.out.println(string);
        }
    }
}
