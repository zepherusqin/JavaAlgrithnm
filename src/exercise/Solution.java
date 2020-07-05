package exercise;
/**
 * @Author:QinZhubiao
 * @Date: 2020/4/5 0005
 * @Description: exercise
 * @version: 1.0
 */
public class Solution {
    public static void main(String[] args) {
        Node head = new Node(3);
       // head.next = new Node(5);
        //head.next.next = new Node(2);
        //head.next.next.next = new Node(7);
       // head.toPrint();
        Node node1 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(6);
        Node node5 = new Node(8);
        Node node6 = new Node(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        head.toPrint();
        System.out.println();
        Solution s = new Solution();
        s.mergeSort(head).toPrint();
    }

    public Node mergeSort(Node head) {
        if(head == null) {
            return  null;
        }
        if(head.next == null) {
            return head;
        }
        Node minHead = findMiddle(head);
        return merge(mergeSort(head), mergeSort(minHead));
    }
    private Node merge(Node p1, Node p2) {
        Node dummy = new Node(-1);
        Node p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
    private Node findMiddle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node minHead = slow.next;
        slow.next = null;//断开链表
        return minHead;
    }
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
        void toPrint() {
            Node p = this;
            while (p != null) {
                System.out.print(p.value + " ");
                p = p.next;
            }
        }
    }
}
