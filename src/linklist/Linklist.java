package linklist;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/11 0011
 * @Description: linklist
 * @version: 1.0
 */
public class Linklist {
    //头结点
    private Node first;
    public Linklist() {
        first = null;
    }
    /*插入一个结点，在头结点后插入*/
    public void insertFirst(long value) {
        Node node = new Node(value);
        node.next = first;
        first = node;
    }

    /*删除一个节点，在头结点后删除*/
    public Node deleteFirst() {
        Node tmp = first;
        first = tmp.next;
        return tmp;
    }

    /*显示方法*/
    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
    /*查询方法*/
    public Node find(long value) {
        Node current = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }
    public Node deleteByvalue(long value) {
        Node current = first;
        Node previous = first;
        while (current.data != value) {
            if(current.next == null) {
                return null;
            }
            previous = current;//保存当前的current
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
 }
