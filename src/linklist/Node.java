package linklist;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/11 0011
 * @Description: linklist
 * @version: 1.0
 */
public class Node {
    //数据域
    public long data;
    //指针域
    public Node next;

    public Node(long value) {
        this.data = value;
    }
    /*显示*/
    public void display() {
        System.out.print(data + " ");
    }
}
