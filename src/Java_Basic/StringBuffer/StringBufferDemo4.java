package Java_Basic.StringBuffer;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/9 0009
 * @Description: Java_Basic.StringBuffer
 * @version: 1.0
 */
/*
 * public StringBuffer replace(int start,int end,String str):用给定的字符串替换从指定位置开始到指定位置结束的数据
 */
public class StringBufferDemo4 {
    public static void main(String[] args) {
        // 创建对象
        StringBuffer buffer = new StringBuffer();

        buffer.append("hello").append("world").append("java");

        // public StringBuffer replace(int start,int end,String)
        // str):用给定的字符串替换从指定位置开始到指定位置结束的数据
        buffer.replace(3, 8, "haha");

        System.out.println("buffer:" + buffer);
    }
}
