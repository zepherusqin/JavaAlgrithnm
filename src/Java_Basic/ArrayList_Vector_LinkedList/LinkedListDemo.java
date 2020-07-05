package Java_Basic.ArrayList_Vector_LinkedList;

import java.util.LinkedList;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/18 0018
 * @Description: Java_Basic.ArrayList_Vector_LinkedList
 * @version: 1.0
 */
/*
 * LinkedList的特有功能：
 * 		A:添加功能
 * 			void addFirst()
 * 			void addLast()
 * 		B:移除功能
 * 			Object removeFirst()
 * 			Object removeLast()
 * 		C:获取功能
 * 			Object getFirst()
 * 			Object getLast()
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("java");
        linkedList.add("nice");
        linkedList.add("to");
        linkedList.add("meet");
        linkedList.add("you");
        linkedList.addFirst("javaee");
        System.out.println("removeFirst=" + linkedList.removeFirst());
        System.out.println("removeLast=" + linkedList.removeLast());
        System.out.println("getFirst=" + linkedList.getFirst());
        System.out.println("getLast=" + linkedList.getLast());
    }
}
