package Java_Basic.StringBuffer;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/9 0009
 * @Description: Java_Basic.StringBuffer
 * @version: 1.0
 */
/*
 * 截取功能:返回值类型是String类型，本身没有发生改变
 * public String substring(int start):从指定位置开始到末尾
 * public String substring(int start,int end):从指定位置开始到指定位置结束
 */
public class StringBufferDemo6 {
    public static void main(String[] args) {
        // 创建对象
        StringBuffer buffer = new StringBuffer();
        buffer.append("helloworldjava");

        // public String substring(int start):从指定位置开始到末尾
        String s = buffer.substring(5);

        System.out.println("s:" + s);
        System.out.println("buffer:" + buffer);
    }
}
