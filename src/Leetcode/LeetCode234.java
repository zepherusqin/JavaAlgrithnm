package Leetcode;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/29 0029
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode234 {
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    //第一步找到中点
    //从中点开始将后续结点反转
    //两遍开始next比较直到相遇
    //设置快慢指针，快指针每次走两个结点的位置，慢指针每次走一个结点的位置，这样当快指针走到最后时，慢指针就到了中间
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        if(head.next.next == null){
            return head.val == head.next.val;
        }
        //寻找中心位置
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表倒转
        ListNode pre = null;
        ListNode temp = null;
        while(slow != null){
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        ListNode tail = pre;
        //头尾比较
        while(head != null){
            if(head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode node7 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node6.next = node7;
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        System.out.println("===="+isPalindrome(node1));
    }
}

