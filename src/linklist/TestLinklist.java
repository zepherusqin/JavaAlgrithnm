package linklist;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/11 0011
 * @Description: linklist
 * @version: 1.0
 */
public class TestLinklist {
    public static void main(String[] args) {
        Linklist linklist = new Linklist();
        linklist.insertFirst(34);
        linklist.insertFirst(22);
        linklist.insertFirst(16);
        linklist.insertFirst(0);
        linklist.insertFirst(-1);
        linklist.display();
        //System.out.println();
        linklist.deleteFirst();
        linklist.display();

        Node node = linklist.find(22);
        node.display();
        System.out.println();
        linklist.display();
       // System.out.println();

        Node node1 = linklist.deleteByvalue(16);
        node1.display();
        System.out.println();
        linklist.display();
    }
}
