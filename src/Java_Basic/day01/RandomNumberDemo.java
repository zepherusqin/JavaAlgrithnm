package Java_Basic.day01;

import java.util.ArrayList;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/18 0018
 * @Description: Java_Basic.day01
 * @version: 1.0
 */
/*
 * 需求：获取10个1-20之间的随机数，要求不能重复
 *
 * 分析：
 * 		A:定义一个集合，用于存储产生的随机数
 * 		B:定义一个统计变量，初始值是0
 * 		C:判断统计变量是否小于10
 * 			是：
 * 				产生一个随机，然后判断是在集合中
 * 					是：不添加
 * 					否：添加到集合
 * 			否：结束
 * 		D:遍历集合
 */
public class RandomNumberDemo {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int count = 0;
        while(count < 10) {
            int randomNumber = (int) (Math.random() * 20) + 1;
            if(!array.contains(randomNumber)) {
                array.add(randomNumber);
                count++;
            }
        }
        for(Integer i : array) {
            System.out.println(i);
        }
    }
}
