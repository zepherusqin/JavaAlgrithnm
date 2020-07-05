package Java_Basic.StringBuffer;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/9 0009
 * @Description: Java_Basic.StringBuffer
 * @version: 1.0
 */
public class StringBufferDemo5 {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();

        buffer.append("java").append("hello");

        buffer.reverse();

        System.out.println("buffer:" + buffer);
    }
}
