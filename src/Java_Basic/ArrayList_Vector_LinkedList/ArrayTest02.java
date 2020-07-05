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
 * 和数组排序的选择排序思想一样。
 */
public class ArrayTest02 {
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
        for(int i = 0; i < array.size() - 1; i++) {
            for(int j = i + 1; j < array.size(); j++) {
                if(array.get(i).equals(array.get(j))) {
                    array.remove(j);
                    j--;
                }
            }
        }
        Iterator iterator = array.iterator();
        while(iterator.hasNext()) {
            String string = (String)iterator.next();
            System.out.println(string);
        }
    }
}
